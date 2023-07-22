package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CouEnrollMapper;
import com.ruoyi.system.domain.CouEnroll;
import com.ruoyi.system.service.ICouEnrollService;

/**
 * 选课信息，包含某学生选择某课程之后的各种成绩组成Service业务层处理
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Service
public class CouEnrollServiceImpl implements ICouEnrollService 
{
    @Autowired
    private CouEnrollMapper couEnrollMapper;

    /**
     * 查询选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param enrollId 选课信息，包含某学生选择某课程之后的各种成绩组成主键
     * @return 选课信息，包含某学生选择某课程之后的各种成绩组成
     */
    @Override
    public CouEnroll selectCouEnrollByEnrollId(Long enrollId)
    {
        return couEnrollMapper.selectCouEnrollByEnrollId(enrollId);
    }

    /**
     * 查询选课信息，包含某学生选择某课程之后的各种成绩组成列表
     * 
     * @param couEnroll 选课信息，包含某学生选择某课程之后的各种成绩组成
     * @return 选课信息，包含某学生选择某课程之后的各种成绩组成
     */
    @Override
    public List<CouEnroll> selectCouEnrollList(CouEnroll couEnroll)
    {
        return couEnrollMapper.selectCouEnrollList(couEnroll);
    }

    /**
     * 新增选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param couEnroll 选课信息，包含某学生选择某课程之后的各种成绩组成
     * @return 结果
     */
    @Override
    public int insertCouEnroll(CouEnroll couEnroll)
    {
        return couEnrollMapper.insertCouEnroll(couEnroll);
    }

    /**
     * 修改选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param couEnroll 选课信息，包含某学生选择某课程之后的各种成绩组成
     * @return 结果
     */
    @Override
    public int updateCouEnroll(CouEnroll couEnroll)
    {
        return couEnrollMapper.updateCouEnroll(couEnroll);
    }

    /**
     * 批量删除选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param enrollIds 需要删除的选课信息，包含某学生选择某课程之后的各种成绩组成主键
     * @return 结果
     */
    @Override
    public int deleteCouEnrollByEnrollIds(Long[] enrollIds)
    {
        return couEnrollMapper.deleteCouEnrollByEnrollIds(enrollIds);
    }

    /**
     * 删除选课信息，包含某学生选择某课程之后的各种成绩组成信息
     * 
     * @param enrollId 选课信息，包含某学生选择某课程之后的各种成绩组成主键
     * @return 结果
     */
    @Override
    public int deleteCouEnrollByEnrollId(Long enrollId)
    {
        return couEnrollMapper.deleteCouEnrollByEnrollId(enrollId);
    }
}
