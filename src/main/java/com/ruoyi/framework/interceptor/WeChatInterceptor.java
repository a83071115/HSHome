package com.ruoyi.framework.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.api.login.controller.WeChatLoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <b>说明：</b><br>
 * 业务分类 :
 * <b>著作权：</b> Copyright (C) 2017 JINCHAN CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019/11/29 孙强
 */
@Component
public class WeChatInterceptor extends HandlerInterceptorAdapter {


    private static final Logger log = LoggerFactory.getLogger(WeChatInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURL()+"===========preHandle===========");
        String token = request.getHeader("token");
        if( !WeChatLoginController.TOKEN_KEY.equals(token)){
            AjaxResult ajaxResult = AjaxResult.token_error();
            ServletUtils.renderString(response, JSONObject.toJSONString(ajaxResult));
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
