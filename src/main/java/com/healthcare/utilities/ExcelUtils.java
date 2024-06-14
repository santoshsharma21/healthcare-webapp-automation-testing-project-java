/**
 * 
 */
package com.healthcare.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 */
public class ExcelUtils {

	private FileInputStream fi;
	private XSSFWorkbook wb;
	private XSSFSheet ws;
	private XSSFRow row;
	private XSSFCell cell;
	private String filePath;

	// constructor
	public ExcelUtils(String filePath) {
		this.filePath = filePath;
	}

	// method return number of rows
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		int rowNum = ws.getLastRowNum();

		wb.close();
		fi.close();

		return rowNum;
	}

	// method return number of cells in given row
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		int cellNum = row.getLastCellNum();

		wb.close();
		fi.close();

		return cellNum;
	}

	// method return cell data
	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		fi = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.getCell(cellnum);

		String cellValue = null;
		DataFormatter dformat = new DataFormatter();

		try {
			cellValue = dformat.formatCellValue(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cellValue;
	}
	
}