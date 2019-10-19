package com.hins.cloud.common.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: dqk
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/**
	 * Sets application context.
	 *
	 * @param applicationContext the application context
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * Gets application context.
	 *
	 * @return the application context
	 */
	public static ApplicationContext getApplicationContext() {
		assertApplicationContext();
		return applicationContext;
	}

	private static void assertApplicationContext() {
		if (SpringContextHolder.applicationContext == null) {
			throw new IllegalArgumentException("applicationContext属性为null,请检查是否注入了SpringContextHolder!");
		}
	}
}
