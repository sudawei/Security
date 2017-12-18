package com.suwei.security.core.social.qq.connect;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @author : suwei
 * @description : 自定义OAuth2Template，重写createRestTemplate方法，添加text/html的convert
 * @date : 2017\12\18 0018 11:44
 */
public class QQOAuth2Template extends OAuth2Template {

    private Logger log = LoggerFactory.getLogger(getClass());

    public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        String resultStr = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
        log.info("获取accessToken的响应：" + resultStr);
        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(resultStr, "&");
        String accessToken = StringUtils.substringAfterLast(items[0], "=");
        Long expireIn = new Long( StringUtils.substringAfterLast(items[1], "="));
        String refreshToken = StringUtils.substringAfterLast(items[2], "=");
        return new AccessGrant(accessToken,null,refreshToken,expireIn);
    }

    /**
     * 重写createRestTemplate方法，添加text/html的convert
     * @return
     */
    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = super.createRestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }
}
