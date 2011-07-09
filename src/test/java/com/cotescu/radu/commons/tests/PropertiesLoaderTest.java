package com.cotescu.radu.commons.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cotescu.radu.commons.PropertiesLoader;

public class PropertiesLoaderTest {

	private static final String FILE = "app.properties";
	private static File file;

	@BeforeClass
	public static final void setUp() throws IOException {
		Properties p = new Properties();
		p.setProperty("foo", "bar");
		FileChannel source = null;
		FileChannel destination = null;
		try {
			ClassLoader cl = PropertiesLoaderTest.class.getClassLoader();
			URL url = cl.getResource(".");
			FileOutputStream fos = new FileOutputStream(url.getPath() + FILE);
			p.store(fos, null);
			fos.close();
			File f = new File(url.getPath() + FILE);
			file = new File(System.getProperty("java.io.tmpdir")
					+ File.separator + FILE);
			if (!file.exists()) {
				file.createNewFile();
			}
			source = new FileInputStream(f).getChannel();
			destination = new FileOutputStream(file).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null)
				source.close();
			if (destination != null)
				destination.close();
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
		if (!file.exists())
			throw new IOException("The test file " + FILE
					+ " has not been properly set up!");
		success = file.delete();
		if (!success)
			throw new IOException("Deletion of file " + file.getCanonicalPath()
					+ "has failed!");
	}

	@Test
	public final void testGetPropertiesFromFileInClasspath() throws IOException {
		Properties p = PropertiesLoader.getPropertiesFromFileInClasspath(FILE);
		assertTrue(p.getProperty("foo").equals("bar"));
	}

	@Test
	public final void testGetPropertiesFromFile() throws IOException {
		Properties p = PropertiesLoader.getPropertiesFromFile(file);
		assertTrue(p.getProperty("foo").equals("bar"));
	}
}
