package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BasTeacher;

/**
 * 教师信息Service接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public interface IBasTeacherService 
{
    /**
     * 查询教师信息
     * 
     * @param teacherId 教师信息主键
     * @return 教师信息
     */
    public BasTeacher selectBasTeacherByTeacherId(Long teacherId);

    /**
     * 查询教师信息列表
     * 
     * @param basTeacher 教师信息
     * @return 教师信息集合
     */
    public List<BasTeacher> selectBasTeacherList(BasTeacher basTeacher);

    /**
     * 新增教师信息
     * 
     * @param basTeacher 教师信息
     * @return 结果
     */
    public int insertBasTeacher(BasTeacher basTeacher);

    /**
     * 修改教师信息
     * 
     * @param basTeacher 教师信息
     * @return 结果
     */
    public int updateBasTeacher(BasTeacher basTeacher);

    /**
     * 批量删除教师信息
     * 
     * @param teacherIds 需要删除的教师信息主键集合
     * @return 结果
     */
    public int deleteBasTeacherByTeacherIds(Long[] teacherIds);

    /**
     * 删除教师信息信息
     * 
     * @param teacherId 教师信息主键
     * @return 结果
     */
    public int deleteBasTeacherByTeacherId(Long teacherId);
}
