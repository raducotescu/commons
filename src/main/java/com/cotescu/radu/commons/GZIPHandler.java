package com.cotescu.radu.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/**
 * Class providing static methods for extracting GZIP compressed text files.
 * @author Radu Cotescu
 * 
 */
public class GZIPHandler {
	private static final int BUFFER_SIZE = 2048;

	/**
	 * This method extracts a GZIP compressed text file.
	 * @param gzipArchive the File representing the GZIP archive
	 * @param where the folder where the file should be extracted
	 * @param fileName the desired file name for the extracted file
	 * @param shouldAppend flag that sets if the extraction should add the extracted contents to an already existing file with the same name as the desired file name
	 * @param shouldDeleteArchive flag that sets if the archive should be deleted after a successful extraction
	 * @throws IOException if any I/O error is detected
	 */
	public static void extract(File gzipArchive, String where, String fileName,
			boolean shouldAppend, boolean shouldDeleteArchive) throws IOException {
		String to = new File("." + File.separator).getCanonicalPath();
		if (StringUtils.isEmpty(where)) {
			where = to;
		}
		if (!where.endsWith(File.separator)) {
			where = where + File.separator;
		}
		File outputFile = new File(where
				+ fileName);
		FileInputStream fis = new FileInputStream(gzipArchive);
		GZIPInputStream gis = new GZIPInputStream(fis);
		InputStreamReader isr = new InputStreamReader(gis);
		FileWriter fw = new FileWriter(outputFile, shouldAppend);
		char[] charBuffer = new char[BUFFER_SIZE];
		int read;
		while((read = isr.read(charBuffer)) != -1) {
			fw.write(charBuffer, 0, read);
		}
		fw.flush();
		gzipArchive.delete();
	}
}
