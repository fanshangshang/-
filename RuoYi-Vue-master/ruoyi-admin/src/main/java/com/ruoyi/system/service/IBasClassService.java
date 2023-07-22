package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BasClass;

/**

 */
public interface IBasClassService 
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
     * 批量删除班级
     * 
     * @param classIds 需要删除的班级主键集合
     * @return 结果
     */
    public int deleteBasClassByClassIds(Long[] classIds);

    /**
     * 删除班级信息
     * 
     * @param classId 班级主键
     * @return 结果
     */
    public int deleteBasClassByClassId(Long classId);
}
