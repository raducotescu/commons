package com.cotescu.radu.commons.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Test;

import com.cotescu.radu.commons.Downloader;

public class DownloaderTest {

	private static File file;

	@Test
	public final void testDownloadFileFromURLExceptionNotRaised()
			throws Exception {
		assertNotNull((file = Downloader.downloadFileFromURL(
				"http://radu.cotescu.com/", null)));
	}

	@Test(expected = FileNotFoundException.class)
	public final void testDownloadFileFromURLFileNotFoundException()
			throws Exception {
		assertNull(Downloader.downloadFileFromURL("http://radu.cotescu.com/nothinghere",
				null));
	}

	@Test(expected = MalformedURLException.class)
	public final void testDownloadFileFromURLMalformedURLException()
			throws Exception {
		assertNull(Downloader.downloadFileFromURL("noprotocol://radu.cotescu.com", null));
	}

	@Test(expected = IOException.class)
	public final void testDownloadFileFromURLIOException()
			throws Exception {
		String root = null;
		try {
			root = File.listRoots()[0].getCanonicalPath();
		} catch (IOException e) {
			System.err.println("Unable to find root filesystem.");
		}
		assertNull(Downloader.downloadFileFromURL("http://radu.cotescu.com", root));
	}

	@After
	public final void tearDown() {
		if (file.exists()) {
			file.delete();
		}
	}
}
