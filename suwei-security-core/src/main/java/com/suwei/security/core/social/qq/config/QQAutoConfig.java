package com.suwei.security.core.social.qq.config;

import com.suwei.security.core.properties.QQProprerties;
import com.suwei.security.core.properties.SecurityProperties;
import com.suwei.security.core.social.qq.connect.QQConnectionFactory;
import com.suwei.security.core.social.suweiConnectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;


/**
 * @author : suwei
 * @description :
 * @date : 2017\12\18 0018 10:01
 */
@Configuration
@ConditionalOnProperty(prefix = "suwei.security.social.qq",name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProprerties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
    }

    @Bean({"connect/qqConnect","connect/qqConnected"})
    @ConditionalOnMissingBean(name = "suweiConnectView")
    public View suweiConnectView(){
        return new suweiConnectView();
    }
}
