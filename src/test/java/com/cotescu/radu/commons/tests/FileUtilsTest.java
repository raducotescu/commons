package com.cotescu.radu.commons.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cotescu.radu.commons.FileUtils;

public class FileUtilsTest {

	private static File file;
	private final static File NULL_FILE = null;
	private final static String NULL_STRING = null;

	@BeforeClass
	public static void setUp() {
		file = new File("test.txt");
	}

	@Test
	public final void testGetFileNameWithoutExtension1() {
		assertTrue(FileUtils.getFileNameWithoutExtension(file).equals("test"));
	}

	@Test(expected = NullPointerException.class)
	public final void testGetFileNameWithoutExtension1Null() {
		assertTrue(FileUtils.getFileNameWithoutExtension(NULL_FILE).equals(
				"test"));
	}

	@Test
	public final void testGetFileNameWithoutExtension2() {
		assertTrue(FileUtils.getFileNameWithoutExtension(file.getName())
				.equals("test"));
	}

	@Test(expected = NullPointerException.class)
	public final void testGetFileNameWithoutExtension2Null() {
		assertTrue(FileUtils.getFileNameWithoutExtension(NULL_STRING).equals(
				"test"));
	}

	@Test
	public final void testGetExtension1() {
		assertTrue(FileUtils.getExtension(file).equals("txt"));
	}

	@Test(expected = NullPointerException.class)
	public final void testGetExtension1Null() {
		assertTrue(FileUtils.getExtension(NULL_FILE).equals("txt"));
	}

	@Test
	public final void testGetExtension2() {
		assertTrue(FileUtils.getExtension(file.getName()).equals("txt"));
	}

	@Test(expected = NullPointerException.class)
	public final void testGetExtension2Null() {
		assertTrue(FileUtils.getExtension(NULL_STRING).equals("txt"));
	}
}
