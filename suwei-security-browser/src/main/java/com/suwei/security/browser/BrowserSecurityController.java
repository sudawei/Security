package com.suwei.security.browser;

import com.suwei.security.browser.support.ResponseCode;
import com.suwei.security.browser.support.ServerResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : suwei
 * @description :
 * @date : 2017\12\7 0007 15:40
 */
@RestController
public class BrowserSecurityController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 当需要身份认证时，跳转到这里
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ServerResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response){
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest != null){
            String redirectUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是: {}",redirectUrl);
            //判断url的类型
            if(StringUtils.endsWith(redirectUrl,".html")){
                redirectStrategy.sendRedirect(request,response,"");
            }
        }
        return  ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_AUTHORIZED.getCode(),"访问的服务需要身份认证");
    }
}
