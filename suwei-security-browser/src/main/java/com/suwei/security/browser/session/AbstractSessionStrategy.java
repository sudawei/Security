package com.suwei.security.browser.session;

import com.suwei.security.browser.support.ServerResponse;
import com.suwei.security.core.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : suwei
 * @description :
 * @date : 2017\12\20 0020 9:23
 */
public class AbstractSessionStrategy {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 跳转的url
     */
    private String destinationUrl;
    /**
     * 重定向策略
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    /**
     * 跳转前是否创建新的session
     */
    private boolean createNewSession = true;



    /**
     * @param invalidSessionUrl
     */
    public AbstractSessionStrategy(String invalidSessionUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(invalidSessionUrl), "url must start with '/' or with 'http(s)'");
        this.destinationUrl = invalidSessionUrl;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.session.InvalidSessionStrategy#
     * onInvalidSessionDetected(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    protected void onSessionInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (createNewSession) {
            request.getSession();
        }

        String sourceUrl = request.getRequestURI();
        String targetUrl;

        if (StringUtils.endsWithIgnoreCase(sourceUrl, ".html")) {
            targetUrl = destinationUrl+".html";
            logger.info("session失效,跳转到"+targetUrl);
            redirectStrategy.sendRedirect(request, response, targetUrl);
        }else{
            Object result = buildResponseContent(request);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtil.obj2String(result));
        }

    }

    /**
     * @param request
     * @return
     */
    protected Object buildResponseContent(HttpServletRequest request) {
        String message = "session已失效";
        if(isConcurrency()){
            message = message + "，有可能是并发登录导致的";
        }
        return ServerResponse.createByErrorMessage(message);
    }

    /**
     * session失效是否是并发导致的
     * @return
     */
    protected boolean isConcurrency() {
        return false;
    }

    /**
     * Determines whether a new session should be created before redirecting (to
     * avoid possible looping issues where the same session ID is sent with the
     * redirected request). Alternatively, ensure that the configured URL does
     * not pass through the {@code SessionManagementFilter}.
     *
     * @param createNewSession
     *            defaults to {@code true}.
     */
    public void setCreateNewSession(boolean createNewSession) {
        this.createNewSession = createNewSession;
    }
}
