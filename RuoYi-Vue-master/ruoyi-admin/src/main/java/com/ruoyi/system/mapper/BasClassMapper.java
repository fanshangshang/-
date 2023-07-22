package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BasClass;
import org.apache.ibatis.annotations.Mapper;

/**
 * 班级Mapper接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Mapper
public interface BasClassMapper
{
    /**
     * 查询班级
     * 
     * @param classId 班级主键
     * @return 班级
     */
    public BasClass selectBasClassByClassId(Long classId);

    /**
     * 查询班级列表
     * 
     * @param basClass 班级
     * @return 班级集合
     */
    public List<BasClass> selectBasClassList(BasClass basClass);

    /**
     * 新增班级
     * 
     * @param basClass 班级
     * @return 结果
     */
    public int insertBasClass(BasClass basClass);

    /**
     * 修改班级
     * 
     * @param basClass 班级
     * @return 结果
     */
    public int updateBasClass(BasClass basClass);

    /**
     * 删除班级
     * 
     * @param classId 班级主键
     * @return 结果
     */
    public int deleteBasClassByClassId(Long classId);

    /**
     * 批量删除班级
     * 
     * @param classIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBasClassByClassIds(Long[] classIds);
}
