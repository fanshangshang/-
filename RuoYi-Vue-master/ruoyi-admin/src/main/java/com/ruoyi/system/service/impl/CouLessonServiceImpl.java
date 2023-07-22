package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CouLessonMapper;
import com.ruoyi.system.domain.CouLesson;
import com.ruoyi.system.service.ICouLessonService;

/**
 * 某个周某个时段的某次课Service业务层处理
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Service
public class CouLessonServiceImpl implements ICouLessonService 
{
    @Autowired
    private CouLessonMapper couLessonMapper;

    /**
     * 查询某个周某个时段的某次课
     * 
     * @param lessonId 某个周某个时段的某次课主键
     * @return 某个周某个时段的某次课
     */
    @Override
    public CouLesson selectCouLessonByLessonId(Long lessonId)
    {
        return couLessonMapper.selectCouLessonByLessonId(lessonId);
    }

    /**
     * 查询某个周某个时段的某次课列表
     * 
     * @param couLesson 某个周某个时段的某次课
     * @return 某个周某个时段的某次课
     */
    @Override
    public List<CouLesson> selectCouLessonList(CouLesson couLesson)
    {
        return couLessonMapper.selectCouLessonList(couLesson);
    }

    /**
     * 新增某个周某个时段的某次课
     * 
     * @param couLesson 某个周某个时段的某次课
     * @return 结果
     */
    @Override
    public int insertCouLesson(CouLesson couLesson)
    {
        return couLessonMapper.insertCouLesson(couLesson);
    }

    /**
     * 修改某个周某个时段的某次课
     * 
     * @param couLesson 某个周某个时段的某次课
     * @return 结果
     */
    @Override
    public int updateCouLesson(CouLesson couLesson)
    {
        return couLessonMapper.updateCouLesson(couLesson);
    }

    /**
     * 批量删除某个周某个时段的某次课
     * 
     * @param lessonIds 需要删除的某个周某个时段的某次课主键
     * @return 结果
     */
    @Override
    public int deleteCouLessonByLessonIds(Long[] lessonIds)
    {
        return couLessonMapper.deleteCouLessonByLessonIds(lessonIds);
    }

    /**
     * 删除某个周某个时段的某次课信息
     * 
     * @param lessonId 某个周某个时段的某次课主键
     * @return 结果
     */
    @Override
    public int deleteCouLessonByLessonId(Long lessonId)
    {
        return couLessonMapper.deleteCouLessonByLessonId(lessonId);
    }
}
