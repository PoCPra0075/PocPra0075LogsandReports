package com.qapitol.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "email")
	private WebElement emailField;

	@CacheLookup
	@FindBy(name = "pass")
	private WebElement passField;

	@CacheLookup
	@FindBy(name = "login")
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='Forgotten password?']")
	private WebElement forgotPass;

	@FindAll(value = { @FindBy(xpath = "//input[@type='hidden']") })
	private List<WebElement> elementList;

//	@FindBys

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPassField() {
		return passField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getForgotPass() {
		return forgotPass;
	}

	public List<WebElement> getElementList() {
		return elementList;
	}

}
