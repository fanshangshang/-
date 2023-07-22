package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CurTask;
import com.ruoyi.system.service.ICurTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学习任务，比如一次作业，一次随堂测试等。Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/task")
public class CurTaskController extends BaseController
{
    @Autowired
    private ICurTaskService curTaskService;

    /**
     * 查询学习任务，比如一次作业，一次随堂测试等。列表
     */
    @PreAuthorize("@ss.hasPermi('system:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(CurTask curTask)
    {
        startPage();
        List<CurTask> list = curTaskService.selectCurTaskList(curTask);
        return getDataTable(list);
    }

    /**
     * 导出学习任务，比如一次作业，一次随堂测试等。列表
     */
    @PreAuthorize("@ss.hasPermi('system:task:export')")
    @Log(title = "学习任务，比如一次作业，一次随堂测试等。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CurTask curTask)
    {
        List<CurTask> list = curTaskService.selectCurTaskList(curTask);
        ExcelUtil<CurTask> util = new ExcelUtil<CurTask>(CurTask.class);
        util.exportExcel(response, list, "学习任务，比如一次作业，一次随堂测试等。数据");
    }

    /**
     * 获取学习任务，比如一次作业，一次随堂测试等。详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(curTaskService.selectCurTaskByTaskId(taskId));
    }

    /**
     * 新增学习任务，比如一次作业，一次随堂测试等。
     */
    @PreAuthorize("@ss.hasPermi('system:task:add')")
    @Log(title = "学习任务，比如一次作业，一次随堂测试等。", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CurTask curTask)
    {
        return toAjax(curTaskService.insertCurTask(curTask));
    }

    /**
     * 修改学习任务，比如一次作业，一次随堂测试等。
     */
    @PreAuthorize("@ss.hasPermi('system:task:edit')")
    @Log(title = "学习任务，比如一次作业，一次随堂测试等。", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CurTask curTask)
    {
        return toAjax(curTaskService.updateCurTask(curTask));
    }

    /**
     * 删除学习任务，比如一次作业，一次随堂测试等。
     */
    @PreAuthorize("@ss.hasPermi('system:task:remove')")
    @Log(title = "学习任务，比如一次作业，一次随堂测试等。", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(curTaskService.deleteCurTaskByTaskIds(taskIds));
    }
}
