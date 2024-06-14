/**
 * 
 */
package com.healthcare.useractioninterface;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Santosh Sharma class contains user actions abstract interface
 */
public interface UserActionInterface {

	// click action
	public void performClick(WebElement element);

	// sendKeys action
	public void performSendKey(WebElement element, String key);

	// drop-down action
	public void performSelectByVisibleText(WebElement element, String vlaue);

	// select value from list
	public void performSelectFromOption(List<WebElement> elements, String key);

	// return text from element
	public String performGetInnerText(WebElement element);

	// return current page url
	public String performGetCurrentPageUrl(WebDriver driver);
	
}