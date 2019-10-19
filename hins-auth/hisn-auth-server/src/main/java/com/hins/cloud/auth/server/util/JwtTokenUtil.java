package com.hins.cloud.auth.server.util;

import com.hins.cloud.auth.server.configuratiion.RSAkeyConfiguration;
import com.hins.cloud.hinsauth.common.dto.TokenResult;
import com.hins.cloud.hinsauth.common.jwt.IJWTInfo;
import com.hins.cloud.hinsauth.common.jwt.JWTHelper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * jwt token 工具类
 *
 * @Author: dqk
 * @Date: 2019/8/13 15:57
 */
@Component
public class JwtTokenUtil {
	/**
	 * access_token过期时间，单位：秒
	 */
	@Value("${jwt.user-token.access-token-expire:7200}")
	private int accessTokenExpire;
	/**
	 * refresh token过期时间15日，单位：秒
	 */
	@Value("${jwt.user-token.refresh-token-expire:1296000}")
	private int refreshTokenExpire;
	@Autowired
	private RSAkeyConfiguration rsAkeyConfiguration;

	/**
	 * 生成access token
	 *
	 * @param jwtInfo
	 * @return
	 * @throws Exception
	 */
	public TokenResult createToken(IJWTInfo jwtInfo) throws Exception {
		TokenResult result = new TokenResult();
		DateTime now = DateTime.now();
		result.setAuthTime(now.toDate())
			.setExpireTime(now.plusSeconds(accessTokenExpire).toDate())
			.setRefreshTokenExpireTime(now.plusSeconds(refreshTokenExpire).toDate())
			.setAccessToken(JWTHelper.generateToken(jwtInfo, rsAkeyConfiguration.getKeyPair().getPri(), result.getExpireTime()))
			.setRefreshToken(JWTHelper.generateToken(jwtInfo, rsAkeyConfiguration.getKeyPair().getPri(), result.getRefreshTokenExpireTime()))
		;
		return result;
	}

	/**
	 * 解析access token
	 *
	 * @param token
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public <T> IJWTInfo<T> getInfoFromToken(String token) throws Exception {
		return JWTHelper.getInfoFromToken(token, rsAkeyConfiguration.getKeyPair().getPub());
	}
}
