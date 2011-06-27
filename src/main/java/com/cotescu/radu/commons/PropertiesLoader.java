package com.cotescu.radu.commons;

import java.io.File;
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
	 * @see Properties
	 */
	public static Properties getPropertiesFromFile(String propertiesFile) {
		Properties p = new Properties();
		ClassLoader loader = PropertiesLoader.class.getClassLoader();
		if (loader == null) {
			loader = ClassLoader.getSystemClassLoader();
		}
		URL url = loader.getResource(propertiesFile);
		try {
			p.load(url.openStream());
		} catch (IOException e) {
			System.err.println("Could not load configuration file: "
					+ propertiesFile);
		}
		return p;
	}

	/**
	 * Returns the properties saved in a properties file.
	 * 
	 * @param propertiesFile
	 *            the file from which to return the properties
	 * @return a Properties object containing the read properties
	 * @see Properties
	 */
	public static Properties getPropertiesFromFile(File propertiesFile) {
		return getPropertiesFromFile(propertiesFile.getName());
	}
}