package com.suwei.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : suwei
 * @description : 浏览器安全访问配置类
 * @date : 2017\11\16 0016 14:43
 */

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests() //对下面的请求授权
                .antMatchers("/imooc-signIn.html").permitAll()
                .anyRequest()   //对任何请求
                .authenticated() //都需要认证
                .and()
                .csrf().disable();
    }
}
