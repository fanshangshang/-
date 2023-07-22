package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CouStrategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Mapper
public interface CouStrategyMapper 
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
     * 删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param strategyId 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。主键
     * @return 结果
     */
    public int deleteCouStrategyByStrategyId(Long strategyId);

    /**
     * 批量删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param strategyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCouStrategyByStrategyIds(Long[] strategyIds);
}
