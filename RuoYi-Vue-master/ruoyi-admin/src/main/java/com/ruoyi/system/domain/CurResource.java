package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程资源，比如教学大纲，教案，电子教材以及实验要求等对象 cur_resource
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class CurResource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long resourceId;

    /** 讲课编号 */
    @Excel(name = "讲课编号")
    private Long lectureId;

    /** 资源类型（0教材；1教学大纲；2教案；3讲稿；4实验指导；5参考文档；6音视频） */
    @Excel(name = "资源类型", readConverterExp = "0=教材；1教学大纲；2教案；3讲稿；4实验指导；5参考文档；6音视频")
    private String type;

    /** 资源名称 */
    @Excel(name = "资源名称")
    private String name;

    /** 是否可以下载（0是；1否） */
    @Excel(name = "是否可以下载", readConverterExp = "0=是；1否")
    private String downloadable;

    /** 是否可读(0可读；1不可读) */
    @Excel(name = "是否可读(0可读；1不可读)")
    private String readable;

    /** 是否授课后开放（0：是；1：否） */
    @Excel(name = "是否授课后开放", readConverterExp = "0=：是；1：否")
    private String lectured;

    /** 附件文件路径 */
    @Excel(name = "附件文件路径")
    private String attachment;

    public void setResourceId(Long resourceId) 
    {
        this.resourceId = resourceId;
    }

    public Long getResourceId() 
    {
        return resourceId;
    }
    public void setLectureId(Long lectureId) 
    {
        this.lectureId = lectureId;
    }

    public Long getLectureId() 
    {
        return lectureId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDownloadable(String downloadable) 
    {
        this.downloadable = downloadable;
    }

    public String getDownloadable() 
    {
        return downloadable;
    }
    public void setReadable(String readable) 
    {
        this.readable = readable;
    }

    public String getReadable() 
    {
        return readable;
    }
    public void setLectured(String lectured) 
    {
        this.lectured = lectured;
    }

    public String getLectured() 
    {
        return lectured;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resourceId", getResourceId())
            .append("lectureId", getLectureId())
            .append("type", getType())
            .append("name", getName())
            .append("downloadable", getDownloadable())
            .append("readable", getReadable())
            .append("lectured", getLectured())
            .append("attachment", getAttachment())
            .toString();
    }
}
