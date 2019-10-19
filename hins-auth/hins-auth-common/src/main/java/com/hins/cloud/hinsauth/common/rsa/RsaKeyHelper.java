package com.hins.cloud.hinsauth.common.rsa;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by ace on 2017/9/10.
 */
public class RsaKeyHelper {
	/**
	 * 从文件中读取字节数据
	 *
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public byte[] getBytesByFile(String filename) throws IOException {
		DataInputStream dis = null;
		try {
			InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
			dis = new DataInputStream(resourceAsStream);
			byte[] keyBytes = new byte[resourceAsStream.available()];
			dis.readFully(keyBytes);
			return keyBytes;
		} finally {
			if (dis != null)
				dis.close();
		}
	}

	/**
	 * 获取公钥
	 *
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public PublicKey getPublicKey(String filename) throws Exception {
		return getPublicKey(getBytesByFile(filename));
	}

	/**
	 * 获取密钥
	 *
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public PrivateKey getPrivateKey(String filename) throws Exception {
		return getPrivateKey(getBytesByFile(filename));
	}

	/**
	 * 获取公钥
	 *
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public PublicKey getPublicKey(byte[] publicKey) throws Exception {
		X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	/**
	 * 获取密钥
	 *
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public PrivateKey getPrivateKey(byte[] privateKey) throws Exception {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	/**
	 * 生存rsa公钥和密钥
	 *
	 * @param publicKeyFilename
	 * @param privateKeyFilename
	 * @param password
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public void generateKey(String publicKeyFilename, String privateKeyFilename, String password) throws IOException, NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		SecureRandom secureRandom = new SecureRandom(password.getBytes());
		keyPairGenerator.initialize(2048, secureRandom);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
		FileOutputStream fos = new FileOutputStream(publicKeyFilename);
		fos.write(publicKeyBytes);
		fos.close();
		byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
		fos = new FileOutputStream(privateKeyFilename);
		fos.write(privateKeyBytes);
		fos.close();
	}

	/**
	 * 生存rsa公钥
	 *
	 * @param password
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] generatePublicKey(String password) throws IOException, NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		SecureRandom secureRandom = new SecureRandom(password.getBytes());
		keyPairGenerator.initialize(2048, secureRandom);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		return keyPair.getPublic().getEncoded();
	}

	/**
	 * 生存rsa公钥
	 *
	 * @param password
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] generatePrivateKey(String password) throws IOException, NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		SecureRandom secureRandom = new SecureRandom(password.getBytes());
		keyPairGenerator.initialize(2048, secureRandom);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		return keyPair.getPrivate().getEncoded();
	}

	public static RSAKeyPair generateKey(String password) throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		SecureRandom secureRandom = new SecureRandom(password.getBytes());
		keyPairGenerator.initialize(2048, secureRandom);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		return new RSAKeyPair(keyPair.getPublic().getEncoded(), keyPair.getPrivate().getEncoded());
	}

	public static String toHexString(byte[] b) {
		return (new BASE64Encoder()).encodeBuffer(b);
	}

	public static final byte[] toBytes(String s) throws IOException {
		return (new BASE64Decoder()).decodeBuffer(s);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		SecureRandom secureRandom = new SecureRandom("123".getBytes());
		keyPairGenerator.initialize(2048, secureRandom);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		String pub = toHexString(keyPair.getPublic().getEncoded());
		System.out.println(pub);
		String pri = toHexString(keyPair.getPrivate().getEncoded());
		System.out.println(pri);
	}
}

