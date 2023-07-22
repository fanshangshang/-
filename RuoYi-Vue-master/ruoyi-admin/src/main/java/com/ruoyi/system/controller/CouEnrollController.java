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
import com.ruoyi.system.domain.CouEnroll;
import com.ruoyi.system.service.ICouEnrollService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选课信息，包含某学生选择某课程之后的各种成绩组成Controller
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/enroll")
public class CouEnrollController extends BaseController
{
    @Autowired
    private ICouEnrollService couEnrollService;

    /**
     * 查询选课信息，包含某学生选择某课程之后的各种成绩组成列表
     */
    @PreAuthorize("@ss.hasPermi('system:enroll:list')")
    @GetMapping("/list")
    public TableDataInfo list(CouEnroll couEnroll)
    {
        startPage();
        List<CouEnroll> list = couEnrollService.selectCouEnrollList(couEnroll);
        return getDataTable(list);
    }

    /**
     * 导出选课信息，包含某学生选择某课程之后的各种成绩组成列表
     */
    @PreAuthorize("@ss.hasPermi('system:enroll:export')")
    @Log(title = "选课信息，包含某学生选择某课程之后的各种成绩组成", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouEnroll couEnroll)
    {
        List<CouEnroll> list = couEnrollService.selectCouEnrollList(couEnroll);
        ExcelUtil<CouEnroll> util = new ExcelUtil<CouEnroll>(CouEnroll.class);
        util.exportExcel(response, list, "选课信息，包含某学生选择某课程之后的各种成绩组成数据");
    }

    /**
     * 获取选课信息，包含某学生选择某课程之后的各种成绩组成详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:enroll:query')")
    @GetMapping(value = "/{enrollId}")
    public AjaxResult getInfo(@PathVariable("enrollId") Long enrollId)
    {
        return success(couEnrollService.selectCouEnrollByEnrollId(enrollId));
    }

    /**
     * 新增选课信息，包含某学生选择某课程之后的各种成绩组成
     */
    @PreAuthorize("@ss.hasPermi('system:enroll:add')")
    @Log(title = "选课信息，包含某学生选择某课程之后的各种成绩组成", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouEnroll couEnroll)
    {
        return toAjax(couEnrollService.insertCouEnroll(couEnroll));
    }

    /**
     * 修改选课信息，包含某学生选择某课程之后的各种成绩组成
     */
    @PreAuthorize("@ss.hasPermi('system:enroll:edit')")
    @Log(title = "选课信息，包含某学生选择某课程之后的各种成绩组成", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouEnroll couEnroll)
    {
        return toAjax(couEnrollService.updateCouEnroll(couEnroll));
    }

    /**
     * 删除选课信息，包含某学生选择某课程之后的各种成绩组成
     */
    @PreAuthorize("@ss.hasPermi('system:enroll:remove')")
    @Log(title = "选课信息，包含某学生选择某课程之后的各种成绩组成", businessType = BusinessType.DELETE)
	@DeleteMapping("/{enrollIds}")
    public AjaxResult remove(@PathVariable Long[] enrollIds)
    {
        return toAjax(couEnrollService.deleteCouEnrollByEnrollIds(enrollIds));
    }
}
