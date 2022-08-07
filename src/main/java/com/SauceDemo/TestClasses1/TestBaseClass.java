package com.SauceDemo.TestClasses1;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.SauceDemo.POMClasses1.LoginPOMClass;
import com.SauceDemo.UtilityClasses1.ScreenShotClass;

public class TestBaseClass 
{
	WebDriver driver;
	Logger log; 
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUP(String browserName) throws Exception
	{
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"./DriverFolder/chromedriver.exe");	
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", 
				"./DriverFolder/geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
		else 
		{
			System.out.println("Throw Error");
		}
		
		log = Logger.getLogger("SauceDemo1");
		PropertyConfigurator.configure("log4j.properties");
		log.info("Browser Opened");
		
		driver.manage().window().maximize();
		log.info("Browser is maximised");
	
	    //URL open
		driver.get("https://www.saucedemo.com/");
		log.info("URL is Opened");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
		// screenshot
		ScreenShotClass.takeScreenShot(driver,"_url");
		
		// Login
		LoginPOMClass lp = new LoginPOMClass(driver);
		lp.sendUserName();
		log.info("Username Entered");
		lp.sendPassword();
		log.info("Password Entered");
		lp.clickOnLoginButton();
		log.info("Loginbutton clicked");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("Browser is closed");
		
	}

}
