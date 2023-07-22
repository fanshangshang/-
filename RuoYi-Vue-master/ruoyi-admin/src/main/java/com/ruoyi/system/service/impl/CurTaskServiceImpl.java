package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CurTaskMapper;
import com.ruoyi.system.domain.CurTask;
import com.ruoyi.system.service.ICurTaskService;

/**
 * 学习任务，比如一次作业，一次随堂测试等。Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class CurTaskServiceImpl implements ICurTaskService 
{
    @Autowired
    private CurTaskMapper curTaskMapper;

    /**
     * 查询学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param taskId 学习任务，比如一次作业，一次随堂测试等。主键
     * @return 学习任务，比如一次作业，一次随堂测试等。
     */
    @Override
    public CurTask selectCurTaskByTaskId(Long taskId)
    {
        return curTaskMapper.selectCurTaskByTaskId(taskId);
    }

    /**
     * 查询学习任务，比如一次作业，一次随堂测试等。列表
     * 
     * @param curTask 学习任务，比如一次作业，一次随堂测试等。
     * @return 学习任务，比如一次作业，一次随堂测试等。
     */
    @Override
    public List<CurTask> selectCurTaskList(CurTask curTask)
    {
        return curTaskMapper.selectCurTaskList(curTask);
    }

    /**
     * 新增学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param curTask 学习任务，比如一次作业，一次随堂测试等。
     * @return 结果
     */
    @Override
    public int insertCurTask(CurTask curTask)
    {
        return curTaskMapper.insertCurTask(curTask);
    }

    /**
     * 修改学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param curTask 学习任务，比如一次作业，一次随堂测试等。
     * @return 结果
     */
    @Override
    public int updateCurTask(CurTask curTask)
    {
        return curTaskMapper.updateCurTask(curTask);
    }

    /**
     * 批量删除学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param taskIds 需要删除的学习任务，比如一次作业，一次随堂测试等。主键
     * @return 结果
     */
    @Override
    public int deleteCurTaskByTaskIds(Long[] taskIds)
    {
        return curTaskMapper.deleteCurTaskByTaskIds(taskIds);
    }

    /**
     * 删除学习任务，比如一次作业，一次随堂测试等。信息
     * 
     * @param taskId 学习任务，比如一次作业，一次随堂测试等。主键
     * @return 结果
     */
    @Override
    public int deleteCurTaskByTaskId(Long taskId)
    {
        return curTaskMapper.deleteCurTaskByTaskId(taskId);
    }
}
