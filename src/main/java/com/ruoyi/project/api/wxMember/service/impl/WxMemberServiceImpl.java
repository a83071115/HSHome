package com.ruoyi.project.api.wxMember.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.api.wxMember.mapper.WxMemberMapper;
import com.ruoyi.project.api.wxMember.domain.WxMember;
import com.ruoyi.project.api.wxMember.service.IWxMemberService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 会员Service业务层处理
 * 
 * @author alex
 * @date 2019-11-28
 */
@Service
public class WxMemberServiceImpl implements IWxMemberService 
{
    @Autowired
    private WxMemberMapper wxMemberMapper;

    /**
     * 查询会员
     * 
     * @param id 会员ID
     * @return 会员
     */
    @Override
    public WxMember selectWxMemberById(Long id)
    {
        return wxMemberMapper.selectWxMemberById(id);
    }

    @Override
    public WxMember selectWxMemberByOpenid(String openid) {
        return wxMemberMapper.selectWxMemberByOpenid(openid);
    }

    /**
     * 查询会员列表
     * 
     * @param wxMember 会员
     * @return 会员
     */
    @Override
    public List<WxMember> selectWxMemberList(WxMember wxMember)
    {
        return wxMemberMapper.selectWxMemberList(wxMember);
    }

    /**
     * 新增会员
     * 
     * @param wxMember 会员
     * @return 结果
     */
    @Override
    public int insertWxMember(WxMember wxMember)
    {
        return wxMemberMapper.insertWxMember(wxMember);
    }

    /**
     * 修改会员
     * 
     * @param wxMember 会员
     * @return 结果
     */
    @Override
    public int updateWxMember(WxMember wxMember)
    {
        return wxMemberMapper.updateWxMember(wxMember);
    }

    /**
     * 删除会员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxMemberByIds(String ids)
    {
        return wxMemberMapper.deleteWxMemberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员信息
     * 
     * @param id 会员ID
     * @return 结果
     */
    @Override
    public int deleteWxMemberById(Long id)
    {
        return wxMemberMapper.deleteWxMemberById(id);
    }
}
