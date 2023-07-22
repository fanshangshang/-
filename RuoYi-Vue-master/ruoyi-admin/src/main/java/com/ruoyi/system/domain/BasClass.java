package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班级对象 bas_class
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public class BasClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long classId;

    /** 部门编号 */
    @Excel(name = "部门编号")
    private Long deptId;

    /** 班主任编号 */
    @Excel(name = "班主任编号")
    private Long adviserId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String name;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 学生人数 */
    @Excel(name = "学生人数")
    private Long number;

    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setAdviserId(Long adviserId) 
    {
        this.adviserId = adviserId;
    }

    public Long getAdviserId() 
    {
        return adviserId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("classId", getClassId())
            .append("deptId", getDeptId())
            .append("adviserId", getAdviserId())
            .append("name", getName())
            .append("grade", getGrade())
            .append("major", getMajor())
            .append("number", getNumber())
            .toString();
    }
}
