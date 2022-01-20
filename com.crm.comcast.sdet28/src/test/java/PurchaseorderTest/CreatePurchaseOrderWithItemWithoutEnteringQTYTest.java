package PurchaseorderTest;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import com.crm.comcast.objectRepository.PurchaseOrderInformationPage;
import com.crm.comcast.objectRepository.PurchaseorderPage;
/**
 * 
 * @author USER
 *
 */

public class CreatePurchaseOrderWithItemWithoutEnteringQTYTest extends BaseClass {
	@Test(groups= {"regressionTest"})
	//private static final String IPConstants = null;

	public  void createPurch () throws Throwable  {
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
			    
			    //click on addproduct button
			    CreateNewPurchaseorderPage addproduct=new CreateNewPurchaseorderPage(driver);
			    addproduct.addproductButton();
			    
			   //move upward
			    CreateNewPurchaseorderPage moveupward = new CreateNewPurchaseorderPage(driver);
			     moveupward.moveupwardButton();
			    
			    CreateNewPurchaseorderPage itemone=new CreateNewPurchaseorderPage(driver);
			    itemone.itemone("Rice");
			    
			   //verify whether purchase order is created or not
				CreateNewPurchaseorderPage purchaseOrderpage= new CreateNewPurchaseorderPage(driver);
			     String actualText1=purchaseOrderpage.getpurchaseOrderText();
			     
			      Assert.assertEquals(actualText1.contains(expectedText1), true);
				/*if(expectedText1.contains(actualText1)){
					System.out.println("Purchase order has been created and verified");
				} else {
					System.out.println("Purchase order has not been created and verified");
					}*/
				//verify whether item name is added or not
	            String actualText2=purchaseOrderpage.getItemInformationText();
	            Assert.assertEquals(actualText2.contains(expectedText2), true);
	            System.out.println("item name is added");
				/*if(expectedText2.contains(actualText2)){
					System.out.println("Item name has been added");
				} else {
					System.out.println("Item name has not been added");
					}*/
				Assert.assertEquals(actualText1.contains(expectedText1), true);
				Assert.assertEquals(actualText2.contains(expectedText2), true);
				}}
//verification

				
				