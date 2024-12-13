package com.qapitol.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties property;
	
	public static void initialization() {
		
		
		// Downlaod File in custom location
		ChromeOptions options = new ChromeOptions();
		
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		String path = "C:\\Users\\Qapitol QA\\eclipse-workspace\\Day4\\Repo";
		prefs.put("download.default_directory",path );
		
		options.setExperimentalOption("prefs", prefs);
		
		// Done
		property = new Properties();
		try {
			property.load(new FileInputStream("C:\\Users\\Qapitol QA\\eclipse-workspace\\Day4\\src\\test\\resources\\config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(property.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		}else if(property.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else{
			driver = new EdgeDriver();
		}
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		else{
//			driver = new EdgeDriver();
//		}
		

		driver.get(property.getProperty("url"));
		
		// Add blocking from DEMO-QA
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelectorAll('[id*=\"ad\"], [class*=\"ad\"], [id*=\"banner\"], [class*=\"banner\"], iframe, ins, .sponsored, .advertisement').forEach(el => el.style.display = 'none');","");
		// Done
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
}
