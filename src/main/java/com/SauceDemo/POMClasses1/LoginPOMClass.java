package com.SauceDemo.POMClasses1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOMClass 
{
	private WebDriver driver;
	private Actions act;
	
	@FindBy(xpath="//form//div[1]//input")
	private WebElement username;
	
	
	public void sendUserName()
	{
		username.sendKeys("standard_user");
	}
	
	
	@FindBy(xpath="//form//div[2]//input")
	private WebElement password;
	public void sendPassword()
	{
		password.sendKeys("secret_sauce");
	}
	
	// normal webelement process
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement loginButton;
	public void clickOnLoginButton()
	{
	   loginButton.click();
	}
	
	// mouse action process
	public void clickOnLoginButton1()
	{
		act.click(loginButton).perform();;
	
	}
	
	public LoginPOMClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		act = new Actions(driver);
	}

}
