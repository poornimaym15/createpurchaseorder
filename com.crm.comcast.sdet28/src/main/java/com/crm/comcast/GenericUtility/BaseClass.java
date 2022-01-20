package com.crm.comcast.GenericUtility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * 
 * @author POORNIMA
 *
 */

public class BaseClass {
	public WebDriver driver;
	public JavaUtility jUtil = new JavaUtility();
	public ExcelUtility eUtil =new ExcelUtility();
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();

	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBs() {
		//connection to db
		System.out.println("====connect to db====");
	}
	@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBc() throws Throwable {
   //launching the browser
		String browser =fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH);
			driver=new ChromeDriver();
			
		}else if(browser.equals("firefox")) {
			System.setProperty(IPathConstants.FIREFOX_KEY, IPathConstants.FIREFOX_PATH);
			driver=new FirefoxDriver();
		}else {
			System.out.println("browser is not supported");
		}
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		driver.get(url);
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBm() throws Throwable {
		//fetching data from property file
	String userName=fUtil.getPropertyFileData("username");
	String password=fUtil.getPropertyFileData("password");
	//login to application
	LoginPage login = new LoginPage(driver);
	login.loginToApplication(userName, password);
	}
	
	@AfterMethod (groups= {"smokeTest","regressionTest"})
	public void configAm() {
		HomePage homePage = new HomePage(driver);
		homePage.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAc() {
		//closing or quitting the browser
		driver.quit();
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAs() {
		//closing the database connection
		System.out.println("===Database connection is closed");
	}
		
	}
	
	
		

