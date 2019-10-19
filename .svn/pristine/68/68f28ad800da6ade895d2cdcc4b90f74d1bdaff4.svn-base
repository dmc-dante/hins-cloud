package com.hins.cloud.auth.server.configuratiion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 用户授权配置
 */
@Configuration
public class UserConfiguration {
	public String getUserTokenHeader() {
		return userTokenHeader;
	}

	public UserConfiguration setUserTokenHeader(String userTokenHeader) {
		this.userTokenHeader = userTokenHeader;
		return this;
	}

	@Value("${jwt.user-token.token-header:Authorization}")
	private String userTokenHeader;
}
