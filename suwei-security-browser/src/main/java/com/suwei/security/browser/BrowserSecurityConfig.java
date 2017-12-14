package com.suwei.security.browser;

import com.suwei.security.browser.authentication.SuweiAuthenticationFailureHandler;
import com.suwei.security.browser.authentication.SuweiAuthenticationSuccessHandler;
import com.suwei.security.core.properties.SecurityProperties;
import com.suwei.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author : suwei
 * @description : 浏览器安全访问配置类
 * @date : 2017\11\16 0016 14:43
 */

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private SuweiAuthenticationSuccessHandler suweiAuthenticationSuccessHandler;

    @Autowired
    private SuweiAuthenticationFailureHandler suweiAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        //给validateCodeFilter设置默认的认证失败处理器
        validateCodeFilter.setAuthenticationFailureHandler(suweiAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(suweiAuthenticationSuccessHandler)
                .failureHandler(suweiAuthenticationFailureHandler)
                .and()
                .authorizeRequests() //对下面的请求授权
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image").permitAll()
                .anyRequest()   //对任何请求
                .authenticated() //都需要认证
                .and()
                .csrf().disable();
    }
}
