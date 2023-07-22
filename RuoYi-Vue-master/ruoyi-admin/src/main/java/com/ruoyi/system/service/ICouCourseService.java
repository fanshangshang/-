package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CouCourse;

/**
 * 课程，对应某学期某个教师所授课程Service接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface ICouCourseService 
{
    /**
     * 查询课程，对应某学期某个教师所授课程
     * 
     * @param courseId 课程，对应某学期某个教师所授课程主键
     * @return 课程，对应某学期某个教师所授课程
     */
    public CouCourse selectCouCourseByCourseId(Long courseId);

    /**
     * 查询课程，对应某学期某个教师所授课程列表
     * 
     * @param couCourse 课程，对应某学期某个教师所授课程
     * @return 课程，对应某学期某个教师所授课程集合
     */
    public List<CouCourse> selectCouCourseList(CouCourse couCourse);

    /**
     * 新增课程，对应某学期某个教师所授课程
     * 
     * @param couCourse 课程，对应某学期某个教师所授课程
     * @return 结果
     */
    public int insertCouCourse(CouCourse couCourse);

    /**
     * 修改课程，对应某学期某个教师所授课程
     * 
     * @param couCourse 课程，对应某学期某个教师所授课程
     * @return 结果
     */
    public int updateCouCourse(CouCourse couCourse);

    /**
     * 批量删除课程，对应某学期某个教师所授课程
     * 
     * @param courseIds 需要删除的课程，对应某学期某个教师所授课程主键集合
     * @return 结果
     */
    public int deleteCouCourseByCourseIds(Long[] courseIds);

    /**
     * 删除课程，对应某学期某个教师所授课程信息
     * 
     * @param courseId 课程，对应某学期某个教师所授课程主键
     * @return 结果
     */
    public int deleteCouCourseByCourseId(Long courseId);
}
