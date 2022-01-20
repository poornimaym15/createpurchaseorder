package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * HomePage POM design
 * @author POORNIMA
 *
 */

public class HomePage extends WebDriverUtility{
	//initialization of elements
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	//declaration of elements
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement morePurchaseOrder;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseorderLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	public WebElement getLogoutImg() {
		return logoutImg;
	}

	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	
	
	public WebElement getMorePurchaseOrder() {
		return morePurchaseOrder;
	}

	 public WebElement getPurchaseorderLink() {
		return purchaseorderLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	//business logics
	/**
	 * this method will click on purchase order link
	 */
	public void clickPurchaseorderLink() {
		purchaseorderLink.click();
	}
	public void logout() {
		mouseOver(driver, logoutImg);
		signOutLink.click();
	}
	public void hoverOnMore() {
		mouseOver(driver, morePurchaseOrder);
		purchaseorderLink.click();
		
	}
			
	
	
	

}
