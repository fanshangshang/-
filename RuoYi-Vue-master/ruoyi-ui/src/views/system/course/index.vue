<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="curriculum_id" prop="curriculumId">
        <el-input
          v-model="queryParams.curriculumId"
          placeholder="请输入curriculum_id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教师工号" prop="teacherId">
        <el-input
          v-model="queryParams.teacherId"
          placeholder="请输入教师工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="策略编号" prop="strategyId">
        <el-input
          v-model="queryParams.strategyId"
          placeholder="请输入策略编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学年，格式" prop="year">
        <el-input
          v-model="queryParams.year"
          placeholder="请输入学年，格式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学期" prop="semester">
        <el-input
          v-model="queryParams.semester"
          placeholder="请输入学期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程编号，示例" prop="code">
        <el-input
          v-model="queryParams.code"
          placeholder="请输入课程编号，示例"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择课程类型" clearable>
          <el-option
            v-for="dict in dict.type.cou_course_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="授课方式" prop="method">
        <el-input
          v-model="queryParams.method"
          placeholder="请输入授课方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否重复班" prop="repetitive">
        <el-input
          v-model="queryParams.repetitive"
          placeholder="请输入是否重复班"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否重复班" prop="repetitive2">
        <el-input
          v-model="queryParams.repetitive2"
          placeholder="请输入是否重复班"
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
          v-hasPermi="['system:course:add']"
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
          v-hasPermi="['system:course:edit']"
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
          v-hasPermi="['system:course:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:course:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="course_id" align="center" prop="courseId" />
      <el-table-column label="curriculum_id" align="center" prop="curriculumId" />
      <el-table-column label="教师工号" align="center" prop="teacherId" />
      <el-table-column label="策略编号" align="center" prop="strategyId" />
      <el-table-column label="学年，格式" align="center" prop="year" />
      <el-table-column label="学期(1:第一学期，2-第二学期)" align="center" prop="semester">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cou_course_semester" :value="scope.row.semester"/>
        </template>
      </el-table-column>
      <el-table-column label="课程编号，示例" align="center" prop="code" />
      <el-table-column label="课程类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cou_course_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="授课方式" align="center" prop="method" />
      <el-table-column label="是否重复班" align="center" prop="repetitive" />
      <el-table-column label="是否重复班" align="center" prop="repetitive2" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:course:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:course:remove']"
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

    <!-- 添加或修改课程，对应某学期某个教师所授课程对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="curriculum_id" prop="curriculumId">
          <el-input v-model="form.curriculumId" placeholder="请输入curriculum_id" />
        </el-form-item>
        <el-form-item label="教师工号" prop="teacherId">
          <el-input v-model="form.teacherId" placeholder="请输入教师工号" />
        </el-form-item>
        <el-form-item label="策略编号" prop="strategyId">
          <el-input v-model="form.strategyId" placeholder="请输入策略编号" />
        </el-form-item>
        <el-form-item label="学年，格式" prop="year">
          <el-input v-model="form.year" placeholder="请输入学年，格式" />
        </el-form-item>
        <el-form-item label="学期(1:第一学期，2-第二学期)" prop="semester">
          <el-input v-model="form.semester" placeholder="请输入学期(1:第一学期，2-第二学期)" />
        </el-form-item>
        <el-form-item label="课程编号，示例" prop="code">
          <el-input v-model="form.code" placeholder="请输入课程编号，示例" />
        </el-form-item>
        <el-form-item label="课程类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择课程类型">
            <el-option
              v-for="dict in dict.type.cou_course_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="授课方式" prop="method">
          <el-input v-model="form.method" placeholder="请输入授课方式" />
        </el-form-item>
        <el-form-item label="是否重复班" prop="repetitive">
          <el-input v-model="form.repetitive" placeholder="请输入是否重复班" />
        </el-form-item>
        <el-form-item label="是否重复班" prop="repetitive2">
          <el-input v-model="form.repetitive2" placeholder="请输入是否重复班" />
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
import { listCourse, getCourse, delCourse, addCourse, updateCourse } from "@/api/system/course";

export default {
  name: "Course",
  dicts: ['cou_course_type'],
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
      // 课程，对应某学期某个教师所授课程表格数据
      courseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        curriculumId: null,
        teacherId: null,
        strategyId: null,
        year: null,
        semester: null,
        code: null,
        type: null,
        method: null,
        repetitive: null,
        repetitive2: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        curriculumId: [
          { required: true, message: "curriculum_id不能为空", trigger: "blur" }
        ],
        teacherId: [
          { required: true, message: "教师工号不能为空", trigger: "blur" }
        ],
        strategyId: [
          { required: true, message: "策略编号不能为空", trigger: "blur" }
        ],
        year: [
          { required: true, message: "学年，格式不能为空", trigger: "blur" }
        ],
        semester: [
          { required: true, message: "学期(1:第一学期，2-第二学期)不能为空", trigger: "blur" }
        ],
        code: [
          { required: true, message: "课程编号，示例不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询课程，对应某学期某个教师所授课程列表 */
    getList() {
      this.loading = true;
      listCourse(this.queryParams).then(response => {
        this.courseList = response.rows;
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
        courseId: null,
        curriculumId: null,
        teacherId: null,
        strategyId: null,
        year: null,
        semester: null,
        code: null,
        type: null,
        method: null,
        repetitive: null,
        repetitive2: null
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
      this.ids = selection.map(item => item.courseId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加课程，对应某学期某个教师所授课程";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const courseId = row.courseId || this.ids
      getCourse(courseId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改课程，对应某学期某个教师所授课程";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.courseId != null) {
            updateCourse(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCourse(this.form).then(response => {
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
      const courseIds = row.courseId || this.ids;
      this.$modal.confirm('是否确认删除课程，对应某学期某个教师所授课程编号为"' + courseIds + '"的数据项？').then(function() {
        return delCourse(courseIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/course/export', {
        ...this.queryParams
      }, `course_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
