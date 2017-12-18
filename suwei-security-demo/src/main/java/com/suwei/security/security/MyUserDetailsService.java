package com.suwei.security.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;



/**
 * @author : suwei
 * @description : 自定义的UserDetailsService
 * @date : 2017\12\1 0001 13:17
 */
@Component
public class MyUserDetailsService implements UserDetailsService,SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查找用户信息
        logger.info("表单登录的用户名：{}",username);
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        //根据用户id查找用户信息
        logger.info("社交登录的用户id：{}",userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {
        String password = passwordEncoder.encode("suwei");
        return new SocialUser(userId,password,
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
