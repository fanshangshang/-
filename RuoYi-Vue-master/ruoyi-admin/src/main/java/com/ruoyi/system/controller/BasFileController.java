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
import com.ruoyi.system.domain.BasFile;
import com.ruoyi.system.service.IBasFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文件，主要保存物理文件的相对路径Controller
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/file")
public class BasFileController extends BaseController
{
    @Autowired
    private IBasFileService basFileService;

    /**
     * 查询文件，主要保存物理文件的相对路径列表
     */
    @PreAuthorize("@ss.hasPermi('system:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasFile basFile)
    {
        startPage();
        List<BasFile> list = basFileService.selectBasFileList(basFile);
        return getDataTable(list);
    }

    /**
     * 导出文件，主要保存物理文件的相对路径列表
     */
    @PreAuthorize("@ss.hasPermi('system:file:export')")
    @Log(title = "文件，主要保存物理文件的相对路径", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BasFile basFile)
    {
        List<BasFile> list = basFileService.selectBasFileList(basFile);
        ExcelUtil<BasFile> util = new ExcelUtil<BasFile>(BasFile.class);
        util.exportExcel(response, list, "文件，主要保存物理文件的相对路径数据");
    }

    /**
     * 获取文件，主要保存物理文件的相对路径详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:file:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return success(basFileService.selectBasFileByFileId(fileId));
    }

    /**
     * 新增文件，主要保存物理文件的相对路径
     */
    @PreAuthorize("@ss.hasPermi('system:file:add')")
    @Log(title = "文件，主要保存物理文件的相对路径", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasFile basFile)
    {
        return toAjax(basFileService.insertBasFile(basFile));
    }

    /**
     * 修改文件，主要保存物理文件的相对路径
     */
    @PreAuthorize("@ss.hasPermi('system:file:edit')")
    @Log(title = "文件，主要保存物理文件的相对路径", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasFile basFile)
    {
        return toAjax(basFileService.updateBasFile(basFile));
    }

    /**
     * 删除文件，主要保存物理文件的相对路径
     */
    @PreAuthorize("@ss.hasPermi('system:file:remove')")
    @Log(title = "文件，主要保存物理文件的相对路径", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(basFileService.deleteBasFileByFileIds(fileIds));
    }
}
