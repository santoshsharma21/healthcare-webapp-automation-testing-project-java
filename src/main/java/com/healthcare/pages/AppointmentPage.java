/**
 * 
 */
package com.healthcare.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthcare.useraction.UserActions;

/**
 * 
 */
public class AppointmentPage extends UserActions {

	// webdriver
	private WebDriver driver;

	// page objects
	@FindBy(id = "combo_facility")
	private WebElement facilityOptions;

	@FindBy(id = "chk_hospotal_readmission")
	private WebElement hospitalReadmissionChkBox;

	@FindBy(xpath = "//div[@class='col-sm-4']//label/input")
	private List<WebElement> healthcarePrograms;

	@FindBy(id = "txt_visit_date")
	private WebElement visitDateTxtBox;

	@FindBy(id = "txt_comment")
	private WebElement commentTxtBox;

	@FindBy(id = "btn-book-appointment")
	private WebElement bookAppointmentBtn;

	// constructor
	public AppointmentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page actions
	public void selectMedicalFacility(String facilityName) {
		performSelectByVisibleText(facilityOptions, facilityName);
	}

	public void clickHospitalReaddmission() {
		performClick(hospitalReadmissionChkBox);
	}

	public void selectHealthCareProgram(String programName) {
		performSelectFromOption(healthcarePrograms, programName);
	}

	public void enterVisitDate(String date) {
		performSendKey(visitDateTxtBox, date);
	}

	public void addComment(String comment) {
		performSendKey(commentTxtBox, comment);
	}

	public AppointmentSummaryPage clickBookAppointmentButton() {
		performClick(bookAppointmentBtn);
		return new AppointmentSummaryPage(driver);
	}

	public String getAppointmentPageUrl() {
		return performGetCurrentPageUrl(driver);
	}
	
}