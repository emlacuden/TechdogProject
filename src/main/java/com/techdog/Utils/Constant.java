package com.techdog.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constant {
	public static String getConstant(String key) {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = Constant.class.getClassLoader().getResourceAsStream("config.properties");
			//System.out.println(input==null);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}
}
