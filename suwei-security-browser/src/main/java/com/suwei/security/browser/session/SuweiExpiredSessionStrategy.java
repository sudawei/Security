package com.suwei.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : suwei
 * @description : 记录并发登录时的session消息
 * @date : 2017\12\20 0020 9:07
 */

public class SuweiExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    public SuweiExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.session.SessionInformationExpiredStrategy#onExpiredSessionDetected(org.springframework.security.web.session.SessionInformationExpiredEvent)
     */
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    /* (non-Javadoc)
     * @see com.imooc.security.browser.session.AbstractSessionStrategy#isConcurrency()
     */
    @Override
    protected boolean isConcurrency() {
        return true;
    }

}