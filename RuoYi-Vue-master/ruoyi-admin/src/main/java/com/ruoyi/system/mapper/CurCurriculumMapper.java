package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CurCurriculum;
import org.apache.ibatis.annotations.Mapper;

/**
 * 大纲课程信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Mapper
public interface CurCurriculumMapper 
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
     * 删除大纲课程信息
     * 
     * @param curriculumId 大纲课程信息主键
     * @return 结果
     */
    public int deleteCurCurriculumByCurriculumId(Long curriculumId);

    /**
     * 批量删除大纲课程信息
     * 
     * @param curriculumIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCurCurriculumByCurriculumIds(Long[] curriculumIds);
}
