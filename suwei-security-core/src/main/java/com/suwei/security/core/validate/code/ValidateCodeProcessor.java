package com.suwei.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author : suwei
 * @description : 校验码处理器，封装不同校验码的处理逻辑
 * @date : 2017\12\14 0014 14:32
 */
public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;
}
