package com.suwei.security.core.social.qq.connect;

import com.suwei.security.core.social.qq.api.QQ;
import com.suwei.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author : suwei
 * @description : qq api的适配器
 * @date : 2017\12\15 0015 13:22
 */
public class QQAdapter implements ApiAdapter<QQ> {

    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo qqUserInfo = api.getQQUserInfo();

        //将qqUserInfo中的信息设置到Connection中
        values.setDisplayName(qqUserInfo.getNickname());
        values.setImageUrl(qqUserInfo.getFigureurl_1());
        values.setProfileUrl(null);
        values.setProviderUserId(qqUserInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {
        //do nothing
    }
}
