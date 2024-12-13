package com.qapitol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
	
	public ElementsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[text() ='Check Box']")
	private WebElement checkBoxTab;
	
	@FindBy(xpath =  "//h5[text()='Elements']")
	private WebElement elementsCard;
	
	@FindBy(xpath =  "//span[text()='Text Box']")
	private WebElement textBoxTab;
	
	@FindBy(xpath =  "//span[text()='Radio Button']")
	private WebElement radioButtonTab;
	
	
	@FindBy(id ="userName") 
	private WebElement username;
	
	@FindBy(id ="userEmail") 
	private WebElement userEmail;
	
	@FindBy (id = "submit")
	private WebElement submit;
	
	@FindBy (xpath = "//span[text()='Home']")
	private WebElement checkbox;
	
	@FindBy (id ="yesRadio")
	private WebElement radioButton;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getElementsCard() {
		return elementsCard;
	}

	public WebElement getCheckBoxTab() {
		return checkBoxTab;
	}

	public WebElement getTextBoxTab() {
		return textBoxTab;
	}

	public WebElement getRadioButtonTab() {
		return radioButtonTab;
	}

	
	
	

}
