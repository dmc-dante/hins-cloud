package com.hins.cloud.hinsauth.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * token授权请求返回数据
 */
public class TokenResult implements Serializable {
	private static final long serialVersionUID = 677381638319323141L;
	/**
	 * access token
	 */
	private String accessToken;
	/**
	 * refresh token
	 */
	private String refreshToken;
	/**
	 * 系统授权时间
	 */
	private Date authTime;
	/**
	 * access token授权到期时间
	 */
	private Date expireTime;
	/**
	 * refresh token 到期时间
	 */
	private Date refreshTokenExpireTime;

	public String getAccessToken() {
		return accessToken;
	}

	public TokenResult setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public TokenResult setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}

	public Date getAuthTime() {
		return authTime;
	}

	public TokenResult setAuthTime(Date authTime) {
		this.authTime = authTime;
		return this;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public TokenResult setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
		return this;
	}

	public Date getRefreshTokenExpireTime() {
		return refreshTokenExpireTime;
	}

	public TokenResult setRefreshTokenExpireTime(Date refreshTokenExpireTime) {
		this.refreshTokenExpireTime = refreshTokenExpireTime;
		return this;
	}
}
