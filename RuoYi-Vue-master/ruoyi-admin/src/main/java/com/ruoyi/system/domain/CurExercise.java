package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 题目，用于生成试卷或者平时测试用对象 cur_exercise
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class CurExercise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long exerciseId;

    /** 某讲编号 */
    @Excel(name = "某讲编号")
    private Long lectureId;

    /** 题型（0选择；1填空；2名词解释；3简答；4综合；5分析；6编程；7判断；8建模；9设计） */
    @Excel(name = "题型", readConverterExp = "0=选择；1填空；2名词解释；3简答；4综合；5分析；6编程；7判断；8建模；9设计")
    private String type;

    /** 难度（0简单；1较易；2一般；3：难；4：极难） */
    @Excel(name = "难度", readConverterExp = "0=简单；1较易；2一般；3：难；4：极难")
    private String difficulty;

    /** 分值 */
    @Excel(name = "分值")
    private Long score;

    /** 题干 */
    @Excel(name = "题干")
    private String content;

    /** 答案 */
    @Excel(name = "答案")
    private String answer;

    /** 使用次数 */
    @Excel(name = "使用次数")
    private Long usedTimes;

    public void setExerciseId(Long exerciseId) 
    {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId() 
    {
        return exerciseId;
    }
    public void setLectureId(Long lectureId) 
    {
        this.lectureId = lectureId;
    }

    public Long getLectureId() 
    {
        return lectureId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDifficulty(String difficulty) 
    {
        this.difficulty = difficulty;
    }

    public String getDifficulty() 
    {
        return difficulty;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setUsedTimes(Long usedTimes) 
    {
        this.usedTimes = usedTimes;
    }

    public Long getUsedTimes() 
    {
        return usedTimes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("exerciseId", getExerciseId())
            .append("lectureId", getLectureId())
            .append("type", getType())
            .append("difficulty", getDifficulty())
            .append("score", getScore())
            .append("content", getContent())
            .append("answer", getAnswer())
            .append("usedTimes", getUsedTimes())
            .toString();
    }
}
