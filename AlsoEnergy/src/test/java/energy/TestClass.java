package energy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserPackage.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
// This test class is inherited from base class which contains methods to read config.properties file
// and browser initialization 

public class TestClass extends BaseClass {
	WebDriver driver;
	
//	In Before Class annotation section, we initialize the config properties file and launch the browser
//	by instantiating the webdriver from respective browser class(I used Chrome driver)
	@BeforeClass
	public void initialize() throws IOException {
		initConfig();
		driver = initializebrowser();
	}
	
// This test verifies given URL is available by comparing browser URL launched and given URL
	@Test
	public void CheckUrl() {
		
		// Used Soft Assert to make sure test execution does not stop for single validation failure
		 SoftAssert assertion = new SoftAssert();
//		 Here we are asserting that given URL is same as that of launched URL 
//		 to conform the URL is available
	     assertion.assertEquals(driver.getCurrentUrl(), prop.getProperty("url"));
	     System.out.println(driver.getCurrentUrl());
		 assertion.assertAll();
	}
//	Here we quit the browser 
     @AfterClass
     public void quitBrowser() throws InterruptedException {
	 Thread.sleep(2000);
	 driver.quit();
}
  
  
}
