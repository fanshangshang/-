package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CouLesson;

/**
 * 某个周某个时段的某次课Service接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public interface ICouLessonService 
{
    /**
     * 查询某个周某个时段的某次课
     * 
     * @param lessonId 某个周某个时段的某次课主键
     * @return 某个周某个时段的某次课
     */
    public CouLesson selectCouLessonByLessonId(Long lessonId);

    /**
     * 查询某个周某个时段的某次课列表
     * 
     * @param couLesson 某个周某个时段的某次课
     * @return 某个周某个时段的某次课集合
     */
    public List<CouLesson> selectCouLessonList(CouLesson couLesson);

    /**
     * 新增某个周某个时段的某次课
     * 
     * @param couLesson 某个周某个时段的某次课
     * @return 结果
     */
    public int insertCouLesson(CouLesson couLesson);

    /**
     * 修改某个周某个时段的某次课
     * 
     * @param couLesson 某个周某个时段的某次课
     * @return 结果
     */
    public int updateCouLesson(CouLesson couLesson);

    /**
     * 批量删除某个周某个时段的某次课
     * 
     * @param lessonIds 需要删除的某个周某个时段的某次课主键集合
     * @return 结果
     */
    public int deleteCouLessonByLessonIds(Long[] lessonIds);

    /**
     * 删除某个周某个时段的某次课信息
     * 
     * @param lessonId 某个周某个时段的某次课主键
     * @return 结果
     */
    public int deleteCouLessonByLessonId(Long lessonId);
}
