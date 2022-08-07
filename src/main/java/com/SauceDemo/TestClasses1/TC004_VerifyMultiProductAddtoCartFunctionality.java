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

public class TC004_VerifyMultiProductAddtoCartFunctionality extends TestBaseClass
{
     @Test(priority=1)	
     public void multipleProductAddToCartFunctionality() throws Exception 
     {
    	//Home Page  
		HomePOMClass hp = new HomePOMClass(driver);
		hp.clickAllProduct();
		log.info("Clicked on Multiple product");
		
		// Screenshot
		ScreenShotClass.takeScreenShot(driver,"_homepage");
		
		// Validation
		String expectedCount = "6";
		String actualCount = hp.getTextFromCartButton();
		
		Assert.assertEquals(actualCount,expectedCount);
		log.info("Applying Assertion");
	
	
	}

}
