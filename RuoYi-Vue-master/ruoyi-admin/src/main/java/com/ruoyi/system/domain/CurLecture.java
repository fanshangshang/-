package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 示某一讲对象 cur_lecture
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class CurLecture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long lectureId;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long curriculumId;

    /** 次序 */
    @Excel(name = "次序")
    private Long order;

    /** 本讲名称 */
    @Excel(name = "本讲名称")
    private String name;

    public void setLectureId(Long lectureId) 
    {
        this.lectureId = lectureId;
    }

    public Long getLectureId() 
    {
        return lectureId;
    }
    public void setCurriculumId(Long curriculumId) 
    {
        this.curriculumId = curriculumId;
    }

    public Long getCurriculumId() 
    {
        return curriculumId;
    }
    public void setOrder(Long order) 
    {
        this.order = order;
    }

    public Long getOrder() 
    {
        return order;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lectureId", getLectureId())
            .append("curriculumId", getCurriculumId())
            .append("order", getOrder())
            .append("name", getName())
            .toString();
    }
}
