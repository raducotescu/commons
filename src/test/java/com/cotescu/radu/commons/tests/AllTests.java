package com.cotescu.radu.commons.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	FileUtilsTest.class,
	HashUtilsTest.class,
	PropertiesLoaderTest.class,
	StringUtilsTest.class
	})
public class AllTests {
}
