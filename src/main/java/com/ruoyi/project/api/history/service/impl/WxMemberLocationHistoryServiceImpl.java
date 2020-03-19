package com.ruoyi.project.api.history.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.api.history.mapper.WxMemberLocationHistoryMapper;
import com.ruoyi.project.api.history.domain.WxMemberLocationHistory;
import com.ruoyi.project.api.history.service.IWxMemberLocationHistoryService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 会员历史位置Service业务层处理
 * 
 * @author alex
 * @date 2019-11-29
 */
@Service
public class WxMemberLocationHistoryServiceImpl implements IWxMemberLocationHistoryService 
{
    @Autowired
    private WxMemberLocationHistoryMapper wxMemberLocationHistoryMapper;

    /**
     * 查询会员历史位置
     * 
     * @param id 会员历史位置ID
     * @return 会员历史位置
     */
    @Override
    public WxMemberLocationHistory selectWxMemberLocationHistoryById(Long id)
    {
        return wxMemberLocationHistoryMapper.selectWxMemberLocationHistoryById(id);
    }

    /**
     * 查询会员历史位置列表
     * 
     * @param wxMemberLocationHistory 会员历史位置
     * @return 会员历史位置
     */
    @Override
    public List<WxMemberLocationHistory> selectWxMemberLocationHistoryList(WxMemberLocationHistory wxMemberLocationHistory)
    {
        return wxMemberLocationHistoryMapper.selectWxMemberLocationHistoryList(wxMemberLocationHistory);
    }

    /**
     * 新增会员历史位置
     * 
     * @param wxMemberLocationHistory 会员历史位置
     * @return 结果
     */
    @Override
    public int insertWxMemberLocationHistory(WxMemberLocationHistory wxMemberLocationHistory)
    {
        wxMemberLocationHistory.setCreateTime(DateUtils.getNowDate());
        return wxMemberLocationHistoryMapper.insertWxMemberLocationHistory(wxMemberLocationHistory);
    }

    /**
     * 修改会员历史位置
     * 
     * @param wxMemberLocationHistory 会员历史位置
     * @return 结果
     */
    @Override
    public int updateWxMemberLocationHistory(WxMemberLocationHistory wxMemberLocationHistory)
    {
        wxMemberLocationHistory.setUpdateTime(DateUtils.getNowDate());
        return wxMemberLocationHistoryMapper.updateWxMemberLocationHistory(wxMemberLocationHistory);
    }

    /**
     * 删除会员历史位置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxMemberLocationHistoryByIds(String ids)
    {
        return wxMemberLocationHistoryMapper.deleteWxMemberLocationHistoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员历史位置信息
     * 
     * @param id 会员历史位置ID
     * @return 结果
     */
    @Override
    public int deleteWxMemberLocationHistoryById(Long id)
    {
        return wxMemberLocationHistoryMapper.deleteWxMemberLocationHistoryById(id);
    }
}
