package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CouCourseMapper;
import com.ruoyi.system.domain.CouCourse;
import com.ruoyi.system.service.ICouCourseService;

/**
 * 课程，对应某学期某个教师所授课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class CouCourseServiceImpl implements ICouCourseService 
{
    @Autowired
    private CouCourseMapper couCourseMapper;

    /**
     * 查询课程，对应某学期某个教师所授课程
     * 
     * @param courseId 课程，对应某学期某个教师所授课程主键
     * @return 课程，对应某学期某个教师所授课程
     */
    @Override
    public CouCourse selectCouCourseByCourseId(Long courseId)
    {
        return couCourseMapper.selectCouCourseByCourseId(courseId);
    }

    /**
     * 查询课程，对应某学期某个教师所授课程列表
     * 
     * @param couCourse 课程，对应某学期某个教师所授课程
     * @return 课程，对应某学期某个教师所授课程
     */
    @Override
    public List<CouCourse> selectCouCourseList(CouCourse couCourse)
    {
        return couCourseMapper.selectCouCourseList(couCourse);
    }

    /**
     * 新增课程，对应某学期某个教师所授课程
     * 
     * @param couCourse 课程，对应某学期某个教师所授课程
     * @return 结果
     */
    @Override
    public int insertCouCourse(CouCourse couCourse)
    {
        return couCourseMapper.insertCouCourse(couCourse);
    }

    /**
     * 修改课程，对应某学期某个教师所授课程
     * 
     * @param couCourse 课程，对应某学期某个教师所授课程
     * @return 结果
     */
    @Override
    public int updateCouCourse(CouCourse couCourse)
    {
        return couCourseMapper.updateCouCourse(couCourse);
    }

    /**
     * 批量删除课程，对应某学期某个教师所授课程
     * 
     * @param courseIds 需要删除的课程，对应某学期某个教师所授课程主键
     * @return 结果
     */
    @Override
    public int deleteCouCourseByCourseIds(Long[] courseIds)
    {
        return couCourseMapper.deleteCouCourseByCourseIds(courseIds);
    }

    /**
     * 删除课程，对应某学期某个教师所授课程信息
     * 
     * @param courseId 课程，对应某学期某个教师所授课程主键
     * @return 结果
     */
    @Override
    public int deleteCouCourseByCourseId(Long courseId)
    {
        return couCourseMapper.deleteCouCourseByCourseId(courseId);
    }
}
