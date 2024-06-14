/**
 * 
 */
package com.healthcare.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.healthcare.base.BaseClass;
import com.healthcare.dataprovider.TestDataProvider;
import com.healthcare.pages.AppointmentPage;
import com.healthcare.pages.AppointmentSummaryPage;
import com.healthcare.pages.HomePage;
import com.healthcare.pages.LoginPage;
import com.healthcare.utilities.ConfigReader;

/**
 * 
 */
public class AppointmentTest extends BaseClass {

	// instance of pages
	private HomePage homePage;
	private LoginPage loginPage;
	private AppointmentPage appointmentPage;
	private AppointmentSummaryPage appointmentSummaryPage;
	private ConfigReader cfg;

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		initialiseBrowser(browser);
	}

	@AfterMethod
	public void afterMethod() {
		quitBrowser();
	}

	@Test(dataProvider = "appointment_test_data", dataProviderClass = TestDataProvider.class)
	public void bookAppointmentTest(String facility, String hlth_program, String visit_date, String comment,
			String expectedMsg) {
		
		cfg = new ConfigReader();
		homePage = new HomePage(driver);
		homePage.clickMenu();
		loginPage = homePage.clickLoginOption();
		loginPage.enterUsername(cfg.getUsername());
		loginPage.enterPassword(cfg.getPassword());
		appointmentPage = loginPage.clickLoginButton();
		appointmentPage.selectMedicalFacility(facility);
		appointmentPage.selectHealthCareProgram(hlth_program);
		appointmentPage.enterVisitDate(visit_date);
		appointmentPage.addComment(comment);
		appointmentSummaryPage = appointmentPage.clickBookAppointmentButton();

		String actualMsg = appointmentSummaryPage.getAppointmentConfirmationMsg();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
}