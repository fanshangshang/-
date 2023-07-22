package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CurResource;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程资源，比如教学大纲，教案，电子教材以及实验要求等Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Mapper
public interface CurResourceMapper 
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
     * 删除课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param resourceId 课程资源，比如教学大纲，教案，电子教材以及实验要求等主键
     * @return 结果
     */
    public int deleteCurResourceByResourceId(Long resourceId);

    /**
     * 批量删除课程资源，比如教学大纲，教案，电子教材以及实验要求等
     * 
     * @param resourceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCurResourceByResourceIds(Long[] resourceIds);
}
