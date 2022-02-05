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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
	WebDriver driver;

	public Cart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input._3704LK")
	public WebElement searchkey;

	@FindBy(css = "path._34RNph")
	public WebElement searchIcon;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	public WebElement addtocart;

	@FindBy(xpath = "//div[normalize-space()='Remove']")
	public WebElement remove;

	@FindBy(xpath = "//div[@class='_3dsJAO _24d-qY FhkMJZ']")
	public WebElement removeButton;

	@FindBy(xpath = "//div[@class='_16FRp0']")
	public WebElement soldMsg;

	@FindBy(css = "div._3g_HeN")
	public WebElement count;

	public void search(String keyword) {

		waitForElementTobeClickable(searchkey);		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			WebElement searchkey = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input._3704LK")));
			searchkey.clear();
			searchkey.sendKeys(keyword);

		} catch (Exception e) {
			WebElement searchkey = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input._3704LK")));
			searchkey.clear();
			searchkey.sendKeys(keyword);
		}
		
		waitForElementTobeClickable(searchIcon);
		searchIcon.click();
	}

	public void click_product() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		List<WebElement> results = driver.findElements(By.className("_4rR01T"));
		waitForElementTobeClickable(results.get(0));
		results.get(0).click();
	}

	public String clickAddTocart() {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		waitForElementTobeClickable(addtocart);
		addtocart.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver.getTitle();
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

	public int verifycount() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int num = Integer.parseInt(count.getText());
		return num;
	}

	protected void waitForElementTobeClickable(WebElement webElement) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(webElement));
	}
}
