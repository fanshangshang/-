package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息对象 bas_student
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class BasStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 编号 */
    private Long studentId;

    /** 账户编号 */
    @Excel(name = "账户编号")
    private Long userId;

    /** 班级编号 */
    @Excel(name = "班级编号")
    private Long classId;

    /** 学号 */
    @Excel(name = "学号")
    private String code;

    /** 学生类别（0普通学生；1民族生；2留学生；3交换生） */
    @Excel(name = "学生类别", readConverterExp = "0=普通学生；1民族生；2留学生；3交换生")
    private String type;

    /** 状态（0正常；1休学；2留级；3退学） */
    @Excel(name = "状态", readConverterExp = "0=正常；1休学；2留级；3退学")
    private String status;

    /** 性别（0男生；1女生） */
    @Excel(name = "性别", readConverterExp = "0=男生；1女生")
    private String gender;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
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
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("name", getName())
            .append("studentId", getStudentId())
            .append("userId", getUserId())
            .append("classId", getClassId())
            .append("code", getCode())
            .append("type", getType())
            .append("status", getStatus())
            .append("gender", getGender())
            .toString();
    }
}
