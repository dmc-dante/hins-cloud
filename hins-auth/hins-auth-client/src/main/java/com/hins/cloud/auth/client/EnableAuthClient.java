package com.hins.cloud.auth.client;

import com.hins.cloud.auth.client.configuration.AuthClientAutoConfiguration;
import com.hins.cloud.common.EnableHinsCommon;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启自动扫描此模块相关配置的注解
 *
 * @Author: dqk
 * @Date: 2019/8/22 15:16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Import(AuthClientAutoConfiguration.class)
@EnableHinsCommon//同时开启基础配置
public @interface EnableAuthClient {
}
