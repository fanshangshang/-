<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="策略名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入策略名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平时成绩比例" prop="usualPercent">
        <el-input
          v-model="queryParams.usualPercent"
          placeholder="请输入平时成绩比例"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="期中成绩比例" prop="midPercent">
        <el-input
          v-model="queryParams.midPercent"
          placeholder="请输入期中成绩比例"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="期末成绩比例" prop="finalPercent">
        <el-input
          v-model="queryParams.finalPercent"
          placeholder="请输入期末成绩比例"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="其它成绩比例" prop="otherPercent">
        <el-input
          v-model="queryParams.otherPercent"
          placeholder="请输入其它成绩比例"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="A+对应分数" prop="excellectPlus">
        <el-input
          v-model="queryParams.excellectPlus"
          placeholder="请输入A+对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="A对应分数" prop="excellent">
        <el-input
          v-model="queryParams.excellent"
          placeholder="请输入A对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="A-对应分数" prop="excellentMinus">
        <el-input
          v-model="queryParams.excellentMinus"
          placeholder="请输入A-对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="B+对应分数" prop="goodPlus">
        <el-input
          v-model="queryParams.goodPlus"
          placeholder="请输入B+对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="B对应分数" prop="good">
        <el-input
          v-model="queryParams.good"
          placeholder="请输入B对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="B-对应分数" prop="goodMinus">
        <el-input
          v-model="queryParams.goodMinus"
          placeholder="请输入B-对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="C+对应分数" prop="passPlus">
        <el-input
          v-model="queryParams.passPlus"
          placeholder="请输入C+对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="C对应分数" prop="pass">
        <el-input
          v-model="queryParams.pass"
          placeholder="请输入C对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="C-对应分数" prop="passMinus">
        <el-input
          v-model="queryParams.passMinus"
          placeholder="请输入C-对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="D+对应分数" prop="failedPlus">
        <el-input
          v-model="queryParams.failedPlus"
          placeholder="请输入D+对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="D对应分数" prop="failed">
        <el-input
          v-model="queryParams.failed"
          placeholder="请输入D对应分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="D-对应分数" prop="failedMinus">
        <el-input
          v-model="queryParams.failedMinus"
          placeholder="请输入D-对应分数"
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
          v-hasPermi="['system:strategy:add']"
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
          v-hasPermi="['system:strategy:edit']"
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
          v-hasPermi="['system:strategy:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:strategy:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="strategyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="策略编号" align="center" prop="strategyId" />
      <el-table-column label="策略名称" align="center" prop="name" />
      <el-table-column label="平时成绩比例" align="center" prop="usualPercent" />
      <el-table-column label="期中成绩比例" align="center" prop="midPercent" />
      <el-table-column label="期末成绩比例" align="center" prop="finalPercent" />
      <el-table-column label="其它成绩比例" align="center" prop="otherPercent" />
      <el-table-column label="A+对应分数" align="center" prop="excellectPlus" />
      <el-table-column label="A对应分数" align="center" prop="excellent" />
      <el-table-column label="A-对应分数" align="center" prop="excellentMinus" />
      <el-table-column label="B+对应分数" align="center" prop="goodPlus" />
      <el-table-column label="B对应分数" align="center" prop="good" />
      <el-table-column label="B-对应分数" align="center" prop="goodMinus" />
      <el-table-column label="C+对应分数" align="center" prop="passPlus" />
      <el-table-column label="C对应分数" align="center" prop="pass" />
      <el-table-column label="C-对应分数" align="center" prop="passMinus" />
      <el-table-column label="D+对应分数" align="center" prop="failedPlus" />
      <el-table-column label="D对应分数" align="center" prop="failed" />
      <el-table-column label="D-对应分数" align="center" prop="failedMinus" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:strategy:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:strategy:remove']"
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

    <!-- 添加或修改成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="策略名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入策略名称" />
        </el-form-item>
        <el-form-item label="平时成绩比例" prop="usualPercent">
          <el-input v-model="form.usualPercent" placeholder="请输入平时成绩比例" />
        </el-form-item>
        <el-form-item label="期中成绩比例" prop="midPercent">
          <el-input v-model="form.midPercent" placeholder="请输入期中成绩比例" />
        </el-form-item>
        <el-form-item label="期末成绩比例" prop="finalPercent">
          <el-input v-model="form.finalPercent" placeholder="请输入期末成绩比例" />
        </el-form-item>
        <el-form-item label="其它成绩比例" prop="otherPercent">
          <el-input v-model="form.otherPercent" placeholder="请输入其它成绩比例" />
        </el-form-item>
        <el-form-item label="A+对应分数" prop="excellectPlus">
          <el-input v-model="form.excellectPlus" placeholder="请输入A+对应分数" />
        </el-form-item>
        <el-form-item label="A对应分数" prop="excellent">
          <el-input v-model="form.excellent" placeholder="请输入A对应分数" />
        </el-form-item>
        <el-form-item label="A-对应分数" prop="excellentMinus">
          <el-input v-model="form.excellentMinus" placeholder="请输入A-对应分数" />
        </el-form-item>
        <el-form-item label="B+对应分数" prop="goodPlus">
          <el-input v-model="form.goodPlus" placeholder="请输入B+对应分数" />
        </el-form-item>
        <el-form-item label="B对应分数" prop="good">
          <el-input v-model="form.good" placeholder="请输入B对应分数" />
        </el-form-item>
        <el-form-item label="B-对应分数" prop="goodMinus">
          <el-input v-model="form.goodMinus" placeholder="请输入B-对应分数" />
        </el-form-item>
        <el-form-item label="C+对应分数" prop="passPlus">
          <el-input v-model="form.passPlus" placeholder="请输入C+对应分数" />
        </el-form-item>
        <el-form-item label="C对应分数" prop="pass">
          <el-input v-model="form.pass" placeholder="请输入C对应分数" />
        </el-form-item>
        <el-form-item label="C-对应分数" prop="passMinus">
          <el-input v-model="form.passMinus" placeholder="请输入C-对应分数" />
        </el-form-item>
        <el-form-item label="D+对应分数" prop="failedPlus">
          <el-input v-model="form.failedPlus" placeholder="请输入D+对应分数" />
        </el-form-item>
        <el-form-item label="D对应分数" prop="failed">
          <el-input v-model="form.failed" placeholder="请输入D对应分数" />
        </el-form-item>
        <el-form-item label="D-对应分数" prop="failedMinus">
          <el-input v-model="form.failedMinus" placeholder="请输入D-对应分数" />
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
import { listStrategy, getStrategy, delStrategy, addStrategy, updateStrategy } from "@/api/system/strategy";

export default {
  name: "Strategy",
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
      // 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。表格数据
      strategyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        usualPercent: null,
        midPercent: null,
        finalPercent: null,
        otherPercent: null,
        excellectPlus: null,
        excellent: null,
        excellentMinus: null,
        goodPlus: null,
        good: null,
        goodMinus: null,
        passPlus: null,
        pass: null,
        passMinus: null,
        failedPlus: null,
        failed: null,
        failedMinus: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "策略名称不能为空", trigger: "blur" }
        ],
        usualPercent: [
          { required: true, message: "平时成绩比例不能为空", trigger: "blur" }
        ],
        midPercent: [
          { required: true, message: "期中成绩比例不能为空", trigger: "blur" }
        ],
        finalPercent: [
          { required: true, message: "期末成绩比例不能为空", trigger: "blur" }
        ],
        otherPercent: [
          { required: true, message: "其它成绩比例不能为空", trigger: "blur" }
        ],
        excellectPlus: [
          { required: true, message: "A+对应分数不能为空", trigger: "blur" }
        ],
        excellent: [
          { required: true, message: "A对应分数不能为空", trigger: "blur" }
        ],
        excellentMinus: [
          { required: true, message: "A-对应分数不能为空", trigger: "blur" }
        ],
        goodPlus: [
          { required: true, message: "B+对应分数不能为空", trigger: "blur" }
        ],
        good: [
          { required: true, message: "B对应分数不能为空", trigger: "blur" }
        ],
        goodMinus: [
          { required: true, message: "B-对应分数不能为空", trigger: "blur" }
        ],
        passPlus: [
          { required: true, message: "C+对应分数不能为空", trigger: "blur" }
        ],
        pass: [
          { required: true, message: "C对应分数不能为空", trigger: "blur" }
        ],
        passMinus: [
          { required: true, message: "C-对应分数不能为空", trigger: "blur" }
        ],
        failedPlus: [
          { required: true, message: "D+对应分数不能为空", trigger: "blur" }
        ],
        failed: [
          { required: true, message: "D对应分数不能为空", trigger: "blur" }
        ],
        failedMinus: [
          { required: true, message: "D-对应分数不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。列表 */
    getList() {
      this.loading = true;
      listStrategy(this.queryParams).then(response => {
        this.strategyList = response.rows;
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
        strategyId: null,
        name: null,
        usualPercent: null,
        midPercent: null,
        finalPercent: null,
        otherPercent: null,
        excellectPlus: null,
        excellent: null,
        excellentMinus: null,
        goodPlus: null,
        good: null,
        goodMinus: null,
        passPlus: null,
        pass: null,
        passMinus: null,
        failedPlus: null,
        failed: null,
        failedMinus: null
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
      this.ids = selection.map(item => item.strategyId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const strategyId = row.strategyId || this.ids
      getStrategy(strategyId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.strategyId != null) {
            updateStrategy(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStrategy(this.form).then(response => {
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
      const strategyIds = row.strategyId || this.ids;
      this.$modal.confirm('是否确认删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。编号为"' + strategyIds + '"的数据项？').then(function() {
        return delStrategy(strategyIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/strategy/export', {
        ...this.queryParams
      }, `strategy_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
