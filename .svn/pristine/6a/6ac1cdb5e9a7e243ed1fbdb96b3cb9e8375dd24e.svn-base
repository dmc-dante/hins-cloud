package com.hins.cloud.auth.server.configuratiion;

import com.hins.cloud.hinsauth.common.rsa.RSAKeyPair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: dqk
 * @Date: 2019/8/12 18:00
 */
@Configuration
public class RSAkeyConfiguration {
	/**
	 * 私钥
	 */
	@Value("${jwt.user-token.rsa-private-key}")
	private String privateKey;
	/**
	 * 公钥
	 */
	@Value("${jwt.user-token.rsa-public-key}")
	private String publicKey;
	/**
	 * 秘钥对
	 */
	private RSAKeyPair keyPair;

	public String getPrivateKey() {
		return privateKey;
	}

	public RSAkeyConfiguration setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
		return this;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public RSAkeyConfiguration setPublicKey(String publicKey) {
		this.publicKey = publicKey;
		return this;
	}

	/**
	 * 获取rsa秘钥对
	 *
	 * @return
	 */
	public RSAKeyPair getKeyPair() {
		if (this.privateKey == null || this.publicKey == null) {
			return null;
		}
		if (keyPair == null) {
			this.keyPair = new RSAKeyPair(this.publicKey, this.privateKey);
		}
		return this.keyPair;
	}
}
