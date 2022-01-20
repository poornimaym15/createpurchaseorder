package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class GetTheDataFromExcelSheetTest {

	public static void main(String[] args) throws Throwable {
		//java object representation for physical excel sheet
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerTestData.xlsx");
		//create a workbook for physical excel sheet
		 Workbook workbook = WorkbookFactory.create(fis);
		 //get the control of sheet
		 Sheet sheet=workbook.getSheet("Sheet1");
		 //get the control of row
		 Row row = sheet.getRow(1);
		 //get the control of cells
		 Cell cell = row.getCell(2);
		 //fetch the value from the cell
		String orgName=cell.getStringCellValue();
		System.out.println(orgName);
		// close the workbook
		workbook.close();
		

	}

}
