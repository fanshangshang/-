<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="某讲编号" prop="lectureId">
        <el-input
          v-model="queryParams.lectureId"
          placeholder="请输入某讲编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="题型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择题型" clearable>
          <el-option
            v-for="dict in dict.type.cur_exercise_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="难度" prop="difficulty">
        <el-input
          v-model="queryParams.difficulty"
          placeholder="请输入难度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分值" prop="score">
        <el-input
          v-model="queryParams.score"
          placeholder="请输入分值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="答案" prop="answer">
        <el-input
          v-model="queryParams.answer"
          placeholder="请输入答案"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用次数" prop="usedTimes">
        <el-input
          v-model="queryParams.usedTimes"
          placeholder="请输入使用次数"
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
          v-hasPermi="['system:exercise:add']"
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
          v-hasPermi="['system:exercise:edit']"
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
          v-hasPermi="['system:exercise:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:exercise:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="exerciseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="exerciseId" />
      <el-table-column label="某讲编号" align="center" prop="lectureId" />
      <el-table-column label="题型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cur_exercise_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="难度" align="center" prop="difficulty">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cur_exercise_difficulty" :value="scope.row.difficulty"/>
        </template>
      </el-table-column>
      <el-table-column label="分值" align="center" prop="score" />
      <el-table-column label="题干" align="center" prop="content" />
      <el-table-column label="答案" align="center" prop="answer" />
      <el-table-column label="使用次数" align="center" prop="usedTimes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:exercise:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:exercise:remove']"
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

    <!-- 添加或修改题目，用于生成试卷或者平时测试用对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="某讲编号" prop="lectureId">
          <el-input v-model="form.lectureId" placeholder="请输入某讲编号" />
        </el-form-item>
        <el-form-item label="题型" prop="type">
          <el-select v-model="form.type" placeholder="请选择题型">
            <el-option
              v-for="dict in dict.type.cur_exercise_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="难度" prop="difficulty">
          <el-input v-model="form.difficulty" placeholder="请输入难度" />
        </el-form-item>
        <el-form-item label="分值" prop="score">
          <el-input v-model="form.score" placeholder="请输入分值" />
        </el-form-item>
        <el-form-item label="题干">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="答案" prop="answer">
          <el-input v-model="form.answer" placeholder="请输入答案" />
        </el-form-item>
        <el-form-item label="使用次数" prop="usedTimes">
          <el-input v-model="form.usedTimes" placeholder="请输入使用次数" />
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
import { listExercise, getExercise, delExercise, addExercise, updateExercise } from "@/api/system/exercise";

export default {
  name: "Exercise",
  dicts: ['cur_exercise_type'],
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
      // 题目，用于生成试卷或者平时测试用表格数据
      exerciseList: [],
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
        difficulty: null,
        score: null,
        content: null,
        answer: null,
        usedTimes: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        lectureId: [
          { required: true, message: "某讲编号不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "题型不能为空", trigger: "change" }
        ],
        difficulty: [
          { required: true, message: "难度不能为空", trigger: "blur" }
        ],
        score: [
          { required: true, message: "分值不能为空", trigger: "blur" }
        ],
        content: [
          { required: true, message: "题干不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询题目，用于生成试卷或者平时测试用列表 */
    getList() {
      this.loading = true;
      listExercise(this.queryParams).then(response => {
        this.exerciseList = response.rows;
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
        exerciseId: null,
        lectureId: null,
        type: null,
        difficulty: null,
        score: null,
        content: null,
        answer: null,
        usedTimes: null
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
      this.ids = selection.map(item => item.exerciseId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加题目，用于生成试卷或者平时测试用";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const exerciseId = row.exerciseId || this.ids
      getExercise(exerciseId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改题目，用于生成试卷或者平时测试用";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.exerciseId != null) {
            updateExercise(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addExercise(this.form).then(response => {
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
      const exerciseIds = row.exerciseId || this.ids;
      this.$modal.confirm('是否确认删除题目，用于生成试卷或者平时测试用编号为"' + exerciseIds + '"的数据项？').then(function() {
        return delExercise(exerciseIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/exercise/export', {
        ...this.queryParams
      }, `exercise_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
