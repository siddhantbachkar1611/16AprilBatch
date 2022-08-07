package com.SauceDemo.TestClasses1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses1.HomePOMClass;
import com.SauceDemo.POMClasses1.LoginPOMClass;

public class TC002_VerifyLogOutFunctionality extends TestBaseClass
{
	@Test(priority=3)
	public void logoutFunctionalty()  
	{
		// Login Page 	
		HomePOMClass hp = new HomePOMClass(driver);
		hp.clickOnSettingButton();
		log.info("Click on Setting Button");
		hp.clickOnLogOut();
		log.info("Click on LogOut Button");
		
		// Validation	
		String exceptedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle,exceptedTitle);	
		log.info("Applying Assertion");
	}

}
