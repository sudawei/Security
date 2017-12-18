package com.suwei.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author : suwei
 * @description : QQProprerties
 * @date : 2017\12\15 0015 14:41
 */
public class QQProprerties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
