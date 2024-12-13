package com.qapitol.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qapitol.base.BaseTest;
import com.qapitol.pages.ElementsPage;
import com.qapitol.util.ExtentReportListner;

@Listeners(ExtentReportListner.class)
public class ElementsTest extends BaseTest{
	
	ElementsPage elements;
	private static final Logger log = Logger.getLogger(ElementsTest.class);
	
	@BeforeTest
	public void init() {
		log.info("Entered in to intialization init()");
		log.error("Error Messsage");
		initialization();
		elements = new ElementsPage(driver);
		log.info("Executed intialization Successfully ");

	}
	
	@Test(priority = 1)
	public void validateTextBox() throws InterruptedException {
		Thread.sleep(1000);
//		elements.getElementsCard().click();
		elements.getTextBoxTab().click();
		elements.getUsername().sendKeys("ve j wevcwd");
		elements.getUserEmail().sendKeys("vwe@gmail.com");
		elements.getSubmit().click();
		
	}
	
	@Test(priority = 2)
	public void validateCheckBox() throws InterruptedException {
		Thread.sleep(1000);
		elements.getCheckBoxTab().click();
		elements.getCheckbox().click();
		
	}
	
	@Test(priority = 3)
	public void validateRadioButton() throws InterruptedException {
		Thread.sleep(500);
		elements.getRadioButtonTab().click();
		elements.getRadioButton().click();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
