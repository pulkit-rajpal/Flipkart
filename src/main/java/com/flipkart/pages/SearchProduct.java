package com.flipkart.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {

	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	public WebElement searchkey;

	@FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
	public WebElement searchIcon;

	public void search(String keyword) {
		searchkey.sendKeys(keyword);
		searchIcon.click();
	}

	public int getResults(String  keyword) {
		int count=0;
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		List<WebElement> results = driver.findElements(By.className("_4rR01T"));
		for (int i = 0; i < results.size(); i++) {
		if(results.get(i).getText().contains(keyword))
			count++;
		}
		return count;
	}

}
