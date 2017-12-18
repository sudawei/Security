package com.suwei.security.core.social.qq.api;

import com.suwei.security.core.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @author : suwei
 * @description : qq api的实现类
 * @date : 2017\12\15 0015 11:47
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
    private Logger log = LoggerFactory.getLogger(getClass());

    private static final String URL_GET_OPPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String oppenId;

    public QQImpl(String accessToken, String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        String url = String.format(URL_GET_OPPENID,accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        this.oppenId = StringUtils.substringBetween(result,"\"openid\":\"","\"} )");
        log.info("oppenId:"+oppenId);
    }

    /**
     * 获取QQ用户信息
     * @return
     */
    @Override
    public QQUserInfo getQQUserInfo() {
        String url = String.format(URL_GET_USERINFO, appId, oppenId);
        String result = getRestTemplate().getForObject(url, String.class);
        log.info("QQUserInfo:"+result);
        QQUserInfo qqUserInfo = JsonUtil.string2Obj(result, QQUserInfo.class);
        qqUserInfo.setOpenId(oppenId);
        return qqUserInfo;
    }
}
