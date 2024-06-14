/**
 * 
 */
package com.healthcare.useraction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.healthcare.useractioninterface.UserActionInterface;
import com.healthcare.utilities.ConfigReader;

/**
 * 
 */
public class UserActions implements UserActionInterface {

	// webdriver
	// private WebDriver driver;

	// webdriver wait
	public WebDriverWait wait;
	private ConfigReader cfg = new ConfigReader();

	// constructor
	public UserActions(WebDriver driver) {
		// this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(cfg.getWaitTime()));
	}

	@Override
	public void performClick(WebElement element) {
		boolean flag = false;
		try {
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
			ele.click();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("successfully clicked on element - " + element);
			} else {
				System.out.println("unable to click on element - " + element);
			}
		}
	}

	@Override
	public void performSendKey(WebElement element, String key) {
		boolean flag = false;
		try {
			WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
			ele.click();
			ele.clear();
			ele.sendKeys(key);
			flag = true;
			;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("successfully entered value");
			} else {
				System.out.println("unable to enter value");
			}
		}
	}

	@Override
	public void performSelectByVisibleText(WebElement element, String value) {
		boolean flag = false;
		try {
			WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
			Select drpDwn = new Select(ele);
			drpDwn.selectByVisibleText(value);
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println(value + " - selected from drop down");
			} else {
				System.out.println(value + " - unable to select from drop down");
			}
		}

	}

	@Override
	public void performSelectFromOption(List<WebElement> elements, String key) {
		boolean flag = false;
		try {
			List<WebElement> eles = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			for (WebElement ele : eles) {
				if (ele.getText().equalsIgnoreCase(key)) {
					ele.click();
					break;
				}
			}
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println(key + " - is selected");
			} else {
				System.out.println(key + " - unable to select");
			}
		}

	}

	@Override
	public String performGetInnerText(WebElement element) {
		String text = null;
		try {
			text = element.getText();
			System.out.println("Inner text is: \"" + text + "\"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	@Override
	public String performGetCurrentPageUrl(WebDriver driver) {
		String url = null;
		try {
			url = driver.getCurrentUrl();
			System.out.println("Current URL is: \"" + url + "\"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}