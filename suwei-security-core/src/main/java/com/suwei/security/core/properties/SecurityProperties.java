package com.suwei.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : suwei
 * @description : 系统配置类
 * @date : 2017\12\7 0007 16:09
 */
@ConfigurationProperties(prefix = "suwei.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
