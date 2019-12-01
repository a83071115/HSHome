package com.ruoyi.project.api.current.domain;

import lombok.*;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.shiro.crypto.hash.Hash;

/**
 * 会员当前位置对象 wx_member_location_current
 * 
 * @author alex
 * @date 2019-11-29
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WxMemberLocationCurrent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String openid;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 速度 */
    @Excel(name = "速度")
    private String speed;



}
