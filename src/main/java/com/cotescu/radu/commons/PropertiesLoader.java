package com.cotescu.radu.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * This class provides a Properties Loader for application properties kept in
 * various key-value configuration files.
 * 
 * @author Radu Cotescu
 * 
 */
public class PropertiesLoader {

	/**
	 * Returns the properties saved in a properties file.
	 * 
	 * @param propertiesFile
	 *            the file (as String) from which to return the properties
	 * @return a Properties object containing the read properties
	 * @throws IOException
	 *             if IO errors occur while reading the properties file
	 * @see Properties
	 */
	public static Properties getPropertiesFromFileInClasspath(
			String propertiesFile) throws IOException {
		Properties p = new Properties();
		ClassLoader loader = PropertiesLoader.class.getClassLoader();
		if (loader == null) {
			loader = ClassLoader.getSystemClassLoader();
		}
		URL url = loader.getResource(propertiesFile);
		if (url == null)
			throw new IOException("Unable to get resource from "
					+ propertiesFile);
		p.load(url.openStream());
		return p;
	}

	/**
	 * Allows to read properties saved in a file stored in different location
	 * from the classpath.
	 * 
	 * @param propertiesFile
	 *            the full path to the file from which to read the properties
	 * @return a Properties object containing the read properties
	 * @throws IOException
	 *             if IO errors occur while reading the properties file
	 * @see Properties
	 */
	public static Properties getPropertiesFromFileInClasspath(
			File propertiesFile) throws IOException {
		return getPropertiesFromFileInClasspath(propertiesFile.getName());
	}

	/**
	 * Returns the properties saved in a properties file.
	 * 
	 * @param propertiesFile
	 *            the file from which to return the properties
	 * @return a Properties object containing the read properties
	 * @throws IOException
	 *             if IO errors occur while reading the properties file
	 */
	public static Properties getPropertiesFromFile(File propertiesFile)
			throws IOException {
		Properties p;
		FileInputStream fis = new FileInputStream(propertiesFile);
		p = new Properties();
		p.load(fis);
		return p;
	}

	/**
	 * Returns the properties saved in a properties file.
	 * 
	 * @param propertiesFile
	 *            the file from which to return the properties
	 * @return a Properties object containing the read properties
	 * @throws Exception
	 *             if IO errors occur while reading the properties file
	 */
	public static Properties getPropertiesFromFile(String propertiesFile)
			throws IOException {
		File f = new File(propertiesFile);
		return getPropertiesFromFile(f);
	}
}