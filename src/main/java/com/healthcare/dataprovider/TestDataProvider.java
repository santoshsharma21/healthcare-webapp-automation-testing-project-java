/**
 * 
 */
package com.healthcare.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.healthcare.utilities.ExcelUtils;

/**
 * 
 */
public class TestDataProvider {

	// initialize excel utilities
	private ExcelUtils exl;

	// excel file path
	String path = System.getProperty("user.dir") + "/src/test/resources/testdata/healthcare_test_data.xlsx";

	// returns login test data
	@DataProvider(name = "valid_login_test_data")
	public String[][] getValidLoginTestData() throws IOException {

		exl = new ExcelUtils(path);
		int nrows = exl.getRowCount("valid_login_data");
		int ncells = exl.getCellCount("valid_login_data", nrows);

		String[][] data = new String[nrows][ncells];
		for (int row = 1; row <= nrows; row++) {
			for (int cell = 0; cell < ncells; cell++) {
				data[row - 1][cell] = exl.getCellData("valid_login_data", row, cell);
			}
		}

		return data;
	}

	@DataProvider(name = "invalid_login_test_data")
	public String[][] getInValidLoginTestData() throws IOException {

		exl = new ExcelUtils(path);
		int nrows = exl.getRowCount("invalid_login_data");
		int ncells = exl.getCellCount("invalid_login_data", nrows);

		String[][] data = new String[nrows][ncells];
		for (int row = 1; row <= nrows; row++) {
			for (int cell = 0; cell < ncells; cell++) {
				data[row - 1][cell] = exl.getCellData("invalid_login_data", row, cell);
			}
		}

		return data;
	}

	// returns appointment data;
	@DataProvider(name = "appointment_test_data")
	public String[][] getAppointmentTestData() throws IOException {

		exl = new ExcelUtils(path);
		int nrows = exl.getRowCount("appointment_data");
		int ncells = exl.getCellCount("appointment_data", nrows);

		String[][] data = new String[nrows][ncells];
		for (int row = 1; row <= nrows; row++) {
			for (int cell = 0; cell < ncells; cell++) {
				data[row - 1][cell] = exl.getCellData("appointment_data", row, cell);
			}
		}

		return data;
	}
	
}