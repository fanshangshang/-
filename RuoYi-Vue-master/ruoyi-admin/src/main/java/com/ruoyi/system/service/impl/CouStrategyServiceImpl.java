package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CouStrategyMapper;
import com.ruoyi.system.domain.CouStrategy;
import com.ruoyi.system.service.ICouStrategyService;

/**
 * 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class CouStrategyServiceImpl implements ICouStrategyService 
{
    @Autowired
    private CouStrategyMapper couStrategyMapper;

    /**
     * 查询成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param strategyId 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。主键
     * @return 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     */
    @Override
    public CouStrategy selectCouStrategyByStrategyId(Long strategyId)
    {
        return couStrategyMapper.selectCouStrategyByStrategyId(strategyId);
    }

    /**
     * 查询成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。列表
     * 
     * @param couStrategy 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * @return 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     */
    @Override
    public List<CouStrategy> selectCouStrategyList(CouStrategy couStrategy)
    {
        return couStrategyMapper.selectCouStrategyList(couStrategy);
    }

    /**
     * 新增成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param couStrategy 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * @return 结果
     */
    @Override
    public int insertCouStrategy(CouStrategy couStrategy)
    {
        return couStrategyMapper.insertCouStrategy(couStrategy);
    }

    /**
     * 修改成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param couStrategy 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * @return 结果
     */
    @Override
    public int updateCouStrategy(CouStrategy couStrategy)
    {
        return couStrategyMapper.updateCouStrategy(couStrategy);
    }

    /**
     * 批量删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
     * 
     * @param strategyIds 需要删除的成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。主键
     * @return 结果
     */
    @Override
    public int deleteCouStrategyByStrategyIds(Long[] strategyIds)
    {
        return couStrategyMapper.deleteCouStrategyByStrategyIds(strategyIds);
    }

    /**
     * 删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。信息
     * 
     * @param strategyId 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。主键
     * @return 结果
     */
    @Override
    public int deleteCouStrategyByStrategyId(Long strategyId)
    {
        return couStrategyMapper.deleteCouStrategyByStrategyId(strategyId);
    }
}
