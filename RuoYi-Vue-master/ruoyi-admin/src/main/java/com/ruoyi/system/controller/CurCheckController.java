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
import com.ruoyi.system.domain.CurCheck;
import com.ruoyi.system.service.ICurCheckService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 题目任务关系Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/check")
public class CurCheckController extends BaseController
{
    @Autowired
    private ICurCheckService curCheckService;

    /**
     * 查询题目任务关系列表
     */
    @PreAuthorize("@ss.hasPermi('system:check:list')")
    @GetMapping("/list")
    public TableDataInfo list(CurCheck curCheck)
    {
        startPage();
        List<CurCheck> list = curCheckService.selectCurCheckList(curCheck);
        return getDataTable(list);
    }

    /**
     * 导出题目任务关系列表
     */
    @PreAuthorize("@ss.hasPermi('system:check:export')")
    @Log(title = "题目任务关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CurCheck curCheck)
    {
        List<CurCheck> list = curCheckService.selectCurCheckList(curCheck);
        ExcelUtil<CurCheck> util = new ExcelUtil<CurCheck>(CurCheck.class);
        util.exportExcel(response, list, "题目任务关系数据");
    }

    /**
     * 获取题目任务关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:check:query')")
    @GetMapping(value = "/{checkId}")
    public AjaxResult getInfo(@PathVariable("checkId") Long checkId)
    {
        return success(curCheckService.selectCurCheckByCheckId(checkId));
    }

    /**
     * 新增题目任务关系
     */
    @PreAuthorize("@ss.hasPermi('system:check:add')")
    @Log(title = "题目任务关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CurCheck curCheck)
    {
        return toAjax(curCheckService.insertCurCheck(curCheck));
    }

    /**
     * 修改题目任务关系
     */
    @PreAuthorize("@ss.hasPermi('system:check:edit')")
    @Log(title = "题目任务关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CurCheck curCheck)
    {
        return toAjax(curCheckService.updateCurCheck(curCheck));
    }

    /**
     * 删除题目任务关系
     */
    @PreAuthorize("@ss.hasPermi('system:check:remove')")
    @Log(title = "题目任务关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{checkIds}")
    public AjaxResult remove(@PathVariable Long[] checkIds)
    {
        return toAjax(curCheckService.deleteCurCheckByCheckIds(checkIds));
    }
}
