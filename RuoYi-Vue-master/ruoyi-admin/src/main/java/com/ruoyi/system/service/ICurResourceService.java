package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CurResource;

/**
 * 课程资源，比如教学大纲，教案，电子教材以及实验要求等Service接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface ICurResourceService 
{
    /**
     * 查询课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param resourceId 课程资源，比如教学大纲，教案，电子教材以及实验要求等主键
     * @return 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     */
    public CurResource selectCurResourceByResourceId(Long resourceId);

    /**
     * 查询课程资源，比如教学大纲，教案，电子教材以及实验要求等列表
     * 
     * @param curResource 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * @return 课程资源，比如教学大纲，教案，电子教材以及实验要求等集合
     */
    public List<CurResource> selectCurResourceList(CurResource curResource);

    /**
     * 新增课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param curResource 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * @return 结果
     */
    public int insertCurResource(CurResource curResource);

    /**
     * 修改课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param curResource 课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * @return 结果
     */
    public int updateCurResource(CurResource curResource);

    /**
     * 批量删除课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param resourceIds 需要删除的课程资源，比如教学大纲，教案，电子教材以及实验要求等主键集合
     * @return 结果
     */
    public int deleteCurResourceByResourceIds(Long[] resourceIds);

    /**
     * 删除课程资源，比如教学大纲，教案，电子教材以及实验要求等信息
     * 
     * @param resourceId 课程资源，比如教学大纲，教案，电子教材以及实验要求等主键
     * @return 结果
     */
    public int deleteCurResourceByResourceId(Long resourceId);
}
