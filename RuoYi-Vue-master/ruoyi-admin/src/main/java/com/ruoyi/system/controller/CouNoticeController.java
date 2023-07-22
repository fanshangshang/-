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
import com.ruoyi.system.domain.CouNotice;
import com.ruoyi.system.service.ICouNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公告信息Controller
 * 
 * @author ruoyi
 * @date 2023-07-13
 */
@RestController
@RequestMapping("/system/notice")
public class CouNoticeController extends BaseController
{
    @Autowired
    private ICouNoticeService couNoticeService;

    /**
     * 查询公告信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(CouNotice couNotice)
    {
        startPage();
        List<CouNotice> list = couNoticeService.selectCouNoticeList(couNotice);
        return getDataTable(list);
    }

    /**
     * 导出公告信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:notice:export')")
    @Log(title = "公告信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouNotice couNotice)
    {
        List<CouNotice> list = couNoticeService.selectCouNoticeList(couNotice);
        ExcelUtil<CouNotice> util = new ExcelUtil<CouNotice>(CouNotice.class);
        util.exportExcel(response, list, "公告信息数据");
    }

    /**
     * 获取公告信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:notice:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId)
    {
        return success(couNoticeService.selectCouNoticeByNoticeId(noticeId));
    }

    /**
     * 新增公告信息
     */
    @PreAuthorize("@ss.hasPermi('system:notice:add')")
    @Log(title = "公告信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouNotice couNotice)
    {
        return toAjax(couNoticeService.insertCouNotice(couNotice));
    }

    /**
     * 修改公告信息
     */
    @PreAuthorize("@ss.hasPermi('system:notice:edit')")
    @Log(title = "公告信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouNotice couNotice)
    {
        return toAjax(couNoticeService.updateCouNotice(couNotice));
    }

    /**
     * 删除公告信息
     */
    @PreAuthorize("@ss.hasPermi('system:notice:remove')")
    @Log(title = "公告信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(couNoticeService.deleteCouNoticeByNoticeIds(noticeIds));
    }
}
