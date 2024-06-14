/**
 * 
 */
package com.healthcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthcare.useraction.UserActions;

/**
 * 
 */
public class AppointmentSummaryPage extends UserActions {

	// webdriver
	private WebDriver driver;

	// page objects
	@FindBy(xpath = "//p[@class='lead']")
	private WebElement confirmationTxt;

	@FindBy(xpath = "//a[text() = 'Go to Homepage']")
	private WebElement homePageBtn;

	// constructor
	public AppointmentSummaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page actions
	public HomePage clickHomePageButton() {
		performClick(homePageBtn);
		return new HomePage(driver);
	}

	public String getAppointmentConfirmationMsg() {
		return performGetInnerText(confirmationTxt);
	}
	
}