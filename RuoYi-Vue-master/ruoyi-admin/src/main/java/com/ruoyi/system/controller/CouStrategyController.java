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
import com.ruoyi.system.domain.CouStrategy;
import com.ruoyi.system.service.ICouStrategyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/strategy")
public class CouStrategyController extends BaseController
{
    @Autowired
    private ICouStrategyService couStrategyService;

    /**
     * 查询成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。列表
     */
    @PreAuthorize("@ss.hasPermi('system:strategy:list')")
    @GetMapping("/list")
    public TableDataInfo list(CouStrategy couStrategy)
    {
        startPage();
        List<CouStrategy> list = couStrategyService.selectCouStrategyList(couStrategy);
        return getDataTable(list);
    }

    /**
     * 导出成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。列表
     */
    @PreAuthorize("@ss.hasPermi('system:strategy:export')")
    @Log(title = "成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouStrategy couStrategy)
    {
        List<CouStrategy> list = couStrategyService.selectCouStrategyList(couStrategy);
        ExcelUtil<CouStrategy> util = new ExcelUtil<CouStrategy>(CouStrategy.class);
        util.exportExcel(response, list, "成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。数据");
    }

    /**
     * 获取成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:strategy:query')")
    @GetMapping(value = "/{strategyId}")
    public AjaxResult getInfo(@PathVariable("strategyId") Long strategyId)
    {
        return success(couStrategyService.selectCouStrategyByStrategyId(strategyId));
    }

    /**
     * 新增成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     */
    @PreAuthorize("@ss.hasPermi('system:strategy:add')")
    @Log(title = "成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouStrategy couStrategy)
    {
        return toAjax(couStrategyService.insertCouStrategy(couStrategy));
    }

    /**
     * 修改成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     */
    @PreAuthorize("@ss.hasPermi('system:strategy:edit')")
    @Log(title = "成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouStrategy couStrategy)
    {
        return toAjax(couStrategyService.updateCouStrategy(couStrategy));
    }

    /**
     * 删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     */
    @PreAuthorize("@ss.hasPermi('system:strategy:remove')")
    @Log(title = "成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。", businessType = BusinessType.DELETE)
	@DeleteMapping("/{strategyIds}")
    public AjaxResult remove(@PathVariable Long[] strategyIds)
    {
        return toAjax(couStrategyService.deleteCouStrategyByStrategyIds(strategyIds));
    }
}
