package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 某个周某个时段的某次课对象 cou_lesson
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public class CouLesson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long lessonId;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long courseId;

    /** 课次编号 */
    @Excel(name = "课次编号")
    private Long lectureId;

    /** 授课时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "授课时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 节次（0一二节；1三四节；2五六节；3七八节；4九十节） */
    @Excel(name = "节次", readConverterExp = "0=一二节；1三四节；2五六节；3七八节；4九十节")
    private String section;

    /** 周次 */
    @Excel(name = "周次")
    private Long weekNumber;

    /** 星期几 */
    @Excel(name = "星期几")
    private String weekDay;

    /** 授课地点 */
    @Excel(name = "授课地点")
    private String location;

    /** 授课类型（0理论；1上机；2实验；3校外） */
    @Excel(name = "授课类型", readConverterExp = "0=理论；1上机；2实验；3校外")
    private String type;

    public void setLessonId(Long lessonId) 
    {
        this.lessonId = lessonId;
    }

    public Long getLessonId() 
    {
        return lessonId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setLectureId(Long lectureId) 
    {
        this.lectureId = lectureId;
    }

    public Long getLectureId() 
    {
        return lectureId;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setSection(String section) 
    {
        this.section = section;
    }

    public String getSection() 
    {
        return section;
    }
    public void setWeekNumber(Long weekNumber) 
    {
        this.weekNumber = weekNumber;
    }

    public Long getWeekNumber() 
    {
        return weekNumber;
    }
    public void setWeekDay(String weekDay) 
    {
        this.weekDay = weekDay;
    }

    public String getWeekDay() 
    {
        return weekDay;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lessonId", getLessonId())
            .append("courseId", getCourseId())
            .append("lectureId", getLectureId())
            .append("date", getDate())
            .append("section", getSection())
            .append("weekNumber", getWeekNumber())
            .append("weekDay", getWeekDay())
            .append("location", getLocation())
            .append("type", getType())
            .toString();
    }
}
