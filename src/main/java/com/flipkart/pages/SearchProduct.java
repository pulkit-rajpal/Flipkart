package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {

	
	WebDriver driver;
	public SearchProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		System.out.print("THis is the driver"+driver);

	}
	
	
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Search for products, brands and more']")
	public WebElement searchIcon;

	@FindBy(how=How.CLASS_NAME, using="_1YokD2 _3Mn1Gg")
	public WebElement results;

	
	
}
