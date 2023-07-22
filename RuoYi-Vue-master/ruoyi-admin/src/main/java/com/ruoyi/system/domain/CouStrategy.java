package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。对象 cou_strategy
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class CouStrategy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 策略编号 */
    private Long strategyId;

    /** 策略名称 */
    @Excel(name = "策略名称")
    private String name;

    /** 平时成绩比例 */
    @Excel(name = "平时成绩比例")
    private Long usualPercent;

    /** 期中成绩比例 */
    @Excel(name = "期中成绩比例")
    private Long midPercent;

    /** 期末成绩比例 */
    @Excel(name = "期末成绩比例")
    private Long finalPercent;

    /** 其它成绩比例 */
    @Excel(name = "其它成绩比例")
    private Long otherPercent;

    /** A+对应分数 */
    @Excel(name = "A+对应分数")
    private Long excellectPlus;

    /** A对应分数 */
    @Excel(name = "A对应分数")
    private Long excellent;

    /** A-对应分数 */
    @Excel(name = "A-对应分数")
    private Long excellentMinus;

    /** B+对应分数 */
    @Excel(name = "B+对应分数")
    private Long goodPlus;

    /** B对应分数 */
    @Excel(name = "B对应分数")
    private Long good;

    /** B-对应分数 */
    @Excel(name = "B-对应分数")
    private Long goodMinus;

    /** C+对应分数 */
    @Excel(name = "C+对应分数")
    private Long passPlus;

    /** C对应分数 */
    @Excel(name = "C对应分数")
    private Long pass;

    /** C-对应分数 */
    @Excel(name = "C-对应分数")
    private Long passMinus;

    /** D+对应分数 */
    @Excel(name = "D+对应分数")
    private Long failedPlus;

    /** D对应分数 */
    @Excel(name = "D对应分数")
    private Long failed;

    /** D-对应分数 */
    @Excel(name = "D-对应分数")
    private Long failedMinus;

    public void setStrategyId(Long strategyId) 
    {
        this.strategyId = strategyId;
    }

    public Long getStrategyId() 
    {
        return strategyId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUsualPercent(Long usualPercent) 
    {
        this.usualPercent = usualPercent;
    }

    public Long getUsualPercent() 
    {
        return usualPercent;
    }
    public void setMidPercent(Long midPercent) 
    {
        this.midPercent = midPercent;
    }

    public Long getMidPercent() 
    {
        return midPercent;
    }
    public void setFinalPercent(Long finalPercent) 
    {
        this.finalPercent = finalPercent;
    }

    public Long getFinalPercent() 
    {
        return finalPercent;
    }
    public void setOtherPercent(Long otherPercent) 
    {
        this.otherPercent = otherPercent;
    }

    public Long getOtherPercent() 
    {
        return otherPercent;
    }
    public void setExcellectPlus(Long excellectPlus) 
    {
        this.excellectPlus = excellectPlus;
    }

    public Long getExcellectPlus() 
    {
        return excellectPlus;
    }
    public void setExcellent(Long excellent) 
    {
        this.excellent = excellent;
    }

    public Long getExcellent() 
    {
        return excellent;
    }
    public void setExcellentMinus(Long excellentMinus) 
    {
        this.excellentMinus = excellentMinus;
    }

    public Long getExcellentMinus() 
    {
        return excellentMinus;
    }
    public void setGoodPlus(Long goodPlus) 
    {
        this.goodPlus = goodPlus;
    }

    public Long getGoodPlus() 
    {
        return goodPlus;
    }
    public void setGood(Long good) 
    {
        this.good = good;
    }

    public Long getGood() 
    {
        return good;
    }
    public void setGoodMinus(Long goodMinus) 
    {
        this.goodMinus = goodMinus;
    }

    public Long getGoodMinus() 
    {
        return goodMinus;
    }
    public void setPassPlus(Long passPlus) 
    {
        this.passPlus = passPlus;
    }

    public Long getPassPlus() 
    {
        return passPlus;
    }
    public void setPass(Long pass) 
    {
        this.pass = pass;
    }

    public Long getPass() 
    {
        return pass;
    }
    public void setPassMinus(Long passMinus) 
    {
        this.passMinus = passMinus;
    }

    public Long getPassMinus() 
    {
        return passMinus;
    }
    public void setFailedPlus(Long failedPlus) 
    {
        this.failedPlus = failedPlus;
    }

    public Long getFailedPlus() 
    {
        return failedPlus;
    }
    public void setFailed(Long failed) 
    {
        this.failed = failed;
    }

    public Long getFailed() 
    {
        return failed;
    }
    public void setFailedMinus(Long failedMinus) 
    {
        this.failedMinus = failedMinus;
    }

    public Long getFailedMinus() 
    {
        return failedMinus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("strategyId", getStrategyId())
            .append("name", getName())
            .append("usualPercent", getUsualPercent())
            .append("midPercent", getMidPercent())
            .append("finalPercent", getFinalPercent())
            .append("otherPercent", getOtherPercent())
            .append("excellectPlus", getExcellectPlus())
            .append("excellent", getExcellent())
            .append("excellentMinus", getExcellentMinus())
            .append("goodPlus", getGoodPlus())
            .append("good", getGood())
            .append("goodMinus", getGoodMinus())
            .append("passPlus", getPassPlus())
            .append("pass", getPass())
            .append("passMinus", getPassMinus())
            .append("failedPlus", getFailedPlus())
            .append("failed", getFailed())
            .append("failedMinus", getFailedMinus())
            .toString();
    }
}
