package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CouMessageMapper;
import com.ruoyi.system.domain.CouMessage;
import com.ruoyi.system.service.ICouMessageService;

/**
 * 消息，可以用来示学生和教师之间的交互。Service业务层处理
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Service
public class CouMessageServiceImpl implements ICouMessageService 
{
    @Autowired
    private CouMessageMapper couMessageMapper;

    /**
     * 查询消息，可以用来示学生和教师之间的交互。
     * 
     * @param messageId 消息，可以用来示学生和教师之间的交互。主键
     * @return 消息，可以用来示学生和教师之间的交互。
     */
    @Override
    public CouMessage selectCouMessageByMessageId(Long messageId)
    {
        return couMessageMapper.selectCouMessageByMessageId(messageId);
    }

    /**
     * 查询消息，可以用来示学生和教师之间的交互。列表
     * 
     * @param couMessage 消息，可以用来示学生和教师之间的交互。
     * @return 消息，可以用来示学生和教师之间的交互。
     */
    @Override
    public List<CouMessage> selectCouMessageList(CouMessage couMessage)
    {
        return couMessageMapper.selectCouMessageList(couMessage);
    }

    /**
     * 新增消息，可以用来示学生和教师之间的交互。
     * 
     * @param couMessage 消息，可以用来示学生和教师之间的交互。
     * @return 结果
     */
    @Override
    public int insertCouMessage(CouMessage couMessage)
    {
        return couMessageMapper.insertCouMessage(couMessage);
    }

    /**
     * 修改消息，可以用来示学生和教师之间的交互。
     * 
     * @param couMessage 消息，可以用来示学生和教师之间的交互。
     * @return 结果
     */
    @Override
    public int updateCouMessage(CouMessage couMessage)
    {
        return couMessageMapper.updateCouMessage(couMessage);
    }

    /**
     * 批量删除消息，可以用来示学生和教师之间的交互。
     * 
     * @param messageIds 需要删除的消息，可以用来示学生和教师之间的交互。主键
     * @return 结果
     */
    @Override
    public int deleteCouMessageByMessageIds(Long[] messageIds)
    {
        return couMessageMapper.deleteCouMessageByMessageIds(messageIds);
    }

    /**
     * 删除消息，可以用来示学生和教师之间的交互。信息
     * 
     * @param messageId 消息，可以用来示学生和教师之间的交互。主键
     * @return 结果
     */
    @Override
    public int deleteCouMessageByMessageId(Long messageId)
    {
        return couMessageMapper.deleteCouMessageByMessageId(messageId);
    }
}
