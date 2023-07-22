package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CurLectureMapper;
import com.ruoyi.system.domain.CurLecture;
import com.ruoyi.system.service.ICurLectureService;

/**
 * 示某一讲Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class CurLectureServiceImpl implements ICurLectureService 
{
    @Autowired
    private CurLectureMapper curLectureMapper;

    /**
     * 查询示某一讲
     * 
     * @param lectureId 示某一讲主键
     * @return 示某一讲
     */
    @Override
    public CurLecture selectCurLectureByLectureId(Long lectureId)
    {
        return curLectureMapper.selectCurLectureByLectureId(lectureId);
    }

    /**
     * 查询示某一讲列表
     * 
     * @param curLecture 示某一讲
     * @return 示某一讲
     */
    @Override
    public List<CurLecture> selectCurLectureList(CurLecture curLecture)
    {
        return curLectureMapper.selectCurLectureList(curLecture);
    }

    /**
     * 新增示某一讲
     * 
     * @param curLecture 示某一讲
     * @return 结果
     */
    @Override
    public int insertCurLecture(CurLecture curLecture)
    {
        return curLectureMapper.insertCurLecture(curLecture);
    }

    /**
     * 修改示某一讲
     * 
     * @param curLecture 示某一讲
     * @return 结果
     */
    @Override
    public int updateCurLecture(CurLecture curLecture)
    {
        return curLectureMapper.updateCurLecture(curLecture);
    }

    /**
     * 批量删除示某一讲
     * 
     * @param lectureIds 需要删除的示某一讲主键
     * @return 结果
     */
    @Override
    public int deleteCurLectureByLectureIds(Long[] lectureIds)
    {
        return curLectureMapper.deleteCurLectureByLectureIds(lectureIds);
    }

    /**
     * 删除示某一讲信息
     * 
     * @param lectureId 示某一讲主键
     * @return 结果
     */
    @Override
    public int deleteCurLectureByLectureId(Long lectureId)
    {
        return curLectureMapper.deleteCurLectureByLectureId(lectureId);
    }
}
