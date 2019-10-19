package com.hins.cloud.auth.server.service;

import com.hins.cloud.hinsauth.common.dto.AuthParam;
import com.hins.cloud.hinsauth.common.dto.TokenResult;

/**
 * 授权service类
 *
 * @Author: dqk
 * @Date: 2019/8/14 14:25
 */
public interface AuthService {
	/**
	 * 用户授权请求
	 *
	 * @param param
	 * @return
	 */
	TokenResult auth(AuthParam param);

	String refresh(String oldToken);

	void validate(String token);
}
