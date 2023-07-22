package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BasFileMapper;
import com.ruoyi.system.domain.BasFile;
import com.ruoyi.system.service.IBasFileService;

/**
 * 文件，主要保存物理文件的相对路径Service业务层处理
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Service
public class BasFileServiceImpl implements IBasFileService 
{
    @Autowired
    private BasFileMapper basFileMapper;

    /**
     * 查询文件，主要保存物理文件的相对路径
     * 
     * @param fileId 文件，主要保存物理文件的相对路径主键
     * @return 文件，主要保存物理文件的相对路径
     */
    @Override
    public BasFile selectBasFileByFileId(Long fileId)
    {
        return basFileMapper.selectBasFileByFileId(fileId);
    }

    /**
     * 查询文件，主要保存物理文件的相对路径列表
     * 
     * @param basFile 文件，主要保存物理文件的相对路径
     * @return 文件，主要保存物理文件的相对路径
     */
    @Override
    public List<BasFile> selectBasFileList(BasFile basFile)
    {
        return basFileMapper.selectBasFileList(basFile);
    }

    /**
     * 新增文件，主要保存物理文件的相对路径
     * 
     * @param basFile 文件，主要保存物理文件的相对路径
     * @return 结果
     */
    @Override
    public int insertBasFile(BasFile basFile)
    {
        return basFileMapper.insertBasFile(basFile);
    }

    /**
     * 修改文件，主要保存物理文件的相对路径
     * 
     * @param basFile 文件，主要保存物理文件的相对路径
     * @return 结果
     */
    @Override
    public int updateBasFile(BasFile basFile)
    {
        return basFileMapper.updateBasFile(basFile);
    }

    /**
     * 批量删除文件，主要保存物理文件的相对路径
     * 
     * @param fileIds 需要删除的文件，主要保存物理文件的相对路径主键
     * @return 结果
     */
    @Override
    public int deleteBasFileByFileIds(Long[] fileIds)
    {
        return basFileMapper.deleteBasFileByFileIds(fileIds);
    }

    /**
     * 删除文件，主要保存物理文件的相对路径信息
     * 
     * @param fileId 文件，主要保存物理文件的相对路径主键
     * @return 结果
     */
    @Override
    public int deleteBasFileByFileId(Long fileId)
    {
        return basFileMapper.deleteBasFileByFileId(fileId);
    }
}
