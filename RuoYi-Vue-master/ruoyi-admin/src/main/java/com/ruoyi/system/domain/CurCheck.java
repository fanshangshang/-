package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 题目任务关系对象 cur_check
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class CurCheck extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long taskId;

    /** 题目编号 */
    @Excel(name = "题目编号")
    private Long exerciseId;

    /** 编号 */
    private Long checkId;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setExerciseId(Long exerciseId) 
    {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId() 
    {
        return exerciseId;
    }
    public void setCheckId(Long checkId) 
    {
        this.checkId = checkId;
    }

    public Long getCheckId() 
    {
        return checkId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("exerciseId", getExerciseId())
            .append("checkId", getCheckId())
            .toString();
    }
}
