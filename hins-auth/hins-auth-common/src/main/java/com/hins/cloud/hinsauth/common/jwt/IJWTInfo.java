package com.hins.cloud.hinsauth.common.jwt;

/**
 * jwt 包含的信息对象接口定义
 *
 * @Author: dqk
 * @Date: 2019/8/12 9:28
 */
public interface IJWTInfo<T> {
	/**
	 * 返回主ID
	 *
	 * @return id
	 */
	String getId();

	/**
	 * 返回其他信息
	 *
	 * @return
	 */
	T getData();
}
