package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CouLesson;
import org.apache.ibatis.annotations.Mapper;

/**
 * 某个周某个时段的某次课Mapper接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Mapper
public interface CouLessonMapper 
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
     * 删除某个周某个时段的某次课
     * 
     * @param lessonId 某个周某个时段的某次课主键
     * @return 结果
     */
    public int deleteCouLessonByLessonId(Long lessonId);

    /**
     * 批量删除某个周某个时段的某次课
     * 
     * @param lessonIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCouLessonByLessonIds(Long[] lessonIds);
}
