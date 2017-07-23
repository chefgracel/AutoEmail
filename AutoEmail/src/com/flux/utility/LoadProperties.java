package com.flux.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	static {
		try {
			loadProperties();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Properties OR;
	static Properties prop;

	private static void loadProperties() throws FileNotFoundException {
		prop = new Properties();
		// Declaring String variable for storing Object Repository path
		String Path_OR = Constant.Path_OR;
		// Creating file system object for Object Repository text/property file
		FileInputStream fs;

		fs = new FileInputStream(Path_OR);
		// Creating an Object of properties
		OR = new Properties(System.getProperties());
		// Loading all the properties from Object Repository property file in to
		// OR object
		try {
			OR.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Properties getProp(){
		return OR;
	}
}
