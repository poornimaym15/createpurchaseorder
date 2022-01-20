package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author POORNIMA
 *
 */

public class ExcelUtility {
	/**
	 * This method will return string value from excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	
	public String getStringCellData(String sheetname,int rowNo,int cellNo) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		return cell.getStringCellValue();
		
		
	}
	/**
	 * This method will return cell data
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	
	public double getNumericCellData(String sheetName,int rowNo,int cellNo  ) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	/**
	 * this method will return multiple set of data from excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] getMultipleData(String sheetName) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowNo = sheet.getLastRowNum();
		int cellNo = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowNo][cellNo];
		for(int i=0;i<=rowNo;i++) {
			for(int j=0;j<=cellNo;j++) {
				data[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
				
		}
	/**
	 * this method will write the data into excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 */
		public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo, String value) throws Throwable{
			
			FileInputStream readfile = new FileInputStream(IPathConstants.EXCEL_PATH);
			Workbook workbook = WorkbookFactory.create(readfile);
			workbook.createSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(value);
			
			FileOutputStream writefile = new FileOutputStream(IPathConstants.EXCEL_PATH);
			workbook.write(writefile);
			workbook.close();
			
		}
	
	

}
