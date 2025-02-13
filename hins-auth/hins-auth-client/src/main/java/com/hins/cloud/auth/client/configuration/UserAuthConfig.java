package com.hins.cloud.auth.client.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * 用户token配置
 */
@Configuration
public class UserAuthConfig {
	private String tokenHeader;
	private byte[] pubKeyByte;

	public String getTokenHeader() {
		return tokenHeader;
	}

	public UserAuthConfig setTokenHeader(String tokenHeader) {
		this.tokenHeader = tokenHeader;
		return this;
	}

	public byte[] getPubKeyByte() {
		return pubKeyByte;
	}

	public UserAuthConfig setPubKeyByte(byte[] pubKeyByte) {
		this.pubKeyByte = pubKeyByte;
		return this;
	}
}
