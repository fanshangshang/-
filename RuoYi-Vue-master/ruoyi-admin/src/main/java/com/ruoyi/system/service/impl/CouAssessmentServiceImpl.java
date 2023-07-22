package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CouAssessmentMapper;
import com.ruoyi.system.domain.CouAssessment;
import com.ruoyi.system.service.ICouAssessmentService;

/**
 * 一次评价Service业务层处理
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Service
public class CouAssessmentServiceImpl implements ICouAssessmentService 
{
    @Autowired
    private CouAssessmentMapper couAssessmentMapper;

    /**
     * 查询一次评价
     * 
     * @param assessmentId 一次评价主键
     * @return 一次评价
     */
    @Override
    public CouAssessment selectCouAssessmentByAssessmentId(Long assessmentId)
    {
        return couAssessmentMapper.selectCouAssessmentByAssessmentId(assessmentId);
    }

    /**
     * 查询一次评价列表
     * 
     * @param couAssessment 一次评价
     * @return 一次评价
     */
    @Override
    public List<CouAssessment> selectCouAssessmentList(CouAssessment couAssessment)
    {
        return couAssessmentMapper.selectCouAssessmentList(couAssessment);
    }

    /**
     * 新增一次评价
     * 
     * @param couAssessment 一次评价
     * @return 结果
     */
    @Override
    public int insertCouAssessment(CouAssessment couAssessment)
    {
        return couAssessmentMapper.insertCouAssessment(couAssessment);
    }

    /**
     * 修改一次评价
     * 
     * @param couAssessment 一次评价
     * @return 结果
     */
    @Override
    public int updateCouAssessment(CouAssessment couAssessment)
    {
        return couAssessmentMapper.updateCouAssessment(couAssessment);
    }

    /**
     * 批量删除一次评价
     * 
     * @param assessmentIds 需要删除的一次评价主键
     * @return 结果
     */
    @Override
    public int deleteCouAssessmentByAssessmentIds(Long[] assessmentIds)
    {
        return couAssessmentMapper.deleteCouAssessmentByAssessmentIds(assessmentIds);
    }

    /**
     * 删除一次评价信息
     * 
     * @param assessmentId 一次评价主键
     * @return 结果
     */
    @Override
    public int deleteCouAssessmentByAssessmentId(Long assessmentId)
    {
        return couAssessmentMapper.deleteCouAssessmentByAssessmentId(assessmentId);
    }
}
