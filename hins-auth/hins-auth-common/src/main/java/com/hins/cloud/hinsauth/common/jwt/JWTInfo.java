package com.hins.cloud.hinsauth.common.jwt;

/**
 * JWT信息对象
 *
 * @Author: dqk
 * @Date: 2019/8/12 9:31
 */
public class JWTInfo<T> implements IJWTInfo {
	public JWTInfo() {
	}

	/**
	 * @param id
	 * @param data
	 */
	public JWTInfo(String id, T data) {
		this.id = id;
		this.data = data;
	}

	/**
	 * 主ID
	 */
	private String id;
	/**
	 * 其他信息
	 */
	private T data;

	/**
	 * 主ID
	 *
	 * @return
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * 主ID
	 *
	 * @param id
	 * @return
	 */
	public JWTInfo setId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * 其他信息
	 *
	 * @return
	 */
	@Override
	public T getData() {
		return this.data;
	}

	/**
	 * 其他信息
	 *
	 * @param data
	 * @return
	 */
	public JWTInfo setData(T data) {
		this.data = data;
		return this;
	}
}
