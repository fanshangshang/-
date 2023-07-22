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
import com.ruoyi.system.domain.CouAssessment;
import com.ruoyi.system.service.ICouAssessmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 一次评价Controller
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/assessment")
public class CouAssessmentController extends BaseController
{
    @Autowired
    private ICouAssessmentService couAssessmentService;

    /**
     * 查询一次评价列表
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:list')")
    @GetMapping("/list")
    public TableDataInfo list(CouAssessment couAssessment)
    {
        startPage();
        List<CouAssessment> list = couAssessmentService.selectCouAssessmentList(couAssessment);
        return getDataTable(list);
    }

    /**
     * 导出一次评价列表
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:export')")
    @Log(title = "一次评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouAssessment couAssessment)
    {
        List<CouAssessment> list = couAssessmentService.selectCouAssessmentList(couAssessment);
        ExcelUtil<CouAssessment> util = new ExcelUtil<CouAssessment>(CouAssessment.class);
        util.exportExcel(response, list, "一次评价数据");
    }

    /**
     * 获取一次评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:query')")
    @GetMapping(value = "/{assessmentId}")
    public AjaxResult getInfo(@PathVariable("assessmentId") Long assessmentId)
    {
        return success(couAssessmentService.selectCouAssessmentByAssessmentId(assessmentId));
    }

    /**
     * 新增一次评价
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:add')")
    @Log(title = "一次评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouAssessment couAssessment)
    {
        return toAjax(couAssessmentService.insertCouAssessment(couAssessment));
    }

    /**
     * 修改一次评价
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:edit')")
    @Log(title = "一次评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouAssessment couAssessment)
    {
        return toAjax(couAssessmentService.updateCouAssessment(couAssessment));
    }

    /**
     * 删除一次评价
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:remove')")
    @Log(title = "一次评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{assessmentIds}")
    public AjaxResult remove(@PathVariable Long[] assessmentIds)
    {
        return toAjax(couAssessmentService.deleteCouAssessmentByAssessmentIds(assessmentIds));
    }
}
