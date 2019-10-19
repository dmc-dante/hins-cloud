package com.hins.cloud.demoservice1.config;

import com.hins.cloud.auth.client.interceptor.UserAuthRestInterceptor;
import com.hins.cloud.common.handler.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * web mvc应用配置，相当于以前的spring-mvc.xml配置文件
 *
 * @Author: dqk
 * @Date: 2019/8/20 11:14
 */
@Configuration
@Primary
public class WebConfig implements WebMvcConfigurer {
	/**
	 * 用户授权拦截器拦截路径
	 */
	@Value("${auth.user.include.path:#{null}}")
	private List<String> userAuthIncludePath;
	/**
	 * 用户授权拦截器排除拦截路径
	 */
	@Value("${auth.user.exclude.path:#{null}}")
	private List<String> userAuthExcludePath;

	@Bean
	GlobalExceptionHandler getGlobalExceptionHandler() {
		return new GlobalExceptionHandler();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getUserAuthRestInterceptor())
			.addPathPatterns(userAuthIncludePath != null ? userAuthIncludePath : Arrays.asList("/**"))
			.excludePathPatterns(userAuthExcludePath != null ? userAuthExcludePath : Collections.emptyList());
	}

	@Bean
	UserAuthRestInterceptor getUserAuthRestInterceptor() {
		return new UserAuthRestInterceptor();
	}
}
