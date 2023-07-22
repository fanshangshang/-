package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BasStudentMapper;
import com.ruoyi.system.domain.BasStudent;
import com.ruoyi.system.service.IBasStudentService;

/**
 * 学生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class BasStudentServiceImpl implements IBasStudentService 
{
    @Autowired
    private BasStudentMapper basStudentMapper;

    /**
     * 查询学生信息
     * 
     * @param studentId 学生信息主键
     * @return 学生信息
     */
    @Override
    public BasStudent selectBasStudentByStudentId(Long studentId)
    {
        return basStudentMapper.selectBasStudentByStudentId(studentId);
    }

    /**
     * 查询学生信息列表
     * 
     * @param basStudent 学生信息
     * @return 学生信息
     */
    @Override
    public List<BasStudent> selectBasStudentList(BasStudent basStudent)
    {
        return basStudentMapper.selectBasStudentList(basStudent);
    }

    /**
     * 新增学生信息
     * 
     * @param basStudent 学生信息
     * @return 结果
     */
    @Override
    public int insertBasStudent(BasStudent basStudent)
    {
        return basStudentMapper.insertBasStudent(basStudent);
    }

    /**
     * 修改学生信息
     * 
     * @param basStudent 学生信息
     * @return 结果
     */
    @Override
    public int updateBasStudent(BasStudent basStudent)
    {
        return basStudentMapper.updateBasStudent(basStudent);
    }

    /**
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteBasStudentByStudentIds(Long[] studentIds)
    {
        return basStudentMapper.deleteBasStudentByStudentIds(studentIds);
    }

    /**
     * 删除学生信息信息
     * 
     * @param studentId 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteBasStudentByStudentId(Long studentId)
    {
        return basStudentMapper.deleteBasStudentByStudentId(studentId);
    }
}
