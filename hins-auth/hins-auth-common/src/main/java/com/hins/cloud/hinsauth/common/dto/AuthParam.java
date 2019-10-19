package com.hins.cloud.hinsauth.common.dto;

/**
 * 授权请求参数
 *
 * @Author: dqk
 * @Date: 2019/8/14 14:49
 */
public class AuthParam {
	/**
	 * 登录账号
	 */
	private String account;
	/**
	 * 登录密码
	 */
	private String password;

	public String getAccount() {
		return account;
	}

	public AuthParam setAccount(String account) {
		this.account = account;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public AuthParam setPassword(String password) {
		this.password = password;
		return this;
	}
}
