package com.ruoyi.project.api.wxMember.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 会员对象 wx_member
 * 
 * @author alex
 * @date 2019-11-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 会员名 */
    @Excel(name = "会员名")
    private String nickname;

    /** 第三方id */
    @Excel(name = "第三方id")
    private String openid;

    /** 会员手机号码 */
    @Excel(name = "会员手机号码")
    private String mobile;

    /** 性别 1：男 2：女 */
    @Excel(name = "性别 1：男 2：女")
    private Integer sex;

    /** 会员头像 */
    @Excel(name = "会员头像")
    private String avatar;

    /** 随机salt */
    @Excel(name = "随机salt")
    private String salt;

    /** 注册ip */
    @Excel(name = "注册ip")
    private String regIp;

    /** 状态 1：有效 0：无效 */
    @Excel(name = "状态 1：有效 0：无效")
    private Integer status;

    /** 最后一次更新时间 */
    @Excel(name = "最后一次更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    /** 插入时间 */
    @Excel(name = "插入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;


}
