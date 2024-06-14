/**
 * 
 */
package com.healthcare.reportutilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.healthcare.utilities.ConfigReader;

/**
 * @author Santosh Sharma
 * 
 */
public class ReportManager {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	private ConfigReader cfg = new ConfigReader();

	public void initialiseReporter() {
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String fileName = "Test-Report_" + dt;
		String destPath = System.getProperty("user.dir") + "/test-report/" + fileName + ".html";

		sparkReporter = new ExtentSparkReporter(destPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Test Execution Results");

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Project Name", "Health Care Web-Application Automation Testing");
		extentReports.setSystemInfo("Url", cfg.getUrl());
		extentReports.setSystemInfo("Windows", System.getProperty("os.version"));
		extentReports.setSystemInfo("Java", System.getProperty("java.version"));
	}

	public void closeReporter() {
		extentReports.flush();
	}
	
}