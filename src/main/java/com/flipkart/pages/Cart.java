package com.flipkart.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	WebDriver driver;

	public Cart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	public WebElement searchkey;

	@FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
	public WebElement searchIcon;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	public WebElement addtocart;

	@FindBy(xpath = "//div[normalize-space()='Remove']")
	public WebElement remove;


	@FindBy(xpath = "//div[@class='_3dsJAO _24d-qY FhkMJZ']")
	public WebElement removeButton;

	

	@FindBy(xpath = "//div[@class='_16FRp0']")
	public WebElement soldMsg;

	
	public void search(String keyword) {
		searchkey.sendKeys(keyword);
		searchIcon.click();
	}

	public void click_product() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		List<WebElement> results = driver.findElements(By.className("_4rR01T"));
		results.get(results.size()-1).click();
	}

	public void clickAddTocart() {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		addtocart.click();
	}

	public void removeFromCart() {
		remove.click();
		removeButton.click();
	}

	public String verifySoldOut() {
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		return soldMsg.getText();
	}


}
