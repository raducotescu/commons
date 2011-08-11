package com.cotescu.radu.commons;

import java.io.File;
import java.io.FileInputStream;
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
	 * @throws Exception
	 *             if the file cannot be read
	 * @see Properties
	 */
	public static Properties getPropertiesFromFileInClasspath(
			String propertiesFile) throws Exception {
		Properties p = new Properties();
		ClassLoader loader = PropertiesLoader.class.getClassLoader();
		if (loader == null) {
			loader = ClassLoader.getSystemClassLoader();
		}
		URL url = loader.getResource(propertiesFile);
		try {
			if (url == null)
				throw new Exception();
			p.load(url.openStream());
		} catch (Exception e) {
			System.err.println("Could not load configuration file: "
					+ propertiesFile);
			throw e;
		}
		return p;
	}

	/**
	 * Returns the properties saved in a properties file.
	 * 
	 * @param propertiesFile
	 *            the file from which to return the properties
	 * @return a Properties object containing the read properties
	 * @throws Exception
	 *             if the file cannot be read
	 * @see Properties
	 */
	public static Properties getPropertiesFromFileInClasspath(
			File propertiesFile) throws Exception {
		return getPropertiesFromFileInClasspath(propertiesFile.getName());
	}

	/**
	 * Returns the properties saved in a properties file.
	 * 
	 * @param propertiesFile
	 *            the file from which to return the properties
	 * @return a Properties object containing the read properties
	 * @throws Exception
	 *             if the file cannot be read
	 */
	public static Properties getPropertiesFromFile(File propertiesFile)
			throws Exception {
		Properties p;
		try {
			FileInputStream fis = new FileInputStream(propertiesFile);
			p = new Properties();
			p.load(fis);
		} catch (Exception e) {
			System.err.println("Could not load configuration file: "
					+ propertiesFile);
			throw e;
		}
		return p;
	}

	/**
	 * Returns the properties saved in a properties file.
	 * 
	 * @param propertiesFile
	 *            the file from which to return the properties
	 * @return a Properties object containing the read properties
	 * @throws Exception
	 *             if the file cannot be read
	 */
	public static Properties getPropertiesFromFile(String propertiesFile)
			throws Exception {
		File f = new File(propertiesFile);
		return getPropertiesFromFile(f);
	}
}