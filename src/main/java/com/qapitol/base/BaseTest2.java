package com.qapitol.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest2 {
	
	public static WebDriver driver;
	public static Properties property;
	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	public static void initialization(String browser) {
		
		property = new Properties();
		try {
			property.load(new FileInputStream("C:\\Users\\Qapitol QA\\eclipse-workspace\\Day4\\src\\test\\resources\\config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(property.getProperty("browser").equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		}else if(property.getProperty("browser").equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		else{
//			driver = new EdgeDriver();
//		}
//		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			threadLocal.set(driver);
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			threadLocal.set(driver);
		}
		else{
			driver = new EdgeDriver();
			threadLocal.set(driver);

		}
		

		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
}
