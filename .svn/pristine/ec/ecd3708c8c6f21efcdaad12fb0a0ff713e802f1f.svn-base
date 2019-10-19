package com.hins.cloud.hinsauth.common.jwt;

import com.hins.cloud.hinsauth.common.rsa.RsaKeyHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * JWT 工具类，使用RAS算法
 */
public class JWTHelper {
	/**
	 * 保存claim data信息的key
	 */
	public final static String DATA_KEY = "data";
	private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

	/**
	 * RSA密钥加密token
	 *
	 * @param jwtInfo
	 * @param priKeyPath rsa秘钥文件路径
	 * @param expire
	 * @return
	 * @throws Exception
	 */
	public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
		return generateToken(jwtInfo, rsaKeyHelper.getBytesByFile(priKeyPath), expire
		);
	}

	/**
	 * rsa密钥加密token
	 *
	 * @param jwtInfo
	 * @param priKey  rsa秘钥
	 * @param expire  过期时间，单位：秒
	 * @return
	 * @throws Exception
	 */
	public static String generateToken(IJWTInfo jwtInfo, byte priKey[], int expire) throws Exception {
		return generateToken(jwtInfo, priKey, DateTime.now().plusSeconds(expire).toDate());
	}

	/**
	 * rsa密钥加密token
	 *
	 * @param jwtInfo
	 * @param priKey     rsa秘钥
	 * @param expiration 实际到期时间点
	 * @return
	 * @throws Exception
	 */
	public static String generateToken(IJWTInfo jwtInfo, byte priKey[], Date expiration) throws Exception {
		return Jwts.builder()
			.setSubject(jwtInfo.getId())
			.claim("data", jwtInfo.getData())
			.setExpiration(expiration)
			.signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
			.compact();
	}

	/**
	 * rsa公钥解析token
	 *
	 * @param token
	 * @param pubKeyPath rsa公钥文件路径
	 * @return
	 * @throws Exception
	 */
	public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
		return claimsJws;
	}

	/**
	 * rsa公钥解析token
	 *
	 * @param token
	 * @param pubKey rsa公钥
	 * @return
	 * @throws Exception
	 */
	public static Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
		return claimsJws;
	}

	/**
	 * 获取token中的用户信息
	 *
	 * @param token
	 * @param pubKeyPath rsa 公钥文件路径
	 * @return
	 * @throws Exception
	 */
	public static <T> IJWTInfo<T> getInfoFromToken(String token, String pubKeyPath) throws Exception {
		Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
		Claims body = claimsJws.getBody();
		return new JWTInfo(body.getSubject(), body.get(DATA_KEY));
	}

	/**
	 * 获取token中的用户信息
	 *
	 * @param token
	 * @param pubKey rsa 公钥
	 * @return
	 * @throws Exception
	 */
	public static <T> IJWTInfo<T> getInfoFromToken(String token, byte[] pubKey) throws Exception {
		Jws<Claims> claimsJws = parserToken(token, pubKey);
		Claims body = claimsJws.getBody();
		return new JWTInfo(body.getSubject(), body.get(DATA_KEY));
	}
}
