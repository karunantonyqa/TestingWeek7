package com.qa.ApacheTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;


public class ExcelUtils {
	
	private static XSSFSheet excelWSheet;
	
	private static XSSFWorkbook excelWBook;
	
	private static XSSFCell cell;
	
	private static XSSFRow row;
	
	public static void setExcelFile(String path, int sheetIndex) throws IOException {
		FileInputStream excelFile = new FileInputStream(path);
		
		excelWBook = new XSSFWorkbook(excelFile);
		
		excelWSheet = excelWBook.getSheetAt(sheetIndex);
	}
	
	public static void setCellData(String result, int rowNum, int colNum) throws IOException {
		row = excelWSheet.getRow(rowNum);
		cell = row.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
		
		if(cell == null) {
			cell = row.createCell(colNum);
			cell.setCellValue(result);
		}else {
			cell.setCellValue(result);
		}
		
		FileOutputStream fileOut = new FileOutputStream(Constants.pathTestData + Constants.fileTestDataName);
		excelWBook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

}
