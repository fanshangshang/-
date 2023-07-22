package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程，对应某学期某个教师所授课程对象 cou_course
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class CouCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** course_id */
    private Long courseId;

    /** curriculum_id */
    @Excel(name = "curriculum_id")
    private Long curriculumId;

    /** 教师工号 */
    @Excel(name = "教师工号")
    private Long teacherId;

    /** 策略编号 */
    @Excel(name = "策略编号")
    private Long strategyId;

    /** 学年，格式（2023-2024） */
    @Excel(name = "学年，格式", readConverterExp = "2=023-2024")
    private String year;

    /** 学期(1:第一学期，2-第二学期) */
    @Excel(name = "学期(1:第一学期，2-第二学期)")
    private String semester;

    /** 课程编号，示例（(2022-2023-2)-0905693-029009-1） */
    @Excel(name = "课程编号，示例", readConverterExp = "(=2022-2023-2)-0905693-029009-1")
    private String code;

    /** 课程类型（0普通课程；1数理类公共基础课；2非数理类公共基础课；3通识选修课；4在线开放课） */
    @Excel(name = "课程类型", readConverterExp = "0=普通课程；1数理类公共基础课；2非数理类公共基础课；3通识选修课；4在线开放课")
    private String type;

    /** 授课方式（0普通授课；1双语授课；2全英文授课；3研究型教学） */
    @Excel(name = "授课方式", readConverterExp = "0=普通授课；1双语授课；2全英文授课；3研究型教学")
    private String method;

    /** 是否重复班（0否；1是） */
    @Excel(name = "是否重复班", readConverterExp = "0=否；1是")
    private String repetitive;

    /** 是否重复班（0否；1是） */
    @Excel(name = "是否重复班", readConverterExp = "0=否；1是")
    private String repetitive2;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCurriculumId(Long curriculumId) 
    {
        this.curriculumId = curriculumId;
    }

    public Long getCurriculumId() 
    {
        return curriculumId;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }
    public void setStrategyId(Long strategyId) 
    {
        this.strategyId = strategyId;
    }

    public Long getStrategyId() 
    {
        return strategyId;
    }
    public void setYear(String year) 
    {
        this.year = year;
    }

    public String getYear() 
    {
        return year;
    }
    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public String getSemester() 
    {
        return semester;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setMethod(String method) 
    {
        this.method = method;
    }

    public String getMethod() 
    {
        return method;
    }
    public void setRepetitive(String repetitive) 
    {
        this.repetitive = repetitive;
    }

    public String getRepetitive() 
    {
        return repetitive;
    }
    public void setRepetitive2(String repetitive2) 
    {
        this.repetitive2 = repetitive2;
    }

    public String getRepetitive2() 
    {
        return repetitive2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("curriculumId", getCurriculumId())
            .append("teacherId", getTeacherId())
            .append("strategyId", getStrategyId())
            .append("year", getYear())
            .append("semester", getSemester())
            .append("code", getCode())
            .append("type", getType())
            .append("method", getMethod())
            .append("repetitive", getRepetitive())
            .append("repetitive2", getRepetitive2())
            .toString();
    }
}
