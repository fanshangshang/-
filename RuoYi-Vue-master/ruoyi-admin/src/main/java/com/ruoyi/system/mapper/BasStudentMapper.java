package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BasStudent;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Mapper
public interface BasStudentMapper 
{
    /**
     * 查询学生信息
     * 
     * @param studentId 学生信息主键
     * @return 学生信息
     */
    public BasStudent selectBasStudentByStudentId(Long studentId);

    /**
     * 查询学生信息列表
     * 
     * @param basStudent 学生信息
     * @return 学生信息集合
     */
    public List<BasStudent> selectBasStudentList(BasStudent basStudent);

    /**
     * 新增学生信息
     * 
     * @param basStudent 学生信息
     * @return 结果
     */
    public int insertBasStudent(BasStudent basStudent);

    /**
     * 修改学生信息
     * 
     * @param basStudent 学生信息
     * @return 结果
     */
    public int updateBasStudent(BasStudent basStudent);

    /**
     * 删除学生信息
     * 
     * @param studentId 学生信息主键
     * @return 结果
     */
    public int deleteBasStudentByStudentId(Long studentId);

    /**
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBasStudentByStudentIds(Long[] studentIds);
}
