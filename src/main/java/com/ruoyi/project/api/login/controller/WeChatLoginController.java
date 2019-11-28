package com.ruoyi.project.api.login.controller;


import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.api.WeChatUtils;
import com.ruoyi.project.api.login.domain.LoginUserInfo;
import com.ruoyi.project.api.user.domain.UserEntity;
import com.ruoyi.project.api.wxMember.domain.WxMember;
import com.ruoyi.project.api.wxMember.service.IWxMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        Map<String, String> result = new HashMap<>();
        result.put("token", "token");
        return AjaxResult.success();
    }


}
