package PurchaseorderTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateNewPurchaseorderPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.PurchaseorderPage;
/**
 * 
 * @author USER
 *
 */

public class CreatePurchaseOrderWithItemDeleteTest  extends BaseClass{
	@Test(groups= {"regressionTest"})
	

	public  void createpurchasewithItemDelete() throws Throwable  {
				
		//get data from excel sheet
		String expectedText1 = eUtil.getStringCellData("Sheet1", 1, 2);
		System.out.println(expectedText1);
		
		String expectedText2=eUtil.getStringCellData("Sheet1", 9, 2);
		System.out.println(expectedText2);
		
		String ExpectedItemName=eUtil.getStringCellData("Sheet1", 5, 2);
		System.out.println(ExpectedItemName);
		
		//mouseOver on more and clicks on purchase order link
		HomePage homepage = new HomePage(driver);
		homepage.hoverOnMore();

		//create purchase order
		HomePage homePage = new HomePage(driver);
		homePage.clickPurchaseorderLink();
		
		PurchaseorderPage  purchPage = new PurchaseorderPage(driver);
		purchPage.clickpurchaseorderImg();
		
		CreateNewPurchaseorderPage createPurchPage =new CreateNewPurchaseorderPage(driver);
		createPurchPage.getpurchaseOrderText();
		//purchase order name verification
		CreateNewPurchaseorderPage purchaseOrderpage= new CreateNewPurchaseorderPage(driver);
		String actualText1=createPurchPage.getpurchaseOrderText();
		if(actualText1.contains(expectedText1)){
			System.out.println("Purchase order has been created and verified");
		} else {
			System.out.println("Purchase order has not been created and verified");
			
		}
		
	   	//purchaseorder information
		CreateNewPurchaseorderPage subjectTextfield=new CreateNewPurchaseorderPage(driver);
		subjectTextfield.subjectText("List of products");
		
		CreateNewPurchaseorderPage exciseduty =new CreateNewPurchaseorderPage(driver);
	    exciseduty.exciseDuty("GST");
	    
	    //click on addproduct button
	    CreateNewPurchaseorderPage addproduct=new CreateNewPurchaseorderPage(driver);
	    addproduct.addproductButton();
	    
	    //add item name
	    CreateNewPurchaseorderPage itemname=new CreateNewPurchaseorderPage(driver);
	    itemname.itemname("Wheat");
	    
	    // delete added item
	    CreateNewPurchaseorderPage deleteitem=new CreateNewPurchaseorderPage(driver);
	    deleteitem.deleteItem();
	    }}
		
		
		
		
		
		
		
	
				
		