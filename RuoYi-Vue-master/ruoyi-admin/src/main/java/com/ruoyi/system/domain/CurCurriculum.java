package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大纲课程信息对象 cur_curriculum
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class CurCurriculum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** curriculum编号 */
    private Long curriculumId;

    /** 课程编码 */
    @Excel(name = "课程编码")
    private String code;

    /** 部门编号 */
    @Excel(name = "部门编号")
    private Long deptId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String name;

    /** 学分 */
    @Excel(name = "学分")
    private Long credit;

    /** 理论学时 */
    @Excel(name = "理论学时")
    private Long theoryHours;

    /** 类别（0公共基础课；1学科基础课；2专业主干课；3专业任选课；4集中性实践教学环节；5通修课；6专业方向课；） */
    @Excel(name = "类别", readConverterExp = "0=公共基础课；1学科基础课；2专业主干课；3专业任选课；4集中性实践教学环节；5通修课；6专业方向课；")
    private String type;

    /** 课程性质（0通修（必）；1公共（必）；2学科（必）；3专业（必）；4实践（必）；5公共（选）；6专业（选）；7实践（选）；8方向（选）） */
    @Excel(name = "课程性质", readConverterExp = "0通修（必）；1公共（必）；2学科（必）；3专业（必）；4实践（必）；5公共（选）；6专业（选）；7实践（选）；8方向（选）")
    private String nature;

    /** 实践学时 */
    @Excel(name = "实践学时")
    private Long laboratoryHours;

    public void setCurriculumId(Long curriculumId) 
    {
        this.curriculumId = curriculumId;
    }

    public Long getCurriculumId() 
    {
        return curriculumId;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCredit(Long credit) 
    {
        this.credit = credit;
    }

    public Long getCredit() 
    {
        return credit;
    }
    public void setTheoryHours(Long theoryHours) 
    {
        this.theoryHours = theoryHours;
    }

    public Long getTheoryHours() 
    {
        return theoryHours;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setNature(String nature) 
    {
        this.nature = nature;
    }

    public String getNature() 
    {
        return nature;
    }
    public void setLaboratoryHours(Long laboratoryHours) 
    {
        this.laboratoryHours = laboratoryHours;
    }

    public Long getLaboratoryHours() 
    {
        return laboratoryHours;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("curriculumId", getCurriculumId())
            .append("code", getCode())
            .append("deptId", getDeptId())
            .append("name", getName())
            .append("credit", getCredit())
            .append("theoryHours", getTheoryHours())
            .append("type", getType())
            .append("nature", getNature())
            .append("laboratoryHours", getLaboratoryHours())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
