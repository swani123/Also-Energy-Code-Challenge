package browserPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public Properties prop;
	
	public Properties initConfig() throws IOException {
		prop = new Properties();
		try {
			String path = System.getProperty("user.dir") + "/Configurations/config.properties";
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public WebDriver initializebrowser() {
		
	
        WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String url=prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
		
		
	}

}
