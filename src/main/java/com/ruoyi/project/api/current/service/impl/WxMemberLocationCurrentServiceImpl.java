package com.ruoyi.project.api.current.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.api.current.domain.MarkerInfo;
import com.ruoyi.project.api.history.domain.WxMemberLocationHistory;
import com.ruoyi.project.api.history.mapper.WxMemberLocationHistoryMapper;
import com.ruoyi.project.api.wxMember.domain.WxMember;
import com.ruoyi.project.api.wxMember.mapper.WxMemberMapper;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.api.current.mapper.WxMemberLocationCurrentMapper;
import com.ruoyi.project.api.current.domain.WxMemberLocationCurrent;
import com.ruoyi.project.api.current.service.IWxMemberLocationCurrentService;
import com.ruoyi.common.utils.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员当前位置Service业务层处理
 * 
 * @author alex
 * @date 2019-11-29
 */
@Service
public class WxMemberLocationCurrentServiceImpl implements IWxMemberLocationCurrentService 
{
    @Autowired
    private WxMemberLocationCurrentMapper wxMemberLocationCurrentMapper;

    @Autowired
    private WxMemberLocationHistoryMapper wxMemberLocationHistoryMapper;

    /**
     * 查询会员当前位置
     * 
     * @param id 会员当前位置ID
     * @return 会员当前位置
     */
    @Override
    public WxMemberLocationCurrent selectWxMemberLocationCurrentById(Long id)
    {
        return wxMemberLocationCurrentMapper.selectWxMemberLocationCurrentById(id);
    }

    /**
     * 查询会员当前位置列表
     * 
     * @param wxMemberLocationCurrent 会员当前位置
     * @return 会员当前位置
     */
    @Override
    public List<WxMemberLocationCurrent> selectWxMemberLocationCurrentList(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        return wxMemberLocationCurrentMapper.selectWxMemberLocationCurrentList(wxMemberLocationCurrent);
    }

    /**
     * 新增会员当前位置
     * 
     * @param wxMemberLocationCurrent 会员当前位置
     * @return 结果
     */
    @Override
    public int insertWxMemberLocationCurrent(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        wxMemberLocationCurrent.setCreateTime(DateUtils.getNowDate());
        return wxMemberLocationCurrentMapper.insertWxMemberLocationCurrent(wxMemberLocationCurrent);
    }

    /**
     * 修改会员当前位置
     * 
     * @param wxMemberLocationCurrent 会员当前位置
     * @return 结果
     */
    @Override
    @Transactional
    public int updateWxMemberLocationCurrent(WxMemberLocationCurrent wxMemberLocationCurrent)
    {
        Date nowDate = DateUtils.getNowDate();
        wxMemberLocationCurrent.setUpdateTime(nowDate);
        wxMemberLocationCurrent.setCreateTime(nowDate);
        // 判断当前表是否有该用户的位置
        int count = wxMemberLocationCurrentMapper.selectCountByOpenid(wxMemberLocationCurrent.getOpenid());
        int flag;
        if(count == 0){
            flag = wxMemberLocationCurrentMapper.insertWxMemberLocationCurrent(wxMemberLocationCurrent);
        }else{
            flag = wxMemberLocationCurrentMapper.updateWxMemberLocationCurrent(wxMemberLocationCurrent);
        }
        WxMemberLocationHistory dto = new WxMemberLocationHistory();
        dto.setLatitude(wxMemberLocationCurrent.getLatitude());
        dto.setOpenid(wxMemberLocationCurrent.getOpenid());
        dto.setLongitude(wxMemberLocationCurrent.getLongitude());
        dto.setSpeed(wxMemberLocationCurrent.getSpeed());
        dto.setCreateTime(nowDate);
        wxMemberLocationHistoryMapper.insertWxMemberLocationHistory(dto);
        return flag;
    }

    /**
     * 删除会员当前位置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxMemberLocationCurrentByIds(String ids)
    {
        return wxMemberLocationCurrentMapper.deleteWxMemberLocationCurrentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员当前位置信息
     * 
     * @param id 会员当前位置ID
     * @return 结果
     */
    @Override
    public int deleteWxMemberLocationCurrentById(Long id)
    {
        return wxMemberLocationCurrentMapper.deleteWxMemberLocationCurrentById(id);
    }

    /**
     * 查询所有会员当前位置
     *
     * @param info 会员信息
     * @return 会员当前位置
     */
    @Override
    public List<MarkerInfo> getMemberInfoToMapMarkers(MarkerInfo info) {
        List<MarkerInfo> lists = wxMemberLocationCurrentMapper.getMemberInfoToMapMarkers(info);
        for (MarkerInfo list : lists){
            if (null != list.getCallout()) {
                HashMap<String, Object> callout = list.getCallout();
                callout.put("content", list.getNickname());
                callout.put("color", "#ffffff");
                callout.put("fontSize", "16");
                callout.put("borderRadius", "50");
                callout.put("padding", "10");
                callout.put("bgColor", "#0082FCaa");
                callout.put("display", "BYCLICK");
            }
        }
        return lists;
    }
}
