package com.suwei.security.core.validate.code.sms;

/**
 * @author : suwei
 * @description : 默认短信验证码发送商
 * @date : 2017\12\14 0014 14:00
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机号："+mobile+"发送验证码："+code);
    }
}
