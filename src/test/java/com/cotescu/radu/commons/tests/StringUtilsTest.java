package com.cotescu.radu.commons.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cotescu.radu.commons.StringUtils;

public class StringUtilsTest {
	
	private static final String EMPTY_STRING = "";
	private static final String NULL_STRING = null;
	private static String spaceString;
	private static String a;
	private static String aa;
	private static String bab;
	private static String ba;
	
	@BeforeClass
	public static void setUp() {
		spaceString = " ";
		a = "a";
		aa = "aa";
		bab = "bab";
		ba = "ba";	
	}

	@Test
	public final void testIsEmpty() {
		assertTrue(StringUtils.isEmpty(EMPTY_STRING));
		assertTrue(StringUtils.isEmpty(NULL_STRING));
		assertFalse(StringUtils.isEmpty(spaceString));
	}
	
	@Test
	public final void testIsSubstring() {
		assertTrue(StringUtils.isSubstring(aa, a));
		assertTrue(StringUtils.isSubstring(bab, a));
		assertFalse(StringUtils.isSubstring(aa, ba));
		assertFalse(StringUtils.isSubstring(a, aa));
		assertFalse(StringUtils.isSubstring(a, NULL_STRING));
	}
	
	@Test
	public final void testGetReversedString() {
		assertTrue(StringUtils.getReversedString(a).equals(a));
		assertTrue(StringUtils.getReversedString(ba).equals("ab"));
		assertTrue(StringUtils.getReversedString(NULL_STRING) == null);
	}

}
