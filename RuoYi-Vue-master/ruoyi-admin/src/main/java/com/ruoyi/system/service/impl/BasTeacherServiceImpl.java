package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BasTeacherMapper;
import com.ruoyi.system.domain.BasTeacher;
import com.ruoyi.system.service.IBasTeacherService;

/**
 * 教师信息Service业务层处理
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Service
public class BasTeacherServiceImpl implements IBasTeacherService 
{
    @Autowired
    private BasTeacherMapper basTeacherMapper;

    /**
     * 查询教师信息
     * 
     * @param teacherId 教师信息主键
     * @return 教师信息
     */
    @Override
    public BasTeacher selectBasTeacherByTeacherId(Long teacherId)
    {
        return basTeacherMapper.selectBasTeacherByTeacherId(teacherId);
    }

    /**
     * 查询教师信息列表
     * 
     * @param basTeacher 教师信息
     * @return 教师信息
     */
    @Override
    public List<BasTeacher> selectBasTeacherList(BasTeacher basTeacher)
    {
        return basTeacherMapper.selectBasTeacherList(basTeacher);
    }

    /**
     * 新增教师信息
     * 
     * @param basTeacher 教师信息
     * @return 结果
     */
    @Override
    public int insertBasTeacher(BasTeacher basTeacher)
    {
        return basTeacherMapper.insertBasTeacher(basTeacher);
    }

    /**
     * 修改教师信息
     * 
     * @param basTeacher 教师信息
     * @return 结果
     */
    @Override
    public int updateBasTeacher(BasTeacher basTeacher)
    {
        return basTeacherMapper.updateBasTeacher(basTeacher);
    }

    /**
     * 批量删除教师信息
     * 
     * @param teacherIds 需要删除的教师信息主键
     * @return 结果
     */
    @Override
    public int deleteBasTeacherByTeacherIds(Long[] teacherIds)
    {
        return basTeacherMapper.deleteBasTeacherByTeacherIds(teacherIds);
    }

    /**
     * 删除教师信息信息
     * 
     * @param teacherId 教师信息主键
     * @return 结果
     */
    @Override
    public int deleteBasTeacherByTeacherId(Long teacherId)
    {
        return basTeacherMapper.deleteBasTeacherByTeacherId(teacherId);
    }
}
