<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程编号" prop="lectureId">
        <el-input
          v-model="queryParams.lectureId"
          placeholder="请输入课程编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入任务名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务类别" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择任务类别" clearable>
          <el-option
            v-for="dict in dict.type.cur_task_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="结束周次(1-20)" prop="deadline">
        <el-input
          v-model="queryParams.deadline"
          placeholder="请输入结束周次(1-20)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否开放任务" prop="open">
        <el-input
          v-model="queryParams.open"
          placeholder="请输入是否开放任务"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务内容" prop="requirement">
        <el-input
          v-model="queryParams.requirement"
          placeholder="请输入任务内容"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提交文件命名规范，每部分用[]包含" prop="submitFormat">
        <el-input
          v-model="queryParams.submitFormat"
          placeholder="请输入提交文件命名规范，每部分用[]包含"
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
          v-hasPermi="['system:task:add']"
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
          v-hasPermi="['system:task:edit']"
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
          v-hasPermi="['system:task:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:task:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="taskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="taskId" />
      <el-table-column label="课程编号" align="center" prop="lectureId" />
      <el-table-column label="任务名称" align="center" prop="name" />
      <el-table-column label="任务类别(0作业；1实验；2测试；3讨论；4考试；5报告；6程序)" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cur_task_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="结束周次(1-20)" align="center" prop="deadline" />
      <el-table-column label="是否开放任务" align="center" prop="open">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.open"/>
        </template>
      </el-table-column>
      <el-table-column label="任务内容" align="center" prop="requirement" />
      <el-table-column label="提交文件命名规范，每部分用[]包含" align="center" prop="submitFormat" />
      <el-table-column label="提交文件格式，用/隔开" align="center" prop="submitType" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:task:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:task:remove']"
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

    <!-- 添加或修改学习任务，比如一次作业，一次随堂测试等。对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程编号" prop="lectureId">
          <el-input v-model="form.lectureId" placeholder="请输入课程编号" />
        </el-form-item>
        <el-form-item label="任务名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入任务名称" />
        </el-form-item>
        <el-form-item label="任务类别(0作业；1实验；2测试；3讨论；4考试；5报告；6程序)" prop="type">
          <el-select v-model="form.type" placeholder="请选择任务类别(0作业；1实验；2测试；3讨论；4考试；5报告；6程序)">
            <el-option
              v-for="dict in dict.type.cur_task_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="结束周次(1-20)" prop="deadline">
          <el-input v-model="form.deadline" placeholder="请输入结束周次(1-20)" />
        </el-form-item>
        <el-form-item label="是否开放任务" prop="open">
          <el-input v-model="form.open" placeholder="请输入是否开放任务" />
        </el-form-item>
        <el-form-item label="任务内容" prop="requirement">
          <el-input v-model="form.requirement" placeholder="请输入任务内容" />
        </el-form-item>
        <el-form-item label="提交文件命名规范，每部分用[]包含" prop="submitFormat">
          <el-input v-model="form.submitFormat" placeholder="请输入提交文件命名规范，每部分用[]包含" />
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
import { listTask, getTask, delTask, addTask, updateTask } from "@/api/system/task";

export default {
  name: "Task",
  dicts: ['cur_task_type'],
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
      // 学习任务，比如一次作业，一次随堂测试等。表格数据
      taskList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        lectureId: null,
        name: null,
        type: null,
        deadline: null,
        open: null,
        requirement: null,
        submitFormat: null,
        submitType: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        lectureId: [
          { required: true, message: "课程编号不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "任务名称不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "任务类别(0作业；1实验；2测试；3讨论；4考试；5报告；6程序)不能为空", trigger: "change" }
        ],
        submitFormat: [
          { required: true, message: "提交文件命名规范，每部分用[]包含不能为空", trigger: "blur" }
        ],
        submitType: [
          { required: true, message: "提交文件格式，用/隔开不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学习任务，比如一次作业，一次随堂测试等。列表 */
    getList() {
      this.loading = true;
      listTask(this.queryParams).then(response => {
        this.taskList = response.rows;
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
        taskId: null,
        lectureId: null,
        name: null,
        type: null,
        deadline: null,
        open: null,
        requirement: null,
        submitFormat: null,
        submitType: null
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
      this.ids = selection.map(item => item.taskId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学习任务，比如一次作业，一次随堂测试等。";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const taskId = row.taskId || this.ids
      getTask(taskId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学习任务，比如一次作业，一次随堂测试等。";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.taskId != null) {
            updateTask(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTask(this.form).then(response => {
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
      const taskIds = row.taskId || this.ids;
      this.$modal.confirm('是否确认删除学习任务，比如一次作业，一次随堂测试等。编号为"' + taskIds + '"的数据项？').then(function() {
        return delTask(taskIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/task/export', {
        ...this.queryParams
      }, `task_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
