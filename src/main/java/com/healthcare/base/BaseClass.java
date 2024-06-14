/**
 * 
 */
package com.healthcare.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.healthcare.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Santosh Sharma base class will initialize webdriver
 */
public class BaseClass {

	// initialise driver
	public static WebDriver driver;

	// create instance of config reader
	private ConfigReader cfg;

	public void initialiseBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// maximize window
		driver.manage().window().maximize();

		// delete cookies
		driver.manage().deleteAllCookies();

		// launch url
		cfg = new ConfigReader();
		driver.get(cfg.getUrl());
	}

	public void quitBrowser() {
		driver.quit();
	}

}
