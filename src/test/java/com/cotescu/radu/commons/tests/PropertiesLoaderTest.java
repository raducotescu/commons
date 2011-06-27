package com.cotescu.radu.commons.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cotescu.radu.commons.PropertiesLoader;

public class PropertiesLoaderTest {

	private static final String FILE = "app.properties";

	@BeforeClass
	public static final void setUp() {
		Properties p = new Properties();
		p.setProperty("foo", "bar");
		try {
			ClassLoader cl = PropertiesLoaderTest.class.getClassLoader();
			URL url = cl.getResource(".");
			FileOutputStream fos = new FileOutputStream(url.getPath() + FILE);
			p.store(fos, null);
			fos.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@AfterClass
	public static final void tearDown() throws IOException {
		ClassLoader cl = PropertiesLoaderTest.class.getClassLoader();
		URL url = cl.getResource(".");
		File f = new File(url.getPath() + FILE);
		if (!f.exists())
			throw new IOException("The test file " + FILE
					+ " has not been properly set up!");
		boolean success = f.delete();
		if (!success)
			throw new IOException("Deletion of file " + FILE + "has failed!");
	}

	@Test
	public final void testGetPropertiesFromFile1() {
		Properties p = PropertiesLoader.getPropertiesFromFile(FILE);
		assertTrue(p.getProperty("foo").equals("bar"));
	}

	@Test
	public final void testGetPropertiesFromFile2() {
		Properties p = PropertiesLoader.getPropertiesFromFile(new File(FILE));
		assertTrue(p.getProperty("foo").equals("bar"));
	}
}
