package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 一次评价对象 cou_assessment
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public class CouAssessment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long assessmentId;

    /** 选课编号 */
    @Excel(name = "选课编号")
    private Long enrollId;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long taskId;

    /** 评价类别（0考勤；1课堂；2任务） */
    @Excel(name = "评价类别", readConverterExp = "0=考勤；1课堂；2任务")
    private String type;

    /** 评价结果 */
    @Excel(name = "评价结果")
    private Long result;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal latitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal longitude;

    /** 打分 */
    @Excel(name = "打分")
    private String mark;

    /** 附件文件路径 */
    @Excel(name = "附件文件路径")
    private String attachment;

    public void setAssessmentId(Long assessmentId) 
    {
        this.assessmentId = assessmentId;
    }

    public Long getAssessmentId() 
    {
        return assessmentId;
    }
    public void setEnrollId(Long enrollId) 
    {
        this.enrollId = enrollId;
    }

    public Long getEnrollId() 
    {
        return enrollId;
    }
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setResult(Long result) 
    {
        this.result = result;
    }

    public Long getResult() 
    {
        return result;
    }
    public void setLatitude(BigDecimal latitude) 
    {
        this.latitude = latitude;
    }

    public BigDecimal getLatitude() 
    {
        return latitude;
    }
    public void setLongitude(BigDecimal longitude) 
    {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() 
    {
        return longitude;
    }
    public void setMark(String mark) 
    {
        this.mark = mark;
    }

    public String getMark() 
    {
        return mark;
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
            .append("assessmentId", getAssessmentId())
            .append("enrollId", getEnrollId())
            .append("taskId", getTaskId())
            .append("type", getType())
            .append("result", getResult())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("mark", getMark())
            .append("attachment", getAttachment())
            .toString();
    }
}
