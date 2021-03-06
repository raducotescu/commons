package com.cotescu.radu.commons.tests;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.cotescu.radu.commons.HashUtils;

public class HashUtilsTest {
	private static final String HASH_INPUT = "fox";
	private static final String SALT = "salt";

	@Test(expected = NoSuchAlgorithmException.class)
	public void testGetHashForceException()
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		assertEquals("2b95d1f09b8b66c5c43622a4d9ec9a04",
				HashUtils.getHash(HASH_INPUT, "DUMMY"));
	}

	@Test
	public void testGetHashMD5() throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		assertEquals("2b95d1f09b8b66c5c43622a4d9ec9a04",
				HashUtils.getHash(HASH_INPUT, "MD5"));
	}

	@Test
	public void testGetHashSHA1() throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		assertEquals("ff0f0a8b656f0b44c26933acd2e367b6c1211290",
				HashUtils.getHash(HASH_INPUT, "SHA-1"));
	}

	@Test
	public void testGetHashSHA256() throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		assertEquals(
				"776cb326ab0cd5f0a974c1b9606044d8485201f2db19cf8e3749bdee5f36e200",
				HashUtils.getHash(HASH_INPUT, "SHA-256"));
	}

	@Test
	public void testGetHashSHA512() throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		assertEquals(
				"42ecdff1f034c36669c6541339bb52a7fcebac730df0c4d13b435f8d9d5b16866cfe3bd113081ab31b1a9202ece0a0a5df1e2377711746351e27a345fc4898d1",
				HashUtils.getHash(HASH_INPUT, "SHA-512"));
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void testGetHashWithSaltForceException()
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		assertEquals("2b95d1f09b8b66c5c43622a4d9ec9a04",
				HashUtils.getHashWithSalt(HASH_INPUT, "DUMMY", SALT));
	}

	@Test
	public void testGetHashMD5WithSalt() throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		assertEquals("90a580cc0698c00210bf5ad5aac6b230",
				HashUtils.getHashWithSalt(HASH_INPUT, "MD5", SALT));
	}

	@Test
	public void testGetHashSHA1WithSalt() throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		assertEquals("69b9e924f02691a3eb5c23f0d2c6de64b37c74c0",
				HashUtils.getHashWithSalt(HASH_INPUT, "SHA-1", SALT));
	}

	@Test
	public void testGetHashSHA256WithSalt()
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		assertEquals("3259e2a2c24390b8ad46ead293cb5f96b3a6e052f6583da383861ed86599cc4",
				HashUtils.getHashWithSalt(HASH_INPUT, "SHA-256", SALT));
	}

	@Test
	public void testGetHashSHA512WithSalt()
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		assertEquals(
				"381634b20f3cfe7732fd14c0df79271494577cbdf564b901ec61495ded840517f61d64846baea55eff9f547e78d526697b2e131a9e50ff0c69ebb0b5cce61f42",
				HashUtils.getHashWithSalt(HASH_INPUT, "SHA-512", SALT));
	}

}
