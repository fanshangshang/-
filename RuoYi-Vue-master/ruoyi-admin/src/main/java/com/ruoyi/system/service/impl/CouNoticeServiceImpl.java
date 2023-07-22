package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CouNoticeMapper;
import com.ruoyi.system.domain.CouNotice;
import com.ruoyi.system.service.ICouNoticeService;

/**
 * 公告信息Service业务层处理
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
@Service
public class CouNoticeServiceImpl implements ICouNoticeService 
{
    @Autowired
    private CouNoticeMapper couNoticeMapper;

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告信息主键
     * @return 公告信息
     */
    @Override
    public CouNotice selectCouNoticeByNoticeId(Long noticeId)
    {
        return couNoticeMapper.selectCouNoticeByNoticeId(noticeId);
    }

    /**
     * 查询公告信息列表
     * 
     * @param couNotice 公告信息
     * @return 公告信息
     */
    @Override
    public List<CouNotice> selectCouNoticeList(CouNotice couNotice)
    {
        return couNoticeMapper.selectCouNoticeList(couNotice);
    }

    /**
     * 新增公告信息
     * 
     * @param couNotice 公告信息
     * @return 结果
     */
    @Override
    public int insertCouNotice(CouNotice couNotice)
    {
        return couNoticeMapper.insertCouNotice(couNotice);
    }

    /**
     * 修改公告信息
     * 
     * @param couNotice 公告信息
     * @return 结果
     */
    @Override
    public int updateCouNotice(CouNotice couNotice)
    {
        return couNoticeMapper.updateCouNotice(couNotice);
    }

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告信息主键
     * @return 结果
     */
    @Override
    public int deleteCouNoticeByNoticeIds(Long[] noticeIds)
    {
        return couNoticeMapper.deleteCouNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除公告信息信息
     * 
     * @param noticeId 公告信息主键
     * @return 结果
     */
    @Override
    public int deleteCouNoticeByNoticeId(Long noticeId)
    {
        return couNoticeMapper.deleteCouNoticeByNoticeId(noticeId);
    }
}
