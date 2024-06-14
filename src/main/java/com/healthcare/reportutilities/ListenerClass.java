/**
 * 
 */
package com.healthcare.reportutilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.healthcare.base.BaseClass;
import com.healthcare.utilities.TestUtils;

/**
 * 
 */
public class ListenerClass extends ReportManager implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		initialiseReporter();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.assignAuthor("SANTOSH");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				extentTest.log(Status.PASS,
						MarkupHelper.createLabel(result.getName() + " - PASSED", ExtentColor.GREEN));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String txt = result.getThrowable().getMessage().replaceAll(" ", "<br>");
			String formatedThrowable = "<details> <summary> Details </summary>" + txt + "</details>";
			try {
				String scrPath = TestUtils.captureScreen(BaseClass.driver, result.getName());
				extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(scrPath).build());
				extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - FAILED", ExtentColor.RED));
				extentTest.fail(MarkupHelper.createLabel(formatedThrowable, ExtentColor.RED));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			try {
				extentTest.log(Status.SKIP,
						MarkupHelper.createLabel(result.getName() + " - SKIPPED", ExtentColor.YELLOW));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		closeReporter();
	}
	
}