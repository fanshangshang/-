package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文件，主要保存物理文件的相对路径对象 bas_file
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public class BasFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long fileId;

    /** 资源编号 */
    @Excel(name = "资源编号")
    private Long resourceId;

    /** 题目编号 */
    @Excel(name = "题目编号")
    private Long exerciseId;

    /** 消息编号 */
    @Excel(name = "消息编号")
    private Long messageId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String name;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String path;

    /** 文件格式 */
    @Excel(name = "文件格式")
    private String type;

    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }
    public void setResourceId(Long resourceId) 
    {
        this.resourceId = resourceId;
    }

    public Long getResourceId() 
    {
        return resourceId;
    }
    public void setExerciseId(Long exerciseId) 
    {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId() 
    {
        return exerciseId;
    }
    public void setMessageId(Long messageId) 
    {
        this.messageId = messageId;
    }

    public Long getMessageId() 
    {
        return messageId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
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
            .append("fileId", getFileId())
            .append("resourceId", getResourceId())
            .append("exerciseId", getExerciseId())
            .append("messageId", getMessageId())
            .append("name", getName())
            .append("path", getPath())
            .append("type", getType())
            .toString();
    }
}
