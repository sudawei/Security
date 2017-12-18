package com.suwei.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author : suwei
 * @description :
 * @date : 2017\12\18 0018 10:24
 */
public class suweiSocialSecurityConfig extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public suweiSocialSecurityConfig(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }



}
