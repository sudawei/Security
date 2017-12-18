package com.suwei.security.core.social.qq.connect;

import com.suwei.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;


/**
 * @author : suwei
 * @description : 创建Connection的工厂
 * @date : 2017\12\15 0015 13:30
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId,String appId,String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapter());
    }
}
