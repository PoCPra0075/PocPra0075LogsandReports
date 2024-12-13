package com.qapitol.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.qapitol.base.BaseTest2;
import com.qapitol.pages.LoginPage;

public class LoginPageTest2  extends BaseTest2{
	
	LoginPage login;
	
	@BeforeClass
	@Parameters({"browser"} )
	public void init(@Optional("chrome") String browser) {
		initialization(browser);
		login = new LoginPage(driver);
	}
	
	@Test
	public void loginPageTest() throws InterruptedException {
		Thread.sleep(1000);
		login.getEmailField().sendKeys(property.getProperty("email"));
		login.getPassField().sendKeys(property.getProperty("pass"));
		login.getLoginButton().click();
		
		for(WebElement elemnt : login.getElementList() ) {
			System.out.println(elemnt.getTagName());

		}
	}
	
	
	

}
