package com.ruoyi.project.api.current.mapper;

import com.ruoyi.project.api.current.domain.MarkerInfo;
import com.ruoyi.project.api.current.domain.WxMemberLocationCurrent;
import java.util.List;

/**
 * 会员当前位置Mapper接口
 * 
 * @author alex
 * @date 2019-11-29
 */
public interface WxMemberLocationCurrentMapper 
{
    /**
     * 查询会员当前位置
     * 
     * @param id 会员当前位置ID
     * @return 会员当前位置
     */
    public WxMemberLocationCurrent selectWxMemberLocationCurrentById(Long id);

    /**
     * 查询会员条数
     *
     * @param openid 会员当前位置ID
     * @return 会员条数
     */
    public int selectCountByOpenid(String openid);

    /**
     * 查询会员当前位置列表
     * 
     * @param wxMemberLocationCurrent 会员当前位置
     * @return 会员当前位置集合
     */
    public List<WxMemberLocationCurrent> selectWxMemberLocationCurrentList(WxMemberLocationCurrent wxMemberLocationCurrent);

    /**
     * 新增会员当前位置
     * 
     * @param wxMemberLocationCurrent 会员当前位置
     * @return 结果
     */
    public int insertWxMemberLocationCurrent(WxMemberLocationCurrent wxMemberLocationCurrent);

    /**
     * 修改会员当前位置
     * 
     * @param wxMemberLocationCurrent 会员当前位置
     * @return 结果
     */
    public int updateWxMemberLocationCurrent(WxMemberLocationCurrent wxMemberLocationCurrent);

    /**
     * 删除会员当前位置
     * 
     * @param id 会员当前位置ID
     * @return 结果
     */
    public int deleteWxMemberLocationCurrentById(Long id);

    /**
     * 批量删除会员当前位置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxMemberLocationCurrentByIds(String[] ids);


    /**
     * 查询所有会员当前位置
     *
     * @param info 会员信息
     * @return 会员当前位置
     */
    public List<MarkerInfo> getMemberInfoToMapMarkers(MarkerInfo info);
}
