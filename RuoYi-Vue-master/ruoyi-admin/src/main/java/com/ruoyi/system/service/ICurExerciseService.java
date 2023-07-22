package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CurExercise;

/**
 * 题目，用于生成试卷或者平时测试用Service接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface ICurExerciseService 
{
    /**
     * 查询题目，用于生成试卷或者平时测试用
     * 
     * @param exerciseId 题目，用于生成试卷或者平时测试用主键
     * @return 题目，用于生成试卷或者平时测试用
     */
    public CurExercise selectCurExerciseByExerciseId(Long exerciseId);

    /**
     * 查询题目，用于生成试卷或者平时测试用列表
     * 
     * @param curExercise 题目，用于生成试卷或者平时测试用
     * @return 题目，用于生成试卷或者平时测试用集合
     */
    public List<CurExercise> selectCurExerciseList(CurExercise curExercise);

    /**
     * 新增题目，用于生成试卷或者平时测试用
     * 
     * @param curExercise 题目，用于生成试卷或者平时测试用
     * @return 结果
     */
    public int insertCurExercise(CurExercise curExercise);

    /**
     * 修改题目，用于生成试卷或者平时测试用
     * 
     * @param curExercise 题目，用于生成试卷或者平时测试用
     * @return 结果
     */
    public int updateCurExercise(CurExercise curExercise);

    /**
     * 批量删除题目，用于生成试卷或者平时测试用
     * 
     * @param exerciseIds 需要删除的题目，用于生成试卷或者平时测试用主键集合
     * @return 结果
     */
    public int deleteCurExerciseByExerciseIds(Long[] exerciseIds);

    /**
     * 删除题目，用于生成试卷或者平时测试用信息
     * 
     * @param exerciseId 题目，用于生成试卷或者平时测试用主键
     * @return 结果
     */
    public int deleteCurExerciseByExerciseId(Long exerciseId);
}
