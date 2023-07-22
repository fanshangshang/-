package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CouEnroll;
import org.apache.ibatis.annotations.Mapper;

/**
 * 选课信息，包含某学生选择某课程之后的各种成绩组成Mapper接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Mapper
public interface CouEnrollMapper 
{
    /**
     * 查询选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param enrollId 选课信息，包含某学生选择某课程之后的各种成绩组成主键
     * @return 选课信息，包含某学生选择某课程之后的各种成绩组成
     */
    public CouEnroll selectCouEnrollByEnrollId(Long enrollId);

    /**
     * 查询选课信息，包含某学生选择某课程之后的各种成绩组成列表
     * 
     * @param couEnroll 选课信息，包含某学生选择某课程之后的各种成绩组成
     * @return 选课信息，包含某学生选择某课程之后的各种成绩组成集合
     */
    public List<CouEnroll> selectCouEnrollList(CouEnroll couEnroll);

    /**
     * 新增选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param couEnroll 选课信息，包含某学生选择某课程之后的各种成绩组成
     * @return 结果
     */
    public int insertCouEnroll(CouEnroll couEnroll);

    /**
     * 修改选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param couEnroll 选课信息，包含某学生选择某课程之后的各种成绩组成
     * @return 结果
     */
    public int updateCouEnroll(CouEnroll couEnroll);

    /**
     * 删除选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param enrollId 选课信息，包含某学生选择某课程之后的各种成绩组成主键
     * @return 结果
     */
    public int deleteCouEnrollByEnrollId(Long enrollId);

    /**
     * 批量删除选课信息，包含某学生选择某课程之后的各种成绩组成
     * 
     * @param enrollIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCouEnrollByEnrollIds(Long[] enrollIds);
}
