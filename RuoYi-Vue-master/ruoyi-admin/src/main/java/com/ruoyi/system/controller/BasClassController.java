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
import com.ruoyi.system.domain.BasClass;
import com.ruoyi.system.service.IBasClassService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班级Controller
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/class")
public class BasClassController extends BaseController
{
    @Autowired
    private IBasClassService basClassService;

    /**
     * 查询班级列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasClass basClass)
    {
        startPage();
        List<BasClass> list = basClassService.selectBasClassList(basClass);
        return getDataTable(list);
    }

    /**
     * 导出班级列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:export')")
    @Log(title = "班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BasClass basClass)
    {
        List<BasClass> list = basClassService.selectBasClassList(basClass);
        ExcelUtil<BasClass> util = new ExcelUtil<BasClass>(BasClass.class);
        util.exportExcel(response, list, "班级数据");
    }

    /**
     * 获取班级详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:class:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId)
    {
        return success(basClassService.selectBasClassByClassId(classId));
    }

    /**
     * 新增班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:add')")
    @Log(title = "班级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasClass basClass)
    {
        return toAjax(basClassService.insertBasClass(basClass));
    }

    /**
     * 修改班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:edit')")
    @Log(title = "班级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasClass basClass)
    {
        return toAjax(basClassService.updateBasClass(basClass));
    }

    /**
     * 删除班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:remove')")
    @Log(title = "班级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds)
    {
        return toAjax(basClassService.deleteBasClassByClassIds(classIds));
    }
}
