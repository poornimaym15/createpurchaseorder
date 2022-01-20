package PurchaseorderTest;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreatePurchaseOrderWithItemAndClickOnDownwardSymbolTest extends BaseClass{
	@Test(groups={"smokeTest","regressionTest"})
	public  void createpurchasewithitemandClickDownward() throws Throwable {
		//generate random number
		  int randomNumber = jUtil.getRandomNumber();
				
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
				
		//clicks on purchaseorderplusimage
			PurchaseorderPage purchaseorderplusimage=new PurchaseorderPage(driver);
			purchaseorderplusimage.clickpurchaseorderImg();
				
		//purchaseorder information
			CreateNewPurchaseorderPage subjectTextfield=new CreateNewPurchaseorderPage(driver);
			subjectTextfield.subjectText("List of products");
				
			CreateNewPurchaseorderPage exciseduty =new CreateNewPurchaseorderPage(driver);
			exciseduty.exciseDuty("GST");
		//purchase order is created or not
			    CreateNewPurchaseorderPage purchaseOrderpage= new CreateNewPurchaseorderPage(driver);
			    String actualText1=purchaseOrderpage.getpurchaseOrderText();
				if(expectedText1.contains(actualText1)){
					System.out.println("Purchase order has been created and verified");
				} else {
					System.out.println("Purchase order has not been created and verified");
					
				}
			    
			    //click on addproduct button
			    CreateNewPurchaseorderPage addproduct=new CreateNewPurchaseorderPage(driver);
			    addproduct.addproductButton();
			    
			    //add itemone
			    CreateNewPurchaseorderPage itemone=new CreateNewPurchaseorderPage(driver);
			    itemone.itemone("Rice");
			    
			    //click on downwardsymbol
			    CreateNewPurchaseorderPage movedownward=new CreateNewPurchaseorderPage(driver);
			    movedownward.movedownwardButton();
			    
			  //add item name
			    CreateNewPurchaseorderPage itemname=new CreateNewPurchaseorderPage(driver);
			    itemname.itemname("Wheat");
			    
			    //verify whether item name is added or not

			    String actualText2=purchaseOrderpage.getItemInformationText();
				
				if(expectedText2.contains(actualText2)){
					System.out.println("Item name has been added");
				} else {
					System.out.println("Item name has not been added");
					
				}}}
