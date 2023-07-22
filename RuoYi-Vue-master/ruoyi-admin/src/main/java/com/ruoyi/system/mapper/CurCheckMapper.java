package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CurCheck;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目任务关系Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Mapper
public interface CurCheckMapper 
{
    /**
     * 查询题目任务关系
     * 
     * @param checkId 题目任务关系主键
     * @return 题目任务关系
     */
    public CurCheck selectCurCheckByCheckId(Long checkId);

    /**
     * 查询题目任务关系列表
     * 
     * @param curCheck 题目任务关系
     * @return 题目任务关系集合
     */
    public List<CurCheck> selectCurCheckList(CurCheck curCheck);

    /**
     * 新增题目任务关系
     * 
     * @param curCheck 题目任务关系
     * @return 结果
     */
    public int insertCurCheck(CurCheck curCheck);

    /**
     * 修改题目任务关系
     * 
     * @param curCheck 题目任务关系
     * @return 结果
     */
    public int updateCurCheck(CurCheck curCheck);

    /**
     * 删除题目任务关系
     * 
     * @param checkId 题目任务关系主键
     * @return 结果
     */
    public int deleteCurCheckByCheckId(Long checkId);

    /**
     * 批量删除题目任务关系
     * 
     * @param checkIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCurCheckByCheckIds(Long[] checkIds);
}
