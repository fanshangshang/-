package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师信息对象 bas_teacher
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public class BasTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教师基本信息表主键 */
    private Long teacherId;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String name;

    /** 教师工号 */
    @Excel(name = "教师工号")
    private String teacherCode;

    /** 系统管理员id */
    @Excel(name = "系统管理员id")
    private Long userId;

    /** 所属部门id */
    @Excel(name = "所属部门id")
    private Long deptId;

    /** 教师职称（0助教；1讲师；2副教授；3教授；4副研究员；5研究员；6实验师；7高级实验师） */
    @Excel(name = "教师职称", readConverterExp ="0助教；1讲师；2副教授；3教授；4副研究员；5研究员；6实验师；7高级实验师")
    private String title;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 办公室 */
    @Excel(name = "办公室")
    private String office;

    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTeacherCode(String teacherCode) 
    {
        this.teacherCode = teacherCode;
    }

    public String getTeacherCode() 
    {
        return teacherCode;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setOffice(String office) 
    {
        this.office = office;
    }

    public String getOffice() 
    {
        return office;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teacherId", getTeacherId())
            .append("name", getName())
            .append("teacherCode", getTeacherCode())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("title", getTitle())
            .append("phone", getPhone())
            .append("office", getOffice())
            .toString();
    }
}
