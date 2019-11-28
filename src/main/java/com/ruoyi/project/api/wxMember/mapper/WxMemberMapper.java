package com.ruoyi.project.api.wxMember.mapper;

import com.ruoyi.project.api.wxMember.domain.WxMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 会员Mapper接口
 * 
 * @author alex
 * @date 2019-11-28
 */
@Mapper
public interface WxMemberMapper 
{
    /**
     * 查询会员
     * 
     * @param id 会员ID
     * @return 会员
     */
    public WxMember selectWxMemberById(Long id);

    /**
     * 查询会员
     *
     * @param openid 会员OPENID
     * @return 会员
     */
    public WxMember selectWxMemberByOpenid(String openid);

    /**
     * 查询会员列表
     * 
     * @param wxMember 会员
     * @return 会员集合
     */
    public List<WxMember> selectWxMemberList(WxMember wxMember);

    /**
     * 新增会员
     * 
     * @param wxMember 会员
     * @return 结果
     */
    public int insertWxMember(WxMember wxMember);

    /**
     * 修改会员
     * 
     * @param wxMember 会员
     * @return 结果
     */
    public int updateWxMember(WxMember wxMember);

    /**
     * 删除会员
     * 
     * @param id 会员ID
     * @return 结果
     */
    public int deleteWxMemberById(Long id);

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxMemberByIds(String[] ids);
}
