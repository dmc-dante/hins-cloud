package com.hins.cloud.hinsauth.common.jwt;

import com.hins.cloud.hinsauth.common.rsa.RSAKeyPair;
import com.hins.cloud.hinsauth.common.rsa.RsaKeyHelper;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: dqk
 * @Date: 2019/8/12 10:04
 */
//@RunWith(SpringRunner.class)
public class JWTTests {
	/**
	 * 测试运行效率
	 *
	 * @throws Exception
	 */
	//	@Test
	public void testJwtEfficiency() throws Exception {
		RSAKeyPair keyPair = RsaKeyHelper.generateKey("abcd");
		JWTInfo<String> jwtinfo = new JWTInfo<String>().setId("123456").setData("abcd");
		String token = JWTHelper.generateToken(jwtinfo, keyPair.getPri(), 60);
		long start = System.currentTimeMillis();
		System.out.println(start);
		int i = 10000;
		while (i > 0) {
			IJWTInfo<String> infoFromToken = JWTHelper.getInfoFromToken(token, keyPair.getPub());
			i--;
		}
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis() - start);
		Assert.assertTrue(true);
	}

	/**
	 * 测试是否正确
	 *
	 * @throws Exception
	 */
	//	@Test
	public void testJwt() throws Exception {
		RSAKeyPair keyPair = RsaKeyHelper.generateKey("abcd");
		JWTInfo<String> jwtinfo = new JWTInfo<String>().setId("123456").setData("abcd");
		String token = JWTHelper.generateToken(jwtinfo, keyPair.getPri(), 15);
		IJWTInfo<String> infoFromToken = JWTHelper.getInfoFromToken(token, keyPair.getPub());
		Assert.assertSame(jwtinfo.getId().intern(), infoFromToken.getId().intern());
		Assert.assertSame(jwtinfo.getData().intern(), infoFromToken.getData().intern());
	}

	/**
	 * 测试过期时间
	 *
	 * @throws Exception
	 */
	//	@Test
	public void testJwtExpire() throws Exception {
		RSAKeyPair keyPair = RsaKeyHelper.generateKey("abcd");
		JWTInfo<Integer> jwtinfo = new JWTInfo<String>().setId("123456").setData(9999);
		String token = JWTHelper.generateToken(jwtinfo, keyPair.getPri(), 5);
		IJWTInfo<Integer> infoFromToken = JWTHelper.getInfoFromToken(token, keyPair.getPub());
		Assert.assertSame(jwtinfo.getId().intern(), infoFromToken.getId().intern());
		Assert.assertTrue(jwtinfo.getData().equals(infoFromToken.getData()));
		Thread.sleep(6000);
		try {
			infoFromToken = JWTHelper.getInfoFromToken(token, keyPair.getPub());
		} catch (Exception e) {
			Assert.assertTrue(e instanceof ExpiredJwtException);
		}
	}
}
