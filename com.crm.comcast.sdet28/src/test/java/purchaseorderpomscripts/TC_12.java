package purchaseorderpomscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateNewPurchaseorderPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.PurchaseorderPage;

public class TC_12 {
	private static final String IPConstants = null;

	public static void main(String[] args) throws Throwable  {
		//create object for utilities
		
				FileUtility fUtil = new FileUtility();
				JavaUtility jUtil = new JavaUtility();
				ExcelUtility eUtil =new ExcelUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				
				//Get the data from property file
			    String url = fUtil.getPropertyFileData("url");
				String username = fUtil.getPropertyFileData("username");
				String password=fUtil.getPropertyFileData("password");
				String browserName=fUtil.getPropertyFileData("browser");
				
				//generate random number
				int randomNumber = jUtil.getRandomNumber();
				
				//get data from excel sheet
				String expectedText1 = eUtil.getStringCellData("Sheet1", 1, 2);
				System.out.println(expectedText1);
				
				String expectedText2=eUtil.getStringCellData("Sheet1", 9, 2);
				System.out.println(expectedText2);
				
				String ExpectedItemName=eUtil.getStringCellData("Sheet1", 5, 2);
				System.out.println(ExpectedItemName);
				
				
				// how to use browser value and launch the browser
				WebDriver driver=null;
				if(browserName.equalsIgnoreCase("chrome")) {
					System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH);
					driver=new ChromeDriver();
					
				}else if(browserName.equals("firefox")) {
					System.setProperty(IPathConstants.FIREFOX_KEY, IPathConstants.FIREFOX_PATH);
					driver=new FirefoxDriver();
				}else {
					System.out.println("browser is not supported");
				}
				
				driver.manage().window().maximize();
				wUtil.waitForPageLoad(driver);
				driver.get(url);
				//login to application
				LoginPage login = new LoginPage(driver);
				login.loginToApplication(username, password);
			    
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
			    
			   //move upword
			    CreateNewPurchaseorderPage moveupward = new CreateNewPurchaseorderPage(driver);
			     moveupward.moveupwardButton();
			    
			    CreateNewPurchaseorderPage itemone=new CreateNewPurchaseorderPage(driver);
			    itemone.itemone("Rice");
			    
			   //verify whether purchase order is created or not
				
				 CreateNewPurchaseorderPage purchaseOrderpage= new CreateNewPurchaseorderPage(driver);
			    
			    String actualText1=purchaseOrderpage.getpurchaseOrderText();
				if(expectedText1.contains(actualText1)){
					System.out.println("Purchase order has been created and verified");
				} else {
					System.out.println("Purchase order has not been created and verified");
					
				}
				
               //verify whether item name is added or not
	
		String actualText2=purchaseOrderpage.getItemInformationText();
				
				if(expectedText2.contains(actualText2)){
					System.out.println("Item name has been added");
				} else {
					System.out.println("Item name has not been added");
					
				}
				
				//sign out
				   HomePage signout =new HomePage(driver);
				    signout.logout();
				    driver.quit();
				

	}


}
