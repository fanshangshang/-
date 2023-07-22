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
import com.ruoyi.system.domain.CouLesson;
import com.ruoyi.system.service.ICouLessonService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 某个周某个时段的某次课Controller
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/lesson")
public class CouLessonController extends BaseController
{
    @Autowired
    private ICouLessonService couLessonService;

    /**
     * 查询某个周某个时段的某次课列表
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:list')")
    @GetMapping("/list")
    public TableDataInfo list(CouLesson couLesson)
    {
        startPage();
        List<CouLesson> list = couLessonService.selectCouLessonList(couLesson);
        return getDataTable(list);
    }

    /**
     * 导出某个周某个时段的某次课列表
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:export')")
    @Log(title = "某个周某个时段的某次课", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouLesson couLesson)
    {
        List<CouLesson> list = couLessonService.selectCouLessonList(couLesson);
        ExcelUtil<CouLesson> util = new ExcelUtil<CouLesson>(CouLesson.class);
        util.exportExcel(response, list, "某个周某个时段的某次课数据");
    }

    /**
     * 获取某个周某个时段的某次课详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:query')")
    @GetMapping(value = "/{lessonId}")
    public AjaxResult getInfo(@PathVariable("lessonId") Long lessonId)
    {
        return success(couLessonService.selectCouLessonByLessonId(lessonId));
    }

    /**
     * 新增某个周某个时段的某次课
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:add')")
    @Log(title = "某个周某个时段的某次课", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouLesson couLesson)
    {
        return toAjax(couLessonService.insertCouLesson(couLesson));
    }

    /**
     * 修改某个周某个时段的某次课
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:edit')")
    @Log(title = "某个周某个时段的某次课", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouLesson couLesson)
    {
        return toAjax(couLessonService.updateCouLesson(couLesson));
    }

    /**
     * 删除某个周某个时段的某次课
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:remove')")
    @Log(title = "某个周某个时段的某次课", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lessonIds}")
    public AjaxResult remove(@PathVariable Long[] lessonIds)
    {
        return toAjax(couLessonService.deleteCouLessonByLessonIds(lessonIds));
    }
}
