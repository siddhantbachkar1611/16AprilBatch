package com.SauceDemo.TestClasses1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses1.HomePOMClass;
import com.SauceDemo.POMClasses1.LoginPOMClass;
import com.SauceDemo.UtilityClasses1.ScreenShotClass;
public class TC003_VerifyAddToCartFunctionality extends TestBaseClass
{
	@Test(priority=2)
	public void addToCartFunctionality() throws Exception
	{	
		//Home Page
		
		HomePOMClass hp = new HomePOMClass(driver);
		hp.clickOnBagbutton();
		log.info("Clicked on bag button");
		
		// screenshot
		ScreenShotClass.takeScreenShot(driver,"_homepage");
		
		String expectedCount = "1";
		String actualCount = hp.getTextFromCartButton();
		
		Assert.assertEquals(actualCount,expectedCount);
		log.info("Applying Assertion");

	}
	

	
		
		
	
}
