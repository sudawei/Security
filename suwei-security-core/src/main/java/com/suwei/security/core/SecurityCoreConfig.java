package com.suwei.security.core;

import com.suwei.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : suwei
 * @description : 使SecurityProperties生效
 * @date : 2017\12\7 0007 16:16
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
