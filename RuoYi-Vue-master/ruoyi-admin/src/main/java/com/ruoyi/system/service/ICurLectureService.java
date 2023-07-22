package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CurLecture;

/**
 * 示某一讲Service接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface ICurLectureService 
{
    /**
     * 查询示某一讲
     * 
     * @param lectureId 示某一讲主键
     * @return 示某一讲
     */
    public CurLecture selectCurLectureByLectureId(Long lectureId);

    /**
     * 查询示某一讲列表
     * 
     * @param curLecture 示某一讲
     * @return 示某一讲集合
     */
    public List<CurLecture> selectCurLectureList(CurLecture curLecture);

    /**
     * 新增示某一讲
     * 
     * @param curLecture 示某一讲
     * @return 结果
     */
    public int insertCurLecture(CurLecture curLecture);

    /**
     * 修改示某一讲
     * 
     * @param curLecture 示某一讲
     * @return 结果
     */
    public int updateCurLecture(CurLecture curLecture);

    /**
     * 批量删除示某一讲
     * 
     * @param lectureIds 需要删除的示某一讲主键集合
     * @return 结果
     */
    public int deleteCurLectureByLectureIds(Long[] lectureIds);

    /**
     * 删除示某一讲信息
     * 
     * @param lectureId 示某一讲主键
     * @return 结果
     */
    public int deleteCurLectureByLectureId(Long lectureId);
}
