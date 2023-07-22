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
import com.ruoyi.system.domain.CouCourse;
import com.ruoyi.system.service.ICouCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程，对应某学期某个教师所授课程Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/course")
public class CouCourseController extends BaseController
{
    @Autowired
    private ICouCourseService couCourseService;

    /**
     * 查询课程，对应某学期某个教师所授课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(CouCourse couCourse)
    {
        startPage();
        List<CouCourse> list = couCourseService.selectCouCourseList(couCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程，对应某学期某个教师所授课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:export')")
    @Log(title = "课程，对应某学期某个教师所授课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouCourse couCourse)
    {
        List<CouCourse> list = couCourseService.selectCouCourseList(couCourse);
        ExcelUtil<CouCourse> util = new ExcelUtil<CouCourse>(CouCourse.class);
        util.exportExcel(response, list, "课程，对应某学期某个教师所授课程数据");
    }

    /**
     * 获取课程，对应某学期某个教师所授课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return success(couCourseService.selectCouCourseByCourseId(courseId));
    }

    /**
     * 新增课程，对应某学期某个教师所授课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:add')")
    @Log(title = "课程，对应某学期某个教师所授课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouCourse couCourse)
    {
        return toAjax(couCourseService.insertCouCourse(couCourse));
    }

    /**
     * 修改课程，对应某学期某个教师所授课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:edit')")
    @Log(title = "课程，对应某学期某个教师所授课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouCourse couCourse)
    {
        return toAjax(couCourseService.updateCouCourse(couCourse));
    }

    /**
     * 删除课程，对应某学期某个教师所授课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:remove')")
    @Log(title = "课程，对应某学期某个教师所授课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {
        return toAjax(couCourseService.deleteCouCourseByCourseIds(courseIds));
    }
}
