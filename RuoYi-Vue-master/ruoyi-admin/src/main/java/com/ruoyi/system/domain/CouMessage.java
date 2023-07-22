package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息，可以用来示学生和教师之间的交互。对象 cou_message
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public class CouMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long messageId;

    /** 评价编号 */
    @Excel(name = "评价编号")
    private Long assessmentId;

    /** 被回复消息编号 */
    @Excel(name = "被回复消息编号")
    private Long parentMessageId;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String content;

    /** 消息标题 */
    @Excel(name = "消息标题")
    private String title;

    /** 附件文件路径 */
    @Excel(name = "附件文件路径")
    private String attachment;

    public void setMessageId(Long messageId) 
    {
        this.messageId = messageId;
    }

    public Long getMessageId() 
    {
        return messageId;
    }
    public void setAssessmentId(Long assessmentId) 
    {
        this.assessmentId = assessmentId;
    }

    public Long getAssessmentId() 
    {
        return assessmentId;
    }
    public void setParentMessageId(Long parentMessageId) 
    {
        this.parentMessageId = parentMessageId;
    }

    public Long getParentMessageId() 
    {
        return parentMessageId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("messageId", getMessageId())
            .append("assessmentId", getAssessmentId())
            .append("parentMessageId", getParentMessageId())
            .append("content", getContent())
            .append("title", getTitle())
            .append("attachment", getAttachment())
            .toString();
    }
}
