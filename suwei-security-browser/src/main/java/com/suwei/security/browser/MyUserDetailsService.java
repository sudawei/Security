package com.suwei.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



/**
 * @author : suwei
 * @description : 自定义的UserDetailsService
 * @date : 2017\12\1 0001 13:17
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录的用户名：{}",username);
        //根据用户名查找用户信息
        return new User(username,"suwei", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
