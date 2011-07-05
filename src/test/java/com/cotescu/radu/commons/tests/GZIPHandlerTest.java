package com.cotescu.radu.commons.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import com.cotescu.radu.commons.GZIPHandler;

public class GZIPHandlerTest {

	@Test
	public final void testExtract() throws IOException {
		ClassLoader loader = GZIPHandlerTest.class.getClassLoader();
		if (loader == null) {
			loader = ClassLoader.getSystemClassLoader();
		}
		String sourceArchive = loader.getResource("loremIpsum.gz").getFile();
		GZIPHandler.extract(new File(sourceArchive), "", "loremIpsum", false, false);
		File sourceFile = new File(loader.getResource("loremIpsum.test").getFile());
		File gzipFile = new File("." + File.separator + "loremIpsum");
		FileInputStream fin1 = new FileInputStream(sourceFile);
		FileInputStream fin2 = new FileInputStream(gzipFile);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fin1));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(fin2));
		String line1, line2;
		while((line1 = br1.readLine()) != null) {
			line2 = br2.readLine();
			if(!line1.equals(line2)) {
				throw new IOException("Error detected");
			}
		}
		if((line2 = br2.readLine()) != null) {
			throw new IOException("Error detected");
		}
		gzipFile.delete();
	}
}
