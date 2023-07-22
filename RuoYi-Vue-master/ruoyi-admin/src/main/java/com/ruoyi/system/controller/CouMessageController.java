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
import com.ruoyi.system.domain.CouMessage;
import com.ruoyi.system.service.ICouMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息，可以用来示学生和教师之间的交互。Controller
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/system/message")
public class CouMessageController extends BaseController
{
    @Autowired
    private ICouMessageService couMessageService;

    /**
     * 查询消息，可以用来示学生和教师之间的交互。列表
     */
    @PreAuthorize("@ss.hasPermi('system:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(CouMessage couMessage)
    {
        startPage();
        List<CouMessage> list = couMessageService.selectCouMessageList(couMessage);
        return getDataTable(list);
    }

    /**
     * 导出消息，可以用来示学生和教师之间的交互。列表
     */
    @PreAuthorize("@ss.hasPermi('system:message:export')")
    @Log(title = "消息，可以用来示学生和教师之间的交互。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouMessage couMessage)
    {
        List<CouMessage> list = couMessageService.selectCouMessageList(couMessage);
        ExcelUtil<CouMessage> util = new ExcelUtil<CouMessage>(CouMessage.class);
        util.exportExcel(response, list, "消息，可以用来示学生和教师之间的交互。数据");
    }

    /**
     * 获取消息，可以用来示学生和教师之间的交互。详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:message:query')")
    @GetMapping(value = "/{messageId}")
    public AjaxResult getInfo(@PathVariable("messageId") Long messageId)
    {
        return success(couMessageService.selectCouMessageByMessageId(messageId));
    }

    /**
     * 新增消息，可以用来示学生和教师之间的交互。
     */
    @PreAuthorize("@ss.hasPermi('system:message:add')")
    @Log(title = "消息，可以用来示学生和教师之间的交互。", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouMessage couMessage)
    {
        return toAjax(couMessageService.insertCouMessage(couMessage));
    }

    /**
     * 修改消息，可以用来示学生和教师之间的交互。
     */
    @PreAuthorize("@ss.hasPermi('system:message:edit')")
    @Log(title = "消息，可以用来示学生和教师之间的交互。", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouMessage couMessage)
    {
        return toAjax(couMessageService.updateCouMessage(couMessage));
    }

    /**
     * 删除消息，可以用来示学生和教师之间的交互。
     */
    @PreAuthorize("@ss.hasPermi('system:message:remove')")
    @Log(title = "消息，可以用来示学生和教师之间的交互。", businessType = BusinessType.DELETE)
	@DeleteMapping("/{messageIds}")
    public AjaxResult remove(@PathVariable Long[] messageIds)
    {
        return toAjax(couMessageService.deleteCouMessageByMessageIds(messageIds));
    }
}
