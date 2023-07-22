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
import com.ruoyi.system.domain.CurCurriculum;
import com.ruoyi.system.service.ICurCurriculumService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大纲课程信息Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/curriculum")
public class CurCurriculumController extends BaseController
{
    @Autowired
    private ICurCurriculumService curCurriculumService;

    /**
     * 查询大纲课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:curriculum:list')")
    @GetMapping("/list")
    public TableDataInfo list(CurCurriculum curCurriculum)
    {
        startPage();
        List<CurCurriculum> list = curCurriculumService.selectCurCurriculumList(curCurriculum);
        return getDataTable(list);
    }

    /**
     * 导出大纲课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:curriculum:export')")
    @Log(title = "大纲课程信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CurCurriculum curCurriculum)
    {
        List<CurCurriculum> list = curCurriculumService.selectCurCurriculumList(curCurriculum);
        ExcelUtil<CurCurriculum> util = new ExcelUtil<CurCurriculum>(CurCurriculum.class);
        util.exportExcel(response, list, "大纲课程信息数据");
    }

    /**
     * 获取大纲课程信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:curriculum:query')")
    @GetMapping(value = "/{curriculumId}")
    public AjaxResult getInfo(@PathVariable("curriculumId") Long curriculumId)
    {
        return success(curCurriculumService.selectCurCurriculumByCurriculumId(curriculumId));
    }

    /**
     * 新增大纲课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:curriculum:add')")
    @Log(title = "大纲课程信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CurCurriculum curCurriculum)
    {
        return toAjax(curCurriculumService.insertCurCurriculum(curCurriculum));
    }

    /**
     * 修改大纲课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:curriculum:edit')")
    @Log(title = "大纲课程信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CurCurriculum curCurriculum)
    {
        return toAjax(curCurriculumService.updateCurCurriculum(curCurriculum));
    }

    /**
     * 删除大纲课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:curriculum:remove')")
    @Log(title = "大纲课程信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{curriculumIds}")
    public AjaxResult remove(@PathVariable Long[] curriculumIds)
    {
        return toAjax(curCurriculumService.deleteCurCurriculumByCurriculumIds(curriculumIds));
    }
}
