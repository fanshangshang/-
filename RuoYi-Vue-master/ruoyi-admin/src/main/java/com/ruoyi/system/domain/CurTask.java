package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学习任务，比如一次作业，一次随堂测试等。对象 cur_task
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class CurTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long taskId;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long lectureId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String name;

    /** 任务类别(0作业；1实验；2测试；3讨论；4考试；5报告；6程序) */
    @Excel(name = "任务类别")
    private String type;

    /** 结束周次(1-20) */
    @Excel(name = "结束周次(1-20)")
    private Long deadline;

    /** 是否开放任务（0是；1否） */
    @Excel(name = "是否开放任务", readConverterExp = "0=是；1否")
    private String open;

    /** 任务内容 */
    @Excel(name = "任务内容")
    private String requirement;

    /** 提交文件命名规范，每部分用[]包含（比如[学号][姓名]） */
    @Excel(name = "提交文件命名规范，每部分用[]包含", readConverterExp = "比=如[学号][姓名]")
    private String submitFormat;

    /** 提交文件格式，用/隔开（比如docx/doc） */
    @Excel(name = "提交文件格式，用/隔开", readConverterExp = "比=如docx/doc")
    private String submitType;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setLectureId(Long lectureId) 
    {
        this.lectureId = lectureId;
    }

    public Long getLectureId() 
    {
        return lectureId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDeadline(Long deadline) 
    {
        this.deadline = deadline;
    }

    public Long getDeadline() 
    {
        return deadline;
    }
    public void setOpen(String open) 
    {
        this.open = open;
    }

    public String getOpen() 
    {
        return open;
    }
    public void setRequirement(String requirement) 
    {
        this.requirement = requirement;
    }

    public String getRequirement() 
    {
        return requirement;
    }
    public void setSubmitFormat(String submitFormat) 
    {
        this.submitFormat = submitFormat;
    }

    public String getSubmitFormat() 
    {
        return submitFormat;
    }
    public void setSubmitType(String submitType) 
    {
        this.submitType = submitType;
    }

    public String getSubmitType() 
    {
        return submitType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("lectureId", getLectureId())
            .append("name", getName())
            .append("type", getType())
            .append("deadline", getDeadline())
            .append("open", getOpen())
            .append("requirement", getRequirement())
            .append("submitFormat", getSubmitFormat())
            .append("submitType", getSubmitType())
            .toString();
    }
}
