package com.hins.cloud.hinsauth.common.rsa;

import java.io.IOException;

/**
 * RSA生成的公钥、私钥对
 *
 * @Author: dqk
 * @Date: 2019/8/12 10:33
 */
public class RSAKeyPair {
	private byte[] pub;
	private byte[] pri;

	public RSAKeyPair() {}

	/**
	 * @param pub 公钥
	 * @param pri 私钥
	 */
	public RSAKeyPair(byte[] pub, byte[] pri) {
		this.pri = pri;
		this.pub = pub;
	}

	/**
	 * @param pub 公钥
	 * @param pri 私钥
	 */
	public RSAKeyPair(String pub, String pri) {
		try {
			this.pub = RsaKeyHelper.toBytes(pub);
			;
			this.pri = RsaKeyHelper.toBytes(pri);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public byte[] getPub() {
		return pub;
	}

	public RSAKeyPair setPub(byte[] pub) {
		this.pub = pub;
		return this;
	}

	public byte[] getPri() {
		return pri;
	}

	public RSAKeyPair setPri(byte[] pri) {
		this.pri = pri;
		return this;
	}
}
