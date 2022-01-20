package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * CreateNewPurchaseorderPage POM Design
 * @author POORNIMA
 *
 */

public class CreateNewPurchaseorderPage {
	public CreateNewPurchaseorderPage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSubjectTextField() {
		return subjectTextField;
	}
	
	@FindBy(name="subject")
	private WebElement subjectTextField;
	
    @FindBy(id="exciseduty")
	 private WebElement excisedutyTextField;
	 
	 @FindBy(xpath="//input[@value='Add Product']")
	 private WebElement addButton;
	 
	 @FindBy(xpath="//b[text()='Item Name']/../../..//textarea[@id='comment1']")
	 private WebElement textArea;
	 
	 @FindBy(xpath="//img[@src='themes/images/down_layout.gif']")
	 private WebElement movedownwardButton;
	 
	 @FindBy(xpath="//img[@src='themes/images/up_layout.gif']")
	 private WebElement moveupwardButton;
	 
	 @FindBy(xpath="//b[text()='Item Name']/../../..//textarea[@id='comment2']")
	  private WebElement itemnameTextAreaa;
	 
	 @FindBy(xpath="//img[@src='themes/images/delete.gif']")
	 public WebElement deleteIcon;
	 
	 @FindBy(xpath="//b[text()='Item Name']")
	 public WebElement itemNameText;
	 
	 @FindBy(xpath="//span[text()='Creating New Purchase Order']")
	 private WebElement purchaseOrderText;
	 
	 
	  public WebElement getPurchaseOrderText() {
		return purchaseOrderText;
	}
	public WebElement getItemNameText() {
		return itemNameText;
	}
	//business logic
	 public void deleteItem() {
		 deleteIcon.click();
	 }
	 public void itemone(String name) {
		 textArea.sendKeys(name);
	 }
	 public void itemtwo(String name) {
		 itemnameTextAreaa.sendKeys(name);
	 }
	 
	 public String getItemInformationText() {
		 return itemNameText.getText();
	 }
	 
	 public String getpurchaseOrderText() {
		 return purchaseOrderText.getText();
	 }
	public WebElement getItemnameTextAreaa() {
		return itemnameTextAreaa;
	}
	public WebElement getTextArea() {
		return textArea;
	}
	public WebElement getMovedownwardButton() {
		return movedownwardButton;
	}
	public void movedownwardButton() {
		 movedownwardButton.click();
		 
	 }
	public void moveupwardButton() {
		moveupwardButton.click();
	}
	 
	public WebElement getUpwardButton() {
		moveupwardButton.click();
		return moveupwardButton;
	}
	 public WebElement getMoveupwardButton() {
		return moveupwardButton;
	}
	public WebElement getDeleteIcon() {
		 return deleteIcon;
	}
	 
	 public WebElement addproductButton() {
		 addButton.click();
		return addButton;
	 }
	 
    public void itemname(String name){
    	itemnameTextAreaa.sendKeys(name);
    }	

	 public void subjectText(String subject) {
			  subjectTextField.sendKeys(subject);
		  } 
	 
     public WebElement getAddButton() {
			return addButton;
		}
     
	 public void exciseDuty(String excisename) {
			  excisedutyTextField.sendKeys(excisename);
	 }
		 
	 public WebElement getExcisedutyTextField() {
			return excisedutyTextField;
		}
	 
	 public WebElement getsubjectTextField() {
		return subjectTextField;
	}

	 public WebElement getItemnameTextArea() {
		return getItemnameTextArea();
	}
	 

}
