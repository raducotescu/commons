package com.cotescu.radu.commons;

import java.io.File;

/**
 * This class contains useful static methods that operate with files.
 * 
 * @author Radu Cotescu (radu@cotescu.com)
 * 
 */
public class FileUtils {
	/**
	 * Returns a file's name, without its extension.
	 * 
	 * @param fileName
	 *            a String containing the file name
	 * @return a String containing the file name without extension
	 */
	public static String getFileNameWithoutExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		return fileName.substring(0, dotIndex);
	}

	/**
	 * Returns a file's name, without its extension.
	 * 
	 * @param file
	 *            the file
	 * @return a String containing the file name without extension
	 */
	public static String getFileNameWithoutExtension(File file) {
		return getFileNameWithoutExtension(file.getName());
	}

	/**
	 * Returns a file's extension.
	 * 
	 * @param fileName
	 *            a String containing the file name
	 * @return a String containing the file's extension
	 */
	public static String getExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		return fileName.substring(dotIndex + 1, fileName.length());
	}

	/**
	 * Returns a file's extension.
	 * 
	 * @param file
	 *            the file
	 * @return a String containing the file's extension
	 */
	public static String getExtension(File file) {
		return getExtension(file.getName());
	}
}
