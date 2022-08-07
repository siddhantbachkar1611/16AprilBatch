package com.SauceDemo.TestClasses1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses1.LoginPOMClass;
import com.SauceDemo.UtilityClasses1.ScreenShotClass;

public class TC001_VerifyLoginPageFunctionality extends TestBaseClass
{
	@Test(priority=4)
	public void loginPageFunctionality() throws Exception
	{	
		ScreenShotClass.takeScreenShot(driver,"_homepage");
		
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle,expectedTitle);
		log.info("Applying Assertion");
	}

}
