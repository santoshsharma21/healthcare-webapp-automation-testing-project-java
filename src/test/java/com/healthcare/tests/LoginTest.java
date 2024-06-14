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
import com.healthcare.pages.HomePage;
import com.healthcare.pages.LoginPage;

/**
 * 
 */
public class LoginTest extends BaseClass {

	// instance of pages
	private HomePage homePage;
	private LoginPage loginPage;
	private AppointmentPage appointmentPage;

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		initialiseBrowser(browser);
	}

	@AfterMethod
	public void afterMethod() {
		quitBrowser();
	}

	@Test(priority = 0, dataProvider = "valid_login_test_data", dataProviderClass = TestDataProvider.class)
	public void loginTestWithValidData(String username, String password, String expectedUrl) {
		homePage = new HomePage(driver);
		homePage.clickMenu();
		loginPage = homePage.clickLoginOption();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		appointmentPage = loginPage.clickLoginButton();

		String actualUrl = appointmentPage.performGetCurrentPageUrl(driver);
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 1, dataProvider = "invalid_login_test_data", dataProviderClass = TestDataProvider.class)
	public void loginTestWithInValidData(String username, String password, String expectedErrorMsg) {
		homePage = new HomePage(driver);
		homePage.clickMenu();
		loginPage = homePage.clickLoginOption();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();

		String actualErrorMsg = loginPage.getLoginErrorMessage();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

}