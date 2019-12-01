package com.ruoyi.project.api.login.controller;


import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.api.WeChatUtils;
import com.ruoyi.project.api.login.domain.LoginUserInfo;
import com.ruoyi.project.api.wxMember.domain.WxMember;
import com.ruoyi.project.api.wxMember.service.IWxMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("微信登录")
@RestController
@RequestMapping("/api")
public class WeChatLoginController {

    @Autowired
    private IWxMemberService wxMemberService;

    public static final String TOKEN_KEY = "sk1due8dne83nd88j2kdj3";

    @ApiOperation("登录")
    @PostMapping("/login")
    public AjaxResult login(LoginUserInfo userInfo)
    {

        if(userInfo == null || "".equals(userInfo.getCode())){
            return AjaxResult.error("获取userInfo失败！");
        }
        // 获取code码
        String code = userInfo.getCode();
        // 通过code获取用户appid 与 sessionKey
        JSONObject sessionKeyOrOpenId = WeChatUtils.getSessionKeyOrOpenId(code);
        // openid
        String openid = sessionKeyOrOpenId.getString("openid" );
        // 通过openid查询用户
        WxMember member = wxMemberService.selectWxMemberByOpenid(openid);

        if( member == null ){

            String nickName = userInfo.getNickName();
            String avatarUrl = userInfo.getAvatarUrl();
            String gender  = userInfo.getGender();
            String city = userInfo.getCity();
            String country = userInfo.getCountry();
            String province = userInfo.getProvince();
            member = new WxMember();
            member.setOpenid(openid);
            member.setAvatar(avatarUrl);
            member.setNickname(nickName);
            member.setSex(Integer.parseInt(gender));
            member.setSalt(UUID.randomUUID().toString());
            member.setStatus(1);
            member.setRegIp(city + "," + country + "," + province);

            int count = wxMemberService.insertWxMember(member);

            if(count <= 0){
                return AjaxResult.error("新增用户失败");
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("token", TOKEN_KEY);
        result.put("userInfo", member);
        return AjaxResult.success(result);
    }

    @ApiOperation("检查登录信息")
    @PostMapping("/checkReg")
    public AjaxResult checkReg(String code){

        if (StringUtils.isEmpty(code)) {
            return AjaxResult.error("获取code失败");
        }

        // 通过code获取用户appid 与 sessionKey
        JSONObject sessionKeyOrOpenId = WeChatUtils.getSessionKeyOrOpenId(code);

        // openid
        String openid = sessionKeyOrOpenId.getString("openid" );

        if (StringUtils.isEmpty(code)) {
            return AjaxResult.error("获取openid失败");
        }

        // 通过openid查询用户
        WxMember member = wxMemberService.selectWxMemberByOpenid(openid);

        if (null == member || StringUtils.isEmpty(member.getOpenid())) {
            return AjaxResult.error("该用户没有注册");
        }

        Map<String, Object> result = new HashMap<>();
        result.put("token", TOKEN_KEY);
        result.put("userInfo", member);
        return AjaxResult.success(result);
    }


}
