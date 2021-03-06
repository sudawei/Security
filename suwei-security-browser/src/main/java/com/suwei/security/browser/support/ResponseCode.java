package com.suwei.security.browser.support;

/**
 * Created by Administrator on 2017/7/8/008.
 */
public enum  ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    NEED_AUTHORIZED(401,"NEED_AUTHORIZED"),
    ILLEAGAL_ARGUMENT(2,"ILLEAGAL_ARGUMENT");

    private  final int code;
    private  final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
