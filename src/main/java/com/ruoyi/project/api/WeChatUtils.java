package com.ruoyi.project.api;

import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.http.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class WeChatUtils {

    public static final String WECHAT_APPID = "wx28d67032e8edee9c" ;
    public static final String WECHAT_SECRET = "f364e231a55f9d8ea620bd66d129c34b" ;


    public static JSONObject getSessionKeyOrOpenId(String code) {
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, Object> requestUrlParam = new HashMap<>();
        requestUrlParam.put("appid", WECHAT_APPID);//小程序appId
        requestUrlParam.put("secret", WECHAT_SECRET);
        requestUrlParam.put("js_code", wxCode);//小程序端返回的code
        requestUrlParam.put("grant_type", "authorization_code");//默认参数

        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpUtil.post(requestUrl, requestUrlParam));
        return jsonObject;
    }
}
