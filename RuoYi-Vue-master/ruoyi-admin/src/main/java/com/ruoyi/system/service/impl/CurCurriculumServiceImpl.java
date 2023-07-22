package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CurCurriculumMapper;
import com.ruoyi.system.domain.CurCurriculum;
import com.ruoyi.system.service.ICurCurriculumService;

/**
 * 大纲课程信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class CurCurriculumServiceImpl implements ICurCurriculumService 
{
    @Autowired
    private CurCurriculumMapper curCurriculumMapper;

    /**
     * 查询大纲课程信息
     * 
     * @param curriculumId 大纲课程信息主键
     * @return 大纲课程信息
     */
    @Override
    public CurCurriculum selectCurCurriculumByCurriculumId(Long curriculumId)
    {
        return curCurriculumMapper.selectCurCurriculumByCurriculumId(curriculumId);
    }

    /**
     * 查询大纲课程信息列表
     * 
     * @param curCurriculum 大纲课程信息
     * @return 大纲课程信息
     */
    @Override
    public List<CurCurriculum> selectCurCurriculumList(CurCurriculum curCurriculum)
    {
        return curCurriculumMapper.selectCurCurriculumList(curCurriculum);
    }

    /**
     * 新增大纲课程信息
     * 
     * @param curCurriculum 大纲课程信息
     * @return 结果
     */
    @Override
    public int insertCurCurriculum(CurCurriculum curCurriculum)
    {
        curCurriculum.setCreateTime(DateUtils.getNowDate());
        return curCurriculumMapper.insertCurCurriculum(curCurriculum);
    }

    /**
     * 修改大纲课程信息
     * 
     * @param curCurriculum 大纲课程信息
     * @return 结果
     */
    @Override
    public int updateCurCurriculum(CurCurriculum curCurriculum)
    {
        curCurriculum.setUpdateTime(DateUtils.getNowDate());
        return curCurriculumMapper.updateCurCurriculum(curCurriculum);
    }

    /**
     * 批量删除大纲课程信息
     * 
     * @param curriculumIds 需要删除的大纲课程信息主键
     * @return 结果
     */
    @Override
    public int deleteCurCurriculumByCurriculumIds(Long[] curriculumIds)
    {
        return curCurriculumMapper.deleteCurCurriculumByCurriculumIds(curriculumIds);
    }

    /**
     * 删除大纲课程信息信息
     * 
     * @param curriculumId 大纲课程信息主键
     * @return 结果
     */
    @Override
    public int deleteCurCurriculumByCurriculumId(Long curriculumId)
    {
        return curCurriculumMapper.deleteCurCurriculumByCurriculumId(curriculumId);
    }
}
