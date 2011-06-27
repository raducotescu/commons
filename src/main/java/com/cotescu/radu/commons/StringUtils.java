package com.cotescu.radu.commons;

/**
 * This class provides useful static methods that operate on Strings. All
 * methods are null safe.
 * 
 * @author Radu Cotescu (radu@cotescu.com)
 * 
 */
public class StringUtils {

	/**
	 * Tests if a String is empty. A String is considered to be empty if it
	 * contains the "" string (empty string) or if it is null.
	 * 
	 * @param arg
	 *            a String to be checked
	 * @return a boolean value indicating the evaluation's result
	 */
	public static boolean isEmpty(String arg) {
		return (arg == null || arg.equals("")) ? true : false;
	}

	/**
	 * Tests if a String is a substring of another String.
	 * 
	 * @param fullString
	 *            the String into which the search is performed
	 * @param testString
	 *            the String to be analysed if it's a substring
	 * @return a boolean values indication the evaluation's result
	 */
	public static boolean isSubstring(String fullString, String testString) {
		if(fullString == null || testString == null)
			return false;
		if (fullString.indexOf(testString) == -1)
			return false;
		return true;
	}

	/**
	 * Returns the reversed String form of the input.
	 * 
	 * @param arg
	 *            the String to be reversed
	 * @return a String containing the initial argument, but reversed
	 */
	public static String getReversedString(String arg) {
		if(arg == null)
			return null;
		StringBuffer sb = new StringBuffer();
		for (int i = arg.length() - 1; i > -1; i--) {
			sb.append(arg.charAt(i));
		}
		return sb.toString();
	}
}
