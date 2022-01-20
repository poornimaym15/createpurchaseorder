package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * PurchaseorderPage POM design
 * @author POORNIMA
 *
 */

public class PurchaseorderPage {
	public PurchaseorderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	public WebElement createpurchaseorderPlusImage;
	
	
	
	public WebElement getCreatepurchaseorderPlusImage() {
		return createpurchaseorderPlusImage;
	}
	//business logic
	public void clickpurchaseorderImg() {
		createpurchaseorderPlusImage.click();
		
	}

}
