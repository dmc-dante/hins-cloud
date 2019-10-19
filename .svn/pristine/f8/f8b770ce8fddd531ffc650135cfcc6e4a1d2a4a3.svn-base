package com.hins.cloud.common.log;

import org.slf4j.Logger;

/**
 * 日志工厂类
 *
 * @Author: dqk
 * @Date: 2019/8/8 14:33
 */
public class LoggerFactory {
	private LoggerFactory() {}

	/**
	 * 获取log
	 *
	 * @param name
	 * @return
	 */
	public static Logger getLogger(String name) {
		return org.slf4j.LoggerFactory.getLogger(name);
	}

	/**
	 * 获取log
	 *
	 * @param clazz
	 * @return
	 */
	public static Logger getLogger(Class<?> clazz) {
		return org.slf4j.LoggerFactory.getLogger(clazz);
	}
}
