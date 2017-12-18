package com.suwei.security.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @author : suwei
 * @description : ConnectionSignUp的实现类，给第三方登录的用户默认注册
 * @date : 2017\12\18 0018 15:38
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户信息默认创建用户，并且返回用户唯一标识
        return connection.getDisplayName();
    }
}
