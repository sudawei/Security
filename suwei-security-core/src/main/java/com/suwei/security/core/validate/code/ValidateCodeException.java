package com.suwei.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author : suwei
 * @description : 图形验证相关异常
 * @date : 2017\12\13 0013 16:33
 */
public class ValidateCodeException extends AuthenticationException {

    /**
     * Constructs an {@code AuthenticationException} with the specified message and no
     * root cause.
     *
     * @param msg the detail message
     */
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
