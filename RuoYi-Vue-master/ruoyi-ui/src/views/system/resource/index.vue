<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="讲课编号" prop="lectureId">
        <el-input
          v-model="queryParams.lectureId"
          placeholder="请输入讲课编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资源类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择资源类型" clearable>
          <el-option
            v-for="dict in dict.type.cur_resource_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="资源名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入资源名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否可以下载" prop="downloadable">
        <el-input
          v-model="queryParams.downloadable"
          placeholder="请输入是否可以下载"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否可读" prop="readable">
        <el-input
          v-model="queryParams.readable"
          placeholder="请输入是否可读"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否授课后开放" prop="lectured">
        <el-input
          v-model="queryParams.lectured"
          placeholder="请输入是否授课后开放"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="附件文件路径" prop="attachment">
        <el-input
          v-model="queryParams.attachment"
          placeholder="请输入附件文件路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:resource:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:resource:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:resource:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:resource:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="resourceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="resourceId" />
      <el-table-column label="讲课编号" align="center" prop="lectureId" />
      <el-table-column label="资源类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cur_resource_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="资源名称" align="center" prop="name" />
      <el-table-column label="是否可以下载" align="center" prop="downloadable">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.downloadable"/>
        </template>
      </el-table-column>
      <el-table-column label="是否可读(0可读；1不可读)" align="center" prop="readable">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.readable"/>
        </template>
      </el-table-column>
      <el-table-column label="是否授课后开放" align="center" prop="lectured">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.lectured"/>
        </template>
      </el-table-column>
      <el-table-column label="附件文件路径" align="center" prop="attachment" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:resource:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:resource:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改课程资源，比如教学大纲，教案，电子教材以及实验要求等对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="讲课编号" prop="lectureId">
          <el-input v-model="form.lectureId" placeholder="请输入讲课编号" />
        </el-form-item>
        <el-form-item label="资源类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择资源类型">
            <el-option
              v-for="dict in dict.type.cur_resource_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="资源名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入资源名称" />
        </el-form-item>
        <el-form-item label="是否可以下载" prop="downloadable">
          <el-input v-model="form.downloadable" placeholder="请输入是否可以下载" />
        </el-form-item>
        <el-form-item label="是否可读(0可读；1不可读)" prop="readable">
          <el-input v-model="form.readable" placeholder="请输入是否可读(0可读；1不可读)" />
        </el-form-item>
        <el-form-item label="是否授课后开放" prop="lectured">
          <el-input v-model="form.lectured" placeholder="请输入是否授课后开放" />
        </el-form-item>
        <el-form-item label="附件文件路径" prop="attachment">
          <el-input v-model="form.attachment" placeholder="请输入附件文件路径" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listResource, getResource, delResource, addResource, updateResource } from "@/api/system/resource";

export default {
  name: "Resource",
  dicts: ['cur_resource_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 课程资源，比如教学大纲，教案，电子教材以及实验要求等表格数据
      resourceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        lectureId: null,
        type: null,
        name: null,
        downloadable: null,
        readable: null,
        lectured: null,
        attachment: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        lectureId: [
          { required: true, message: "讲课编号不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "资源类型不能为空", trigger: "change" }
        ],
        name: [
          { required: true, message: "资源名称不能为空", trigger: "blur" }
        ],
        downloadable: [
          { required: true, message: "是否可以下载不能为空", trigger: "blur" }
        ],
        readable: [
          { required: true, message: "是否可读(0可读；1不可读)不能为空", trigger: "blur" }
        ],
        lectured: [
          { required: true, message: "是否授课后开放不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询课程资源，比如教学大纲，教案，电子教材以及实验要求等列表 */
    getList() {
      this.loading = true;
      listResource(this.queryParams).then(response => {
        this.resourceList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        resourceId: null,
        lectureId: null,
        type: null,
        name: null,
        downloadable: null,
        readable: null,
        lectured: null,
        attachment: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.resourceId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加课程资源，比如教学大纲，教案，电子教材以及实验要求等";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const resourceId = row.resourceId || this.ids
      getResource(resourceId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改课程资源，比如教学大纲，教案，电子教材以及实验要求等";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.resourceId != null) {
            updateResource(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addResource(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const resourceIds = row.resourceId || this.ids;
      this.$modal.confirm('是否确认删除课程资源，比如教学大纲，教案，电子教材以及实验要求等编号为"' + resourceIds + '"的数据项？').then(function() {
        return delResource(resourceIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/resource/export', {
        ...this.queryParams
      }, `resource_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
