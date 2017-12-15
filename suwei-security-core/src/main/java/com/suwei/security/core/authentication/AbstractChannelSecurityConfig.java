package com.suwei.security.core.authentication;

import com.suwei.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author : suwei
 * @description : 认证配置的父类，浏览器和app认证配置都要继承本类
 * @date : 2017\12\15 0015 9:46
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler suweiAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler suweiAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(suweiAuthenticationSuccessHandler)
                .failureHandler(suweiAuthenticationFailureHandler);
    }

}