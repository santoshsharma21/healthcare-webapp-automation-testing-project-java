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
public class LoginPage extends UserActions {

	// webdriver
	private WebDriver driver;

	// page objects
	@FindBy(id = "txt-username")
	private WebElement userNameTxtBox;

	@FindBy(id = "txt-password")
	private WebElement passwordTxtBox;

	@FindBy(id = "btn-login")
	private WebElement loginBtn;

	@FindBy(xpath = "//p[@class='lead text-danger']")
	private WebElement loginErrorMsg;

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page action
	public void enterUsername(String username) {
		performSendKey(userNameTxtBox, username);
	}

	public void enterPassword(String password) {
		performSendKey(passwordTxtBox, password);
	}

	public AppointmentPage clickLoginButton() {
		performClick(loginBtn);
		return new AppointmentPage(driver);
	}

	public void clickLoginBtn() {
		performClick(loginBtn);
	}

	public String getLoginPageUrl() {
		return performGetCurrentPageUrl(driver);
	}

	public String getLoginErrorMessage() {
		return performGetInnerText(loginErrorMsg);
	}
	
}