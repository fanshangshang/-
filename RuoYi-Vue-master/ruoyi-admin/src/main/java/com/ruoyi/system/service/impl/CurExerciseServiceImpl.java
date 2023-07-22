package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CurExerciseMapper;
import com.ruoyi.system.domain.CurExercise;
import com.ruoyi.system.service.ICurExerciseService;

/**
 * 题目，用于生成试卷或者平时测试用Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class CurExerciseServiceImpl implements ICurExerciseService 
{
    @Autowired
    private CurExerciseMapper curExerciseMapper;

    /**
     * 查询题目，用于生成试卷或者平时测试用
     * 
     * @param exerciseId 题目，用于生成试卷或者平时测试用主键
     * @return 题目，用于生成试卷或者平时测试用
     */
    @Override
    public CurExercise selectCurExerciseByExerciseId(Long exerciseId)
    {
        return curExerciseMapper.selectCurExerciseByExerciseId(exerciseId);
    }

    /**
     * 查询题目，用于生成试卷或者平时测试用列表
     * 
     * @param curExercise 题目，用于生成试卷或者平时测试用
     * @return 题目，用于生成试卷或者平时测试用
     */
    @Override
    public List<CurExercise> selectCurExerciseList(CurExercise curExercise)
    {
        return curExerciseMapper.selectCurExerciseList(curExercise);
    }

    /**
     * 新增题目，用于生成试卷或者平时测试用
     * 
     * @param curExercise 题目，用于生成试卷或者平时测试用
     * @return 结果
     */
    @Override
    public int insertCurExercise(CurExercise curExercise)
    {
        return curExerciseMapper.insertCurExercise(curExercise);
    }

    /**
     * 修改题目，用于生成试卷或者平时测试用
     * 
     * @param curExercise 题目，用于生成试卷或者平时测试用
     * @return 结果
     */
    @Override
    public int updateCurExercise(CurExercise curExercise)
    {
        return curExerciseMapper.updateCurExercise(curExercise);
    }

    /**
     * 批量删除题目，用于生成试卷或者平时测试用
     * 
     * @param exerciseIds 需要删除的题目，用于生成试卷或者平时测试用主键
     * @return 结果
     */
    @Override
    public int deleteCurExerciseByExerciseIds(Long[] exerciseIds)
    {
        return curExerciseMapper.deleteCurExerciseByExerciseIds(exerciseIds);
    }

    /**
     * 删除题目，用于生成试卷或者平时测试用信息
     * 
     * @param exerciseId 题目，用于生成试卷或者平时测试用主键
     * @return 结果
     */
    @Override
    public int deleteCurExerciseByExerciseId(Long exerciseId)
    {
        return curExerciseMapper.deleteCurExerciseByExerciseId(exerciseId);
    }
}
