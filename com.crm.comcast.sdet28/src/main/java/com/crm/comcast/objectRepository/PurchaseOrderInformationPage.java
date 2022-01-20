package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Purchase order information pom class
 * @author POORNIMA
 *
 */

public class PurchaseOrderInformationPage {
public PurchaseOrderInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//span[@class='lvtHeaderText']")
private WebElement purchaseInfoText;

public WebElement getPurchaseInfoText() {
	return purchaseInfoText;
}
/**
 * it will return the purchaseorder information text
 * @return
 */
public String getpurchaseInfoText() {
	return purchaseInfoText.getText();
}
}
