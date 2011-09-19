package com.cotescu.radu.commons;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

/**
 * This class provides several useful methods for hashing Strings.
 * 
 * @author Radu Cotescu (radu@cotescu.com)
 * 
 */
public class HashUtils {

	private static final int ITER = 1000;

	/**
	 * This method hashes a string according to the desired message digest
	 * algorithm.
	 * 
	 * @param input
	 *            the String to be hashed
	 * @param algorithm
	 *            the message digest algorithm that is used; one of MD5, SHA-1,
	 *            SHA-256, SHA-512
	 * @return a String containing the hashed input
	 * @throws UnsupportedEncodingException
	 *             thrown only if UTF-8 is not supported (not likely)
	 * @throws NoSuchAlgorithmException
	 *             thrown only if the algorithm requested for hashing isn't
	 *             implemented by the JCA (Java Cryptography Architecture)
	 */
	public static String getHash(String input, String algorithm)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance(algorithm);
		m.reset();
		m.update(input.getBytes("UTF-8"));
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hash = bigInt.toString(16);
		return hash;
	}

	/**
	 * This method hashes a string according to the desired message digest
	 * algorithm. The hash is salted and run multiple times.
	 * 
	 * @param input
	 *            the String to be hashed
	 * @param algorithm
	 *            the message digest algorithm that is used; one of MD5, SHA-1,
	 *            SHA-256, SHA-512
	 * @param salt
	 *            a String to be used as a salt value
	 * @return a String containing the hashed input
	 * @throws UnsupportedEncodingException
	 *             thrown only if UTF-8 is not supported (not likely)
	 * @throws NoSuchAlgorithmException
	 *             thrown only if the algorithm requested for hashing isn't
	 *             implemented by the JCA (Java Cryptography Architecture)
	 */
	public static String getHashWithSalt(String input, String algorithm,
			String salt) throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.reset();
		digest.update(salt.getBytes("UTF-8"));
		byte[] bytes = digest.digest(input.getBytes("UTF-8"));
		for (int i = 0; i < ITER; i++) {
			digest.reset();
			bytes = digest.digest(bytes);
		}
		//return Base64.encodeBase64String(bytes);
		return new BigInteger(1, bytes).toString(16);
	}
}
