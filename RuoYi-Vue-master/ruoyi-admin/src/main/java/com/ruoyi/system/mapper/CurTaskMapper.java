package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CurTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学习任务，比如一次作业，一次随堂测试等。Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Mapper
public interface CurTaskMapper 
{
    /**
     * 查询学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param taskId 学习任务，比如一次作业，一次随堂测试等。主键
     * @return 学习任务，比如一次作业，一次随堂测试等。
     */
    public CurTask selectCurTaskByTaskId(Long taskId);

    /**
     * 查询学习任务，比如一次作业，一次随堂测试等。列表
     * 
     * @param curTask 学习任务，比如一次作业，一次随堂测试等。
     * @return 学习任务，比如一次作业，一次随堂测试等。集合
     */
    public List<CurTask> selectCurTaskList(CurTask curTask);

    /**
     * 新增学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param curTask 学习任务，比如一次作业，一次随堂测试等。
     * @return 结果
     */
    public int insertCurTask(CurTask curTask);

    /**
     * 修改学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param curTask 学习任务，比如一次作业，一次随堂测试等。
     * @return 结果
     */
    public int updateCurTask(CurTask curTask);

    /**
     * 删除学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param taskId 学习任务，比如一次作业，一次随堂测试等。主键
     * @return 结果
     */
    public int deleteCurTaskByTaskId(Long taskId);

    /**
     * 批量删除学习任务，比如一次作业，一次随堂测试等。
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCurTaskByTaskIds(Long[] taskIds);
}
