package com.suwei.security.browser.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suwei.security.browser.support.ServerResponse;
import com.suwei.security.core.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


/**
 * @author : suwei
 * @description : 退出成功处理器
 * @date : 2017\12\20 0020 13:47
 */
public class SuweiLogoutSuccessHandler  implements LogoutSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public SuweiLogoutSuccessHandler(String signOutSuccessUrl) {
        this.signOutSuccessUrl = signOutSuccessUrl;
    }

    private String signOutSuccessUrl;


    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.logout.
     * LogoutSuccessHandler#onLogoutSuccess(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        logger.info("退出成功");
        if (StringUtils.endsWithIgnoreCase("logout",signOutSuccessUrl)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtil.obj2String(ServerResponse.createBySuccessMessage("退出成功")));
        } else {
            response.sendRedirect(signOutSuccessUrl);
        }

    }

}
