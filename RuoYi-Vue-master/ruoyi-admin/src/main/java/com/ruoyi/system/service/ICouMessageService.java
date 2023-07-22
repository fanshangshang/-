package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CouMessage;

/**
 * 消息，可以用来示学生和教师之间的交互。Service接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public interface ICouMessageService 
{
    /**
     * 查询消息，可以用来示学生和教师之间的交互。
     * 
     * @param messageId 消息，可以用来示学生和教师之间的交互。主键
     * @return 消息，可以用来示学生和教师之间的交互。
     */
    public CouMessage selectCouMessageByMessageId(Long messageId);

    /**
     * 查询消息，可以用来示学生和教师之间的交互。列表
     * 
     * @param couMessage 消息，可以用来示学生和教师之间的交互。
     * @return 消息，可以用来示学生和教师之间的交互。集合
     */
    public List<CouMessage> selectCouMessageList(CouMessage couMessage);

    /**
     * 新增消息，可以用来示学生和教师之间的交互。
     * 
     * @param couMessage 消息，可以用来示学生和教师之间的交互。
     * @return 结果
     */
    public int insertCouMessage(CouMessage couMessage);

    /**
     * 修改消息，可以用来示学生和教师之间的交互。
     * 
     * @param couMessage 消息，可以用来示学生和教师之间的交互。
     * @return 结果
     */
    public int updateCouMessage(CouMessage couMessage);

    /**
     * 批量删除消息，可以用来示学生和教师之间的交互。
     * 
     * @param messageIds 需要删除的消息，可以用来示学生和教师之间的交互。主键集合
     * @return 结果
     */
    public int deleteCouMessageByMessageIds(Long[] messageIds);

    /**
     * 删除消息，可以用来示学生和教师之间的交互。信息
     * 
     * @param messageId 消息，可以用来示学生和教师之间的交互。主键
     * @return 结果
     */
    public int deleteCouMessageByMessageId(Long messageId);
}
