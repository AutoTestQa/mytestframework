package com.automation.base.component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseGeneric {

	public static WebDriver driver = null;
	public static Properties CONFIG = null;
	public static Properties OR = null;
	//static String driverPath = "D:\\Ravi\\chromedriver\\";
	static String driverPath = "src/test/resources/utilities/tools/";

	private void setDriver(String browserType) {
	    
	    
	    if (browserType.equals("chrome"))
	    {
	        driver = initChromeDriver();
	    }
	    else if (browserType.equals("firefox")){
	        driver = initFirefoxDriver();
	    }
	    else {
	        System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
            driver = initFirefoxDriver();
	    } 
	    
	 /*  
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFirefoxDriver();
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver();
		}
		*/
	}

	private static WebDriver initChromeDriver() {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

	@Before
	public void initializeTestBaseSetup() throws IOException {

		CONFIG = new Properties();
		FileInputStream objfile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\utilities\\config.properties");
		CONFIG.load(objfile);

		// OR = new Properties();
		// objfile = new
		// FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\utilities\\config.properties");
		// OR.load(objfile);

		setDriver(CONFIG.getProperty("browserType"));

	}

}
