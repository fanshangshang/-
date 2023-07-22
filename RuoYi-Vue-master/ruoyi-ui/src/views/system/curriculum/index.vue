<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程编码" prop="code">
        <el-input
          v-model="queryParams.code"
          placeholder="请输入课程编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="部门编号" prop="deptId">
        <el-input
          v-model="queryParams.deptId"
          placeholder="请输入部门编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入课程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学分" prop="credit">
        <el-input
          v-model="queryParams.credit"
          placeholder="请输入学分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="理论学时" prop="theoryHours">
        <el-input
          v-model="queryParams.theoryHours"
          placeholder="请输入理论学时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类别" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类别" clearable>
          <el-option
            v-for="dict in dict.type.cur_curriculum_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="课程性质" prop="nature">
        <el-input
          v-model="queryParams.nature"
          placeholder="请输入课程性质"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实践学时" prop="laboratoryHours">
        <el-input
          v-model="queryParams.laboratoryHours"
          placeholder="请输入实践学时"
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
          v-hasPermi="['system:curriculum:add']"
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
          v-hasPermi="['system:curriculum:edit']"
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
          v-hasPermi="['system:curriculum:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:curriculum:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="curriculumList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="curriculum编号" align="center" prop="curriculumId" />
      <el-table-column label="课程编码" align="center" prop="code" />
      <el-table-column label="部门编号" align="center" prop="deptId" />
      <el-table-column label="课程名称" align="center" prop="name" />
      <el-table-column label="学分" align="center" prop="credit" />
      <el-table-column label="理论学时" align="center" prop="theoryHours" />
      <el-table-column label="类别" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cur_curriculum_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="课程性质" align="center" prop="nature">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cur_curriculum_nature" :value="scope.row.nature"/>
        </template>
      </el-table-column>
      <el-table-column label="实践学时" align="center" prop="laboratoryHours" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:curriculum:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:curriculum:remove']"
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

    <!-- 添加或修改大纲课程信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程编码" prop="code">
          <el-input v-model="form.code" placeholder="请输入课程编码" />
        </el-form-item>
        <el-form-item label="部门编号" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入部门编号" />
        </el-form-item>
        <el-form-item label="课程名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入课程名称" />
        </el-form-item>
        <el-form-item label="学分" prop="credit">
          <el-input v-model="form.credit" placeholder="请输入学分" />
        </el-form-item>
        <el-form-item label="理论学时" prop="theoryHours">
          <el-input v-model="form.theoryHours" placeholder="请输入理论学时" />
        </el-form-item>
        <el-form-item label="类别" prop="type">
          <el-select v-model="form.type" placeholder="请选择类别">
            <el-option
              v-for="dict in dict.type.cur_curriculum_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="课程性质" prop="nature">
          <el-input v-model="form.nature" placeholder="请输入课程性质" />
        </el-form-item>
        <el-form-item label="实践学时" prop="laboratoryHours">
          <el-input v-model="form.laboratoryHours" placeholder="请输入实践学时" />
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
import { listCurriculum, getCurriculum, delCurriculum, addCurriculum, updateCurriculum } from "@/api/system/curriculum";

export default {
  name: "Curriculum",
  dicts: ['cur_curriculum_type'],
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
      // 大纲课程信息表格数据
      curriculumList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        code: null,
        deptId: null,
        name: null,
        credit: null,
        theoryHours: null,
        type: null,
        nature: null,
        laboratoryHours: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        code: [
          { required: true, message: "课程编码不能为空", trigger: "blur" }
        ],
        deptId: [
          { required: true, message: "部门编号不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "课程名称不能为空", trigger: "blur" }
        ],
        credit: [
          { required: true, message: "学分不能为空", trigger: "blur" }
        ],
        theoryHours: [
          { required: true, message: "理论学时不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "类别不能为空", trigger: "change" }
        ],
        nature: [
          { required: true, message: "课程性质不能为空", trigger: "blur" }
        ],
        laboratoryHours: [
          { required: true, message: "实践学时不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询大纲课程信息列表 */
    getList() {
      this.loading = true;
      listCurriculum(this.queryParams).then(response => {
        this.curriculumList = response.rows;
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
        curriculumId: null,
        code: null,
        deptId: null,
        name: null,
        credit: null,
        theoryHours: null,
        type: null,
        nature: null,
        laboratoryHours: null,
        createTime: null,
        createBy: null,
        updateBy: null,
        updateTime: null
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
      this.ids = selection.map(item => item.curriculumId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加大纲课程信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const curriculumId = row.curriculumId || this.ids
      getCurriculum(curriculumId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改大纲课程信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.curriculumId != null) {
            updateCurriculum(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCurriculum(this.form).then(response => {
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
      const curriculumIds = row.curriculumId || this.ids;
      this.$modal.confirm('是否确认删除大纲课程信息编号为"' + curriculumIds + '"的数据项？').then(function() {
        return delCurriculum(curriculumIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/curriculum/export', {
        ...this.queryParams
      }, `curriculum_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
