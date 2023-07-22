package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CurResourceMapper;
import com.ruoyi.system.domain.CurResource;
import com.ruoyi.system.service.ICurResourceService;

/**
 * 课程资源，比如教学大纲，教案，电子教材以及实验要求等Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class CurResourceServiceImpl implements ICurResourceService 
{
    @Autowired
    private CurResourceMapper curResourceMapper;

    /**
     * 查询课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param resourceId 课程资源，比如教学大纲，教案，电子教材以及实验要求等主键
     * @return 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     */
    @Override
    public CurResource selectCurResourceByResourceId(Long resourceId)
    {
        return curResourceMapper.selectCurResourceByResourceId(resourceId);
    }

    /**
     * 查询课程资源，比如教学大纲，教案，电子教材以及实验要求等列表
     * 
     * @param curResource 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * @return 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     */
    @Override
    public List<CurResource> selectCurResourceList(CurResource curResource)
    {
        return curResourceMapper.selectCurResourceList(curResource);
    }

    /**
     * 新增课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param curResource 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * @return 结果
     */
    @Override
    public int insertCurResource(CurResource curResource)
    {
        return curResourceMapper.insertCurResource(curResource);
    }

    /**
     * 修改课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param curResource 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * @return 结果
     */
    @Override
    public int updateCurResource(CurResource curResource)
    {
        return curResourceMapper.updateCurResource(curResource);
    }

    /**
     * 批量删除课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param resourceIds 需要删除的课程资源，比如教学大纲，教案，电子教材以及实验要求等主键
     * @return 结果
     */
    @Override
    public int deleteCurResourceByResourceIds(Long[] resourceIds)
    {
        return curResourceMapper.deleteCurResourceByResourceIds(resourceIds);
    }

    /**
     * 删除课程资源，比如教学大纲，教案，电子教材以及实验要求等信息
     * 
     * @param resourceId 课程资源，比如教学大纲，教案，电子教材以及实验要求等主键
     * @return 结果
     */
    @Override
    public int deleteCurResourceByResourceId(Long resourceId)
    {
        return curResourceMapper.deleteCurResourceByResourceId(resourceId);
    }
}
