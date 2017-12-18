package com.suwei.security.browser.authentication;

import com.suwei.security.browser.support.ServerResponse;
import com.suwei.security.core.properties.LoginType;
import com.suwei.security.core.properties.SecurityProperties;
import com.suwei.security.core.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : suwei
 * @description : 认证失败的处理器
 * @date : 2017\12\12 0012 16:11
 */
@Component
public class SuweiAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        logger.info("登录失败");
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            //在getWriter()方法被调用之前调用
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtil.obj2String(ServerResponse.createByErrorMessage(e.getMessage())));
        }else {
           super.onAuthenticationFailure(request,response,e);
        }
        response.getWriter().flush();
        response.getWriter().close();
    }
}
