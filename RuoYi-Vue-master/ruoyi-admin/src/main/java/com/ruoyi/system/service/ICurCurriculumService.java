package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CurCurriculum;

/**
 * 大纲课程信息Service接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface ICurCurriculumService 
{
    /**
     * 查询大纲课程信息
     * 
     * @param curriculumId 大纲课程信息主键
     * @return 大纲课程信息
     */
    public CurCurriculum selectCurCurriculumByCurriculumId(Long curriculumId);

    /**
     * 查询大纲课程信息列表
     * 
     * @param curCurriculum 大纲课程信息
     * @return 大纲课程信息集合
     */
    public List<CurCurriculum> selectCurCurriculumList(CurCurriculum curCurriculum);

    /**
     * 新增大纲课程信息
     * 
     * @param curCurriculum 大纲课程信息
     * @return 结果
     */
    public int insertCurCurriculum(CurCurriculum curCurriculum);

    /**
     * 修改大纲课程信息
     * 
     * @param curCurriculum 大纲课程信息
     * @return 结果
     */
    public int updateCurCurriculum(CurCurriculum curCurriculum);

    /**
     * 批量删除大纲课程信息
     * 
     * @param curriculumIds 需要删除的大纲课程信息主键集合
     * @return 结果
     */
    public int deleteCurCurriculumByCurriculumIds(Long[] curriculumIds);

    /**
     * 删除大纲课程信息信息
     * 
     * @param curriculumId 大纲课程信息主键
     * @return 结果
     */
    public int deleteCurCurriculumByCurriculumId(Long curriculumId);
}
