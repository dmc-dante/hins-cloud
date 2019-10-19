package com.hins.cloud.common;

import com.hins.cloud.common.configuration.AutoConfiguration;
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
@Import(AutoConfiguration.class)
public @interface EnableHinsCommon {
}
