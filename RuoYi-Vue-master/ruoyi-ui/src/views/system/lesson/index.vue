<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程编号" prop="courseId">
        <el-input
          v-model="queryParams.courseId"
          placeholder="请输入课程编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课次编号" prop="lectureId">
        <el-input
          v-model="queryParams.lectureId"
          placeholder="请输入课次编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="授课时间" prop="date">
        <el-date-picker clearable
          v-model="queryParams.date"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择授课时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="节次" prop="section">
        <el-input
          v-model="queryParams.section"
          placeholder="请输入节次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="周次" prop="weekNumber">
        <el-input
          v-model="queryParams.weekNumber"
          placeholder="请输入周次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期几" prop="weekDay">
        <el-input
          v-model="queryParams.weekDay"
          placeholder="请输入星期几"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="授课地点" prop="location">
        <el-input
          v-model="queryParams.location"
          placeholder="请输入授课地点"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="授课类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择授课类型" clearable>
          <el-option
            v-for="dict in dict.type.cou_lesson_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['system:lesson:add']"
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
          v-hasPermi="['system:lesson:edit']"
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
          v-hasPermi="['system:lesson:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:lesson:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lessonList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="lessonId" />
      <el-table-column label="课程编号" align="center" prop="courseId" />
      <el-table-column label="课次编号" align="center" prop="lectureId" />
      <el-table-column label="授课时间" align="center" prop="date" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="节次" align="center" prop="section">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cou_lesson" :value="scope.row.section"/>
        </template>
      </el-table-column>
      <el-table-column label="周次" align="center" prop="weekNumber" />
      <el-table-column label="星期几" align="center" prop="weekDay" />
      <el-table-column label="授课地点" align="center" prop="location" />
      <el-table-column label="授课类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cou_lesson_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:lesson:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:lesson:remove']"
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

    <!-- 添加或修改某个周某个时段的某次课对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程编号" prop="courseId">
          <el-input v-model="form.courseId" placeholder="请输入课程编号" />
        </el-form-item>
        <el-form-item label="课次编号" prop="lectureId">
          <el-input v-model="form.lectureId" placeholder="请输入课次编号" />
        </el-form-item>
        <el-form-item label="授课时间" prop="date">
          <el-date-picker clearable
            v-model="form.date"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择授课时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="节次" prop="section">
          <el-input v-model="form.section" placeholder="请输入节次" />
        </el-form-item>
        <el-form-item label="周次" prop="weekNumber">
          <el-input v-model="form.weekNumber" placeholder="请输入周次" />
        </el-form-item>
        <el-form-item label="星期几" prop="weekDay">
          <el-input v-model="form.weekDay" placeholder="请输入星期几" />
        </el-form-item>
        <el-form-item label="授课地点" prop="location">
          <el-input v-model="form.location" placeholder="请输入授课地点" />
        </el-form-item>
        <el-form-item label="授课类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择授课类型">
            <el-option
              v-for="dict in dict.type.cou_lesson_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
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
import { listLesson, getLesson, delLesson, addLesson, updateLesson } from "@/api/system/lesson";

export default {
  name: "Lesson",
  dicts: ['cou_lesson_type'],
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
      // 某个周某个时段的某次课表格数据
      lessonList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        courseId: null,
        lectureId: null,
        date: null,
        section: null,
        weekNumber: null,
        weekDay: null,
        location: null,
        type: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        courseId: [
          { required: true, message: "课程编号不能为空", trigger: "blur" }
        ],
        lectureId: [
          { required: true, message: "课次编号不能为空", trigger: "blur" }
        ],
        date: [
          { required: true, message: "授课时间不能为空", trigger: "blur" }
        ],
        section: [
          { required: true, message: "节次不能为空", trigger: "blur" }
        ],
        weekNumber: [
          { required: true, message: "周次不能为空", trigger: "blur" }
        ],
        weekDay: [
          { required: true, message: "星期几不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询某个周某个时段的某次课列表 */
    getList() {
      this.loading = true;
      listLesson(this.queryParams).then(response => {
        this.lessonList = response.rows;
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
        lessonId: null,
        courseId: null,
        lectureId: null,
        date: null,
        section: null,
        weekNumber: null,
        weekDay: null,
        location: null,
        type: null
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
      this.ids = selection.map(item => item.lessonId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加某个周某个时段的某次课";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const lessonId = row.lessonId || this.ids
      getLesson(lessonId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改某个周某个时段的某次课";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.lessonId != null) {
            updateLesson(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLesson(this.form).then(response => {
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
      const lessonIds = row.lessonId || this.ids;
      this.$modal.confirm('是否确认删除某个周某个时段的某次课编号为"' + lessonIds + '"的数据项？').then(function() {
        return delLesson(lessonIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/lesson/export', {
        ...this.queryParams
      }, `lesson_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
