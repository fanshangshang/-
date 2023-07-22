package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BasFile;

/**
 * 文件，主要保存物理文件的相对路径Service接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public interface IBasFileService 
{
    /**
     * 查询文件，主要保存物理文件的相对路径
     * 
     * @param fileId 文件，主要保存物理文件的相对路径主键
     * @return 文件，主要保存物理文件的相对路径
     */
    public BasFile selectBasFileByFileId(Long fileId);

    /**
     * 查询文件，主要保存物理文件的相对路径列表
     * 
     * @param basFile 文件，主要保存物理文件的相对路径
     * @return 文件，主要保存物理文件的相对路径集合
     */
    public List<BasFile> selectBasFileList(BasFile basFile);

    /**
     * 新增文件，主要保存物理文件的相对路径
     * 
     * @param basFile 文件，主要保存物理文件的相对路径
     * @return 结果
     */
    public int insertBasFile(BasFile basFile);

    /**
     * 修改文件，主要保存物理文件的相对路径
     * 
     * @param basFile 文件，主要保存物理文件的相对路径
     * @return 结果
     */
    public int updateBasFile(BasFile basFile);

    /**
     * 批量删除文件，主要保存物理文件的相对路径
     * 
     * @param fileIds 需要删除的文件，主要保存物理文件的相对路径主键集合
     * @return 结果
     */
    public int deleteBasFileByFileIds(Long[] fileIds);

    /**
     * 删除文件，主要保存物理文件的相对路径信息
     * 
     * @param fileId 文件，主要保存物理文件的相对路径主键
     * @return 结果
     */
    public int deleteBasFileByFileId(Long fileId);
}
