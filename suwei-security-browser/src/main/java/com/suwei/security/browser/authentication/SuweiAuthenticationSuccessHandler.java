package com.suwei.security.browser.authentication;

import com.suwei.security.browser.support.ServerResponse;
import com.suwei.security.core.properties.LoginType;
import com.suwei.security.core.properties.SecurityProperties;
import com.suwei.security.core.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : suwei
 * @description : 认证成功处理器
 * @date : 2017\12\12 0012 15:46
 */
@Component
public class SuweiAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功");
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            //在getWriter()方法被调用之前调用
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtil.obj2String(ServerResponse.createBySuccess("登录成功",authentication)));
        }else{
            super.onAuthenticationSuccess(request,response,authentication);
        }
        response.getWriter().flush();
        response.getWriter().close();
    }
}
