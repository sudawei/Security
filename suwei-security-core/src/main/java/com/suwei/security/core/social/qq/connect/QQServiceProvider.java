package com.suwei.security.core.social.qq.connect;

import com.suwei.security.core.social.qq.api.QQ;
import com.suwei.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @author : suwei
 * @description : QQServiceProvider
 * @date : 2017\12\15 0015 13:12
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ>{


    private String appId;

    //Step1：获取Authorization Code
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    //Step2：通过Authorization Code获取Access Token
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId,String appSecret) {
        super(new QQOAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appId);
    }


}
