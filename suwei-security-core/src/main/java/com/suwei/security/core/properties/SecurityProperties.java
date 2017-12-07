package com.suwei.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : suwei
 * @description : 系统配置类
 * @date : 2017\12\7 0007 16:09
 */
@ConfigurationProperties(prefix = "suwei.security")
public class SecurityProperties {

    private BrowserProperties browserProperties = new BrowserProperties();

    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }
}
