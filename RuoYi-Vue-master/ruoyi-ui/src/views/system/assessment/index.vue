<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="选课编号" prop="enrollId">
        <el-input
          v-model="queryParams.enrollId"
          placeholder="请输入选课编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务编号" prop="taskId">
        <el-input
          v-model="queryParams.taskId"
          placeholder="请输入任务编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评价类别" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择评价类别" clearable>
          <el-option
            v-for="dict in dict.type.cou_assessment_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="评价结果" prop="result">
        <el-input
          v-model="queryParams.result"
          placeholder="请输入评价结果"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经度" prop="latitude">
        <el-input
          v-model="queryParams.latitude"
          placeholder="请输入经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="纬度" prop="longitude">
        <el-input
          v-model="queryParams.longitude"
          placeholder="请输入纬度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="打分" prop="mark">
        <el-input
          v-model="queryParams.mark"
          placeholder="请输入打分"
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
          v-hasPermi="['system:assessment:add']"
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
          v-hasPermi="['system:assessment:edit']"
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
          v-hasPermi="['system:assessment:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:assessment:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="assessmentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="assessmentId" />
      <el-table-column label="选课编号" align="center" prop="enrollId" />
      <el-table-column label="任务编号" align="center" prop="taskId" />
      <el-table-column label="评价类别" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cou_assessment_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="评价结果" align="center" prop="result" />
      <el-table-column label="经度" align="center" prop="latitude" />
      <el-table-column label="纬度" align="center" prop="longitude" />
      <el-table-column label="打分" align="center" prop="mark" />
      <el-table-column label="附件文件路径" align="center" prop="attachment" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:assessment:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:assessment:remove']"
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

    <!-- 添加或修改一次评价对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="选课编号" prop="enrollId">
          <el-input v-model="form.enrollId" placeholder="请输入选课编号" />
        </el-form-item>
        <el-form-item label="任务编号" prop="taskId">
          <el-input v-model="form.taskId" placeholder="请输入任务编号" />
        </el-form-item>
        <el-form-item label="评价类别" prop="type">
          <el-select v-model="form.type" placeholder="请选择评价类别">
            <el-option
              v-for="dict in dict.type.cou_assessment_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="评价结果" prop="result">
          <el-input v-model="form.result" placeholder="请输入评价结果" />
        </el-form-item>
        <el-form-item label="经度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="打分" prop="mark">
          <el-input v-model="form.mark" placeholder="请输入打分" />
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
import { listAssessment, getAssessment, delAssessment, addAssessment, updateAssessment } from "@/api/system/assessment";

export default {
  name: "Assessment",
  dicts: ['cou_assessment_type'],
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
      // 一次评价表格数据
      assessmentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        enrollId: null,
        taskId: null,
        type: null,
        result: null,
        latitude: null,
        longitude: null,
        mark: null,
        attachment: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        enrollId: [
          { required: true, message: "选课编号不能为空", trigger: "blur" }
        ],
        taskId: [
          { required: true, message: "任务编号不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "评价类别不能为空", trigger: "change" }
        ],
        result: [
          { required: true, message: "评价结果不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询一次评价列表 */
    getList() {
      this.loading = true;
      listAssessment(this.queryParams).then(response => {
        this.assessmentList = response.rows;
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
        assessmentId: null,
        enrollId: null,
        taskId: null,
        type: null,
        result: null,
        latitude: null,
        longitude: null,
        mark: null,
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
      this.ids = selection.map(item => item.assessmentId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加一次评价";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const assessmentId = row.assessmentId || this.ids
      getAssessment(assessmentId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改一次评价";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.assessmentId != null) {
            updateAssessment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAssessment(this.form).then(response => {
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
      const assessmentIds = row.assessmentId || this.ids;
      this.$modal.confirm('是否确认删除一次评价编号为"' + assessmentIds + '"的数据项？').then(function() {
        return delAssessment(assessmentIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/assessment/export', {
        ...this.queryParams
      }, `assessment_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
