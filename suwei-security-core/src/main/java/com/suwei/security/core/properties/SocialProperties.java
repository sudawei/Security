package com.suwei.security.core.properties;

/**
 * @author : suwei
 * @description : 第三方登录配置
 * @date : 2017\12\18 0018 9:58
 */
public class SocialProperties {

    private String filterProcessesUrl = "/auth";

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    private QQProprerties qq = new QQProprerties();

    public QQProprerties getQq() {
        return qq;
    }

    public void setQq(QQProprerties qq) {
        this.qq = qq;
    }
}
