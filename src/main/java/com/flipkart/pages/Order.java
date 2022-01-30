package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Order {
	WebDriver driver;
	public Order(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
	}

}
