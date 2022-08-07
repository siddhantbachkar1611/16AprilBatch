package com.SauceDemo.POMClasses1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePOMClass 
{
	private WebDriver driver;	
	private Select s;
	
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	private WebElement settingButton;
	
	public void clickOnSettingButton()
	{
		settingButton.click();
	}
	
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logoutButton;
	
	public void clickOnLogOut()
	{
		logoutButton.click();
	}
	
	
	// bag button
	@FindBy(xpath="(//button[text()='Add to cart'])[1]")
	private WebElement bagButton;
	
	// normal click process- webelement method
	public void clickOnBagbutton()
	{
		bagButton.click();
	}
	
	//add to cart button
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement addTOCartButton;
	
	public String getTextFromCartButton()
	{
		String totalProducts = addTOCartButton.getText();
		return totalProducts;
	}
	
	
	// All Product	
	@FindBy(xpath="//button[text()='Add to cart']")
    private List <WebElement> multiAddToCartButton;

	public void clickAllProduct()
	{
		for(WebElement i:multiAddToCartButton)
		{
			i.click();
		}
	}	
	
	
	// filter dropdown
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement dropDownfilter;
	
	public void clickOnDropDownFilter()
	{
		dropDownfilter.click();
		s.selectByVisibleText("Price(low to high)");
		
	}
	
	public HomePOMClass(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		s = new Select(dropDownfilter);
		
	}
	

}
