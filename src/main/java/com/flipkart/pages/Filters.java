package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Filters {

	WebDriver driver;
	public Filters(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		System.out.print("THis is the driver"+driver);
	}
	

	
	
	
	
}
