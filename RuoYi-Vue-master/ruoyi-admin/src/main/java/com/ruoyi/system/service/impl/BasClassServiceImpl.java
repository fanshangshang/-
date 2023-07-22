package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BasClassMapper;
import com.ruoyi.system.domain.BasClass;
import com.ruoyi.system.service.IBasClassService;

/**
 * 班级Service业务层处理
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Service
public class BasClassServiceImpl implements IBasClassService 
{
    @Autowired
    private BasClassMapper basClassMapper;

    /**
     * 查询班级
     * 
     * @param classId 班级主键
     * @return 班级
     */
    @Override
    public BasClass selectBasClassByClassId(Long classId)
    {
        return basClassMapper.selectBasClassByClassId(classId);
    }

    /**
     * 查询班级列表
     * 
     * @param basClass 班级
     * @return 班级
     */
    @Override
    public List<BasClass> selectBasClassList(BasClass basClass)
    {
        return basClassMapper.selectBasClassList(basClass);
    }

    /**
     * 新增班级
     * 
     * @param basClass 班级
     * @return 结果
     */
    @Override
    public int insertBasClass(BasClass basClass)
    {
        return basClassMapper.insertBasClass(basClass);
    }

    /**
     * 修改班级
     * 
     * @param basClass 班级
     * @return 结果
     */
    @Override
    public int updateBasClass(BasClass basClass)
    {
        return basClassMapper.updateBasClass(basClass);
    }

    /**
     * 批量删除班级
     * 
     * @param classIds 需要删除的班级主键
     * @return 结果
     */
    @Override
    public int deleteBasClassByClassIds(Long[] classIds)
    {
        return basClassMapper.deleteBasClassByClassIds(classIds);
    }

    /**
     * 删除班级信息
     * 
     * @param classId 班级主键
     * @return 结果
     */
    @Override
    public int deleteBasClassByClassId(Long classId)
    {
        return basClassMapper.deleteBasClassByClassId(classId);
    }
}
