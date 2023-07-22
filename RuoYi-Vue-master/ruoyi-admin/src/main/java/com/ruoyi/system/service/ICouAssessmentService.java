package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CouAssessment;

/**
 * 一次评价Service接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public interface ICouAssessmentService 
{
    /**
     * 查询一次评价
     * 
     * @param assessmentId 一次评价主键
     * @return 一次评价
     */
    public CouAssessment selectCouAssessmentByAssessmentId(Long assessmentId);

    /**
     * 查询一次评价列表
     * 
     * @param couAssessment 一次评价
     * @return 一次评价集合
     */
    public List<CouAssessment> selectCouAssessmentList(CouAssessment couAssessment);

    /**
     * 新增一次评价
     * 
     * @param couAssessment 一次评价
     * @return 结果
     */
    public int insertCouAssessment(CouAssessment couAssessment);

    /**
     * 修改一次评价
     * 
     * @param couAssessment 一次评价
     * @return 结果
     */
    public int updateCouAssessment(CouAssessment couAssessment);

    /**
     * 批量删除一次评价
     * 
     * @param assessmentIds 需要删除的一次评价主键集合
     * @return 结果
     */
    public int deleteCouAssessmentByAssessmentIds(Long[] assessmentIds);

    /**
     * 删除一次评价信息
     * 
     * @param assessmentId 一次评价主键
     * @return 结果
     */
    public int deleteCouAssessmentByAssessmentId(Long assessmentId);
}
