package com.qapitol.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.qapitol.base.BaseTest;
import com.qapitol.pages.LoginPage;

public class LoginPageTest  extends BaseTest{
	
	LoginPage login;
	
	@BeforeTest
	public void init() {
		initialization();
		login = new LoginPage(driver);
	}
	
	@Test
	public void loginPageTest() {
		login.getEmailField().sendKeys(property.getProperty("email"));
		login.getPassField().sendKeys(property.getProperty("pass"));
		login.getLoginButton().click();
		
		for(WebElement elemnt : login.getElementList() ) {
			System.out.println(elemnt.getTagName());
		}
	}
	
	
	

}
