package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CouStrategy;

/**
 * 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。Service接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface ICouStrategyService 
{
    /**
     * 查询成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param strategyId 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。主键
     * @return 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     */
    public CouStrategy selectCouStrategyByStrategyId(Long strategyId);

    /**
     * 查询成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。列表
     * 
     * @param couStrategy 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * @return 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。集合
     */
    public List<CouStrategy> selectCouStrategyList(CouStrategy couStrategy);

    /**
     * 新增成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param couStrategy 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * @return 结果
     */
    public int insertCouStrategy(CouStrategy couStrategy);

    /**
     * 修改成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param couStrategy 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * @return 结果
     */
    public int updateCouStrategy(CouStrategy couStrategy);

    /**
     * 批量删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param strategyIds 需要删除的成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。主键集合
     * @return 结果
     */
    public int deleteCouStrategyByStrategyIds(Long[] strategyIds);

    /**
     * 删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。信息
     * 
     * @param strategyId 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。主键
     * @return 结果
     */
    public int deleteCouStrategyByStrategyId(Long strategyId);
}
