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
import com.ruoyi.system.domain.CurResource;
import com.ruoyi.system.service.ICurResourceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程资源，比如教学大纲，教案，电子教材以及实验要求等Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/resource")
public class CurResourceController extends BaseController
{
    @Autowired
    private ICurResourceService curResourceService;

    /**
     * 查询课程资源，比如教学大纲，教案，电子教材以及实验要求等列表
     */
    @PreAuthorize("@ss.hasPermi('system:resource:list')")
    @GetMapping("/list")
    public TableDataInfo list(CurResource curResource)
    {
        startPage();
        List<CurResource> list = curResourceService.selectCurResourceList(curResource);
        return getDataTable(list);
    }

    /**
     * 导出课程资源，比如教学大纲，教案，电子教材以及实验要求等列表
     */
    @PreAuthorize("@ss.hasPermi('system:resource:export')")
    @Log(title = "课程资源，比如教学大纲，教案，电子教材以及实验要求等", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CurResource curResource)
    {
        List<CurResource> list = curResourceService.selectCurResourceList(curResource);
        ExcelUtil<CurResource> util = new ExcelUtil<CurResource>(CurResource.class);
        util.exportExcel(response, list, "课程资源，比如教学大纲，教案，电子教材以及实验要求等数据");
    }

    /**
     * 获取课程资源，比如教学大纲，教案，电子教材以及实验要求等详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:resource:query')")
    @GetMapping(value = "/{resourceId}")
    public AjaxResult getInfo(@PathVariable("resourceId") Long resourceId)
    {
        return success(curResourceService.selectCurResourceByResourceId(resourceId));
    }

    /**
     * 新增课程资源，比如教学大纲，教案，电子教材以及实验要求等
     */
    @PreAuthorize("@ss.hasPermi('system:resource:add')")
    @Log(title = "课程资源，比如教学大纲，教案，电子教材以及实验要求等", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CurResource curResource)
    {
        return toAjax(curResourceService.insertCurResource(curResource));
    }

    /**
     * 修改课程资源，比如教学大纲，教案，电子教材以及实验要求等
     */
    @PreAuthorize("@ss.hasPermi('system:resource:edit')")
    @Log(title = "课程资源，比如教学大纲，教案，电子教材以及实验要求等", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CurResource curResource)
    {
        return toAjax(curResourceService.updateCurResource(curResource));
    }

    /**
     * 删除课程资源，比如教学大纲，教案，电子教材以及实验要求等
     */
    @PreAuthorize("@ss.hasPermi('system:resource:remove')")
    @Log(title = "课程资源，比如教学大纲，教案，电子教材以及实验要求等", businessType = BusinessType.DELETE)
	@DeleteMapping("/{resourceIds}")
    public AjaxResult remove(@PathVariable Long[] resourceIds)
    {
        return toAjax(curResourceService.deleteCurResourceByResourceIds(resourceIds));
    }
}
