/**
 * 
 */
package com.healthcare.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 */
public class ConfigReader {

	// initialise properties
	private Properties pro;

	public ConfigReader() {
		File file = new File(System.getProperty("user.dir") + "/configurations/config.properties");

		try {
			FileInputStream fileInput = new FileInputStream(file);
			pro = new Properties();
			pro.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return pro.getProperty("url");
	}

	public String getUsername() {
		return pro.getProperty("username");
	}

	public String getPassword() {
		return pro.getProperty("password");
	}

	public String getBrowserName() {
		return pro.getProperty("browser");
	}

	public long getWaitTime() {
		return Integer.parseInt(pro.getProperty("wait_duration"));
	}
	
}