package com.suwei.security.core.validate.code.sms;

/**
 * @author : suwei
 * @description : 短信验证码发送商
 * @date : 2017\12\14 0014 14:00
 */
public interface SmsCodeSender {
    void send(String mobile,String code);
}
