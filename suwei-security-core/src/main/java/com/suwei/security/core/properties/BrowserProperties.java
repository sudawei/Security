package com.suwei.security.core.properties;

/**
 * @author : suwei
 * @description : 浏览器相关安全配置类
 * @date : 2017\12\7 0007 16:09
 */
public class BrowserProperties {

    private String loginPage = "/imooc-signIn.html";

    private LoginType loginType  = LoginType.JSON;

    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
