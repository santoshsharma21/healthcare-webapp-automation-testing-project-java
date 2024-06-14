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
public class HomePage extends UserActions {

	// webdriver
	private WebDriver driver;

	// page objects
	@FindBy(id = "menu-toggle")
	private WebElement menuToggleBtn;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginOption;

	@FindBy(xpath = "//a[normalize-space()='Home']")
	private WebElement homeOption;

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page action
	public void clickMenu() {
		performClick(menuToggleBtn);
	}

	public LoginPage clickLoginOption() {
		performClick(loginOption);
		return new LoginPage(driver);
	}

	public HomePage clickHomeOption() {
		performClick(homeOption);
		return new HomePage(driver);
	}

}