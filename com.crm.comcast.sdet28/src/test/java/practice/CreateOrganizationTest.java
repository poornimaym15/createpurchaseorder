package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		//Get the data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property = new Properties();
		property.load(fis);
		String browserName = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		
		//How To Use Browser Value and Launch the browser
		WebDriver driver = null;
		if(browserName.equals("chrome")) {
			 
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			  driver=new ChromeDriver();
				
		} else if (browserName.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();
			 
				
		} else {
			System.out.println("browser is not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Testyantra software23");
		driver.findElement(By.name("button")).click();
		//organization name verification
		
		String actualOrgname=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualOrgname.contains("Testyantra software1")) {
			System.out.println("Organization is created");
		} else {
			System.out.println("Organization is not created");
		}
		WebElement profileImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(profileImg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		}
		
		
	
	

	}


