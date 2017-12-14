package com.suwei.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author : suwei
 * @description : 验证码生成器接口
 * @date : 2017\12\14 0014 10:08
 */
public interface ValidateCodeGenerator {

    ImageCode generate(ServletWebRequest request);
}
