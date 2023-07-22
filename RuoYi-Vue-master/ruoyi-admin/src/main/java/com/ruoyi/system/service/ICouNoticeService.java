package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CouNotice;

/**
 * 公告信息Service接口
 * 
 * @author 邱瑞
 * @date 2023-07-16
 */
public interface ICouNoticeService 
{
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告信息主键
     * @return 公告信息
     */
    public CouNotice selectCouNoticeByNoticeId(Long noticeId);

    /**
     * 查询公告信息列表
     * 
     * @param couNotice 公告信息
     * @return 公告信息集合
     */
    public List<CouNotice> selectCouNoticeList(CouNotice couNotice);

    /**
     * 新增公告信息
     * 
     * @param couNotice 公告信息
     * @return 结果
     */
    public int insertCouNotice(CouNotice couNotice);

    /**
     * 修改公告信息
     * 
     * @param couNotice 公告信息
     * @return 结果
     */
    public int updateCouNotice(CouNotice couNotice);

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告信息主键集合
     * @return 结果
     */
    public int deleteCouNoticeByNoticeIds(Long[] noticeIds);

    /**
     * 删除公告信息信息
     * 
     * @param noticeId 公告信息主键
     * @return 结果
     */
    public int deleteCouNoticeByNoticeId(Long noticeId);
}
