package com.suwei.security.browser.support;

/**
 * @author : suwei
 * @description :
 * @date : 2017\12\18 0018 14:06
 */
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

}
