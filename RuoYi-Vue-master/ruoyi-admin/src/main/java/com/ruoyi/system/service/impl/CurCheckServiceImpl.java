package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CurCheckMapper;
import com.ruoyi.system.domain.CurCheck;
import com.ruoyi.system.service.ICurCheckService;

/**
 * 题目任务关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class CurCheckServiceImpl implements ICurCheckService 
{
    @Autowired
    private CurCheckMapper curCheckMapper;

    /**
     * 查询题目任务关系
     * 
     * @param checkId 题目任务关系主键
     * @return 题目任务关系
     */
    @Override
    public CurCheck selectCurCheckByCheckId(Long checkId)
    {
        return curCheckMapper.selectCurCheckByCheckId(checkId);
    }

    /**
     * 查询题目任务关系列表
     * 
     * @param curCheck 题目任务关系
     * @return 题目任务关系
     */
    @Override
    public List<CurCheck> selectCurCheckList(CurCheck curCheck)
    {
        return curCheckMapper.selectCurCheckList(curCheck);
    }

    /**
     * 新增题目任务关系
     * 
     * @param curCheck 题目任务关系
     * @return 结果
     */
    @Override
    public int insertCurCheck(CurCheck curCheck)
    {
        return curCheckMapper.insertCurCheck(curCheck);
    }

    /**
     * 修改题目任务关系
     * 
     * @param curCheck 题目任务关系
     * @return 结果
     */
    @Override
    public int updateCurCheck(CurCheck curCheck)
    {
        return curCheckMapper.updateCurCheck(curCheck);
    }

    /**
     * 批量删除题目任务关系
     * 
     * @param checkIds 需要删除的题目任务关系主键
     * @return 结果
     */
    @Override
    public int deleteCurCheckByCheckIds(Long[] checkIds)
    {
        return curCheckMapper.deleteCurCheckByCheckIds(checkIds);
    }

    /**
     * 删除题目任务关系信息
     * 
     * @param checkId 题目任务关系主键
     * @return 结果
     */
    @Override
    public int deleteCurCheckByCheckId(Long checkId)
    {
        return curCheckMapper.deleteCurCheckByCheckId(checkId);
    }
}
