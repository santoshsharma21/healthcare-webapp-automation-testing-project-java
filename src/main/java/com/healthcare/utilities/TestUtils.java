/**
 * 
 */
package com.healthcare.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 */
public class TestUtils {

	// method takes screenshot
	public static String captureScreen(WebDriver driver, String scrName) throws IOException {
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String fileName = scrName + dt;
		String scrDestPath = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";

		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File sourceImg = scrShot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(sourceImg, new File(scrDestPath));
		return scrDestPath;
	}

}