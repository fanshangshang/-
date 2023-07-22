package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 选课信息，包含某学生选择某课程之后的各种成绩组成对象 cou_enroll
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public class CouEnroll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 选课编号 */
    private Long enrollId;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long courseId;

    /** 学生学号 */
    @Excel(name = "学生学号")
    private Long studentId;

    /** 平时成绩 */
    @Excel(name = "平时成绩")
    private Long usualScore;

    /** 期中成绩 */
    @Excel(name = "期中成绩")
    private Long midScore;

    /** 期末成绩 */
    @Excel(name = "期末成绩")
    private Long finalScore;

    /** 其它成绩 */
    @Excel(name = "其它成绩")
    private Long otherScore;

    /** 总评成绩 */
    @Excel(name = "总评成绩")
    private Long totalScore;

    public void setEnrollId(Long enrollId) 
    {
        this.enrollId = enrollId;
    }

    public Long getEnrollId() 
    {
        return enrollId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setUsualScore(Long usualScore) 
    {
        this.usualScore = usualScore;
    }

    public Long getUsualScore() 
    {
        return usualScore;
    }
    public void setMidScore(Long midScore)
    {
        this.midScore = midScore;
    }

    public Long getMidScore()
    {
        return midScore;
    }
    public void setFinalScore(Long finalScore) 
    {
        this.finalScore = finalScore;
    }

    public Long getFinalScore() 
    {
        return finalScore;
    }
    public void setOtherScore(Long otherScore) 
    {
        this.otherScore = otherScore;
    }

    public Long getOtherScore() 
    {
        return otherScore;
    }
    public void setTotalScore(Long totalScore) 
    {
        this.totalScore = totalScore;
    }

    public Long getTotalScore() 
    {
        return totalScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("enrollId", getEnrollId())
            .append("courseId", getCourseId())
            .append("studentId", getStudentId())
            .append("usualScore", getUsualScore())
            .append("midScore", getMidScore())
            .append("finalScore", getFinalScore())
            .append("otherScore", getOtherScore())
            .append("totalScore", getTotalScore())
            .toString();
    }
}
