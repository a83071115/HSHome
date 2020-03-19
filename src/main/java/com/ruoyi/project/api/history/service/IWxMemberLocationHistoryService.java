package com.ruoyi.project.api.history.service;

import com.ruoyi.project.api.history.domain.WxMemberLocationHistory;
import java.util.List;

/**
 * 会员历史位置Service接口
 * 
 * @author alex
 * @date 2019-11-29
 */
public interface IWxMemberLocationHistoryService 
{
    /**
     * 查询会员历史位置
     * 
     * @param id 会员历史位置ID
     * @return 会员历史位置
     */
    public WxMemberLocationHistory selectWxMemberLocationHistoryById(Long id);

    /**
     * 查询会员历史位置列表
     * 
     * @param wxMemberLocationHistory 会员历史位置
     * @return 会员历史位置集合
     */
    public List<WxMemberLocationHistory> selectWxMemberLocationHistoryList(WxMemberLocationHistory wxMemberLocationHistory);

    /**
     * 新增会员历史位置
     * 
     * @param wxMemberLocationHistory 会员历史位置
     * @return 结果
     */
    public int insertWxMemberLocationHistory(WxMemberLocationHistory wxMemberLocationHistory);

    /**
     * 修改会员历史位置
     * 
     * @param wxMemberLocationHistory 会员历史位置
     * @return 结果
     */
    public int updateWxMemberLocationHistory(WxMemberLocationHistory wxMemberLocationHistory);

    /**
     * 批量删除会员历史位置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxMemberLocationHistoryByIds(String ids);

    /**
     * 删除会员历史位置信息
     * 
     * @param id 会员历史位置ID
     * @return 结果
     */
    public int deleteWxMemberLocationHistoryById(Long id);
}
