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

public class Cart extends BasePage{
	WebDriver driver;

	/*
	 * Cart Page for getting Locators like search key,remove buttons and other input
	 * text fields
	 */

	public Cart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* Declare web elements using different locators. */

	@FindBy(how = How.CSS, using = "input._3704LK")
	public WebElement searchkey;

	@FindBy(css = "path._34RNph")
	public WebElement searchIcon;

//	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
//	public WebElement addtocart;

	@FindBy(css = "div._3dsJAO")
	public WebElement remove;

	@FindBy(css = "div._3dsJAO._24d-qY.FhkMJZ")
	public WebElement removeButton;

	@FindBy(xpath = "//div[@class='_16FRp0']")
	public WebElement soldMsg;

	@FindBy(css = "div._3g_HeN")
	public WebElement count;

	/*
	 * Various Click Methods for performing the required task for executing Cart
	 * Test Completely .
	 */

	public void search(String keyword) {
		driver.navigate().refresh();
		searchkey.sendKeys(keyword);
		searchIcon.click();
	}

	public void click_product() {

		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_15);
		// List<WebElement> results = driver.findElements(By.className("_4rR01T"));
		List<WebElement> results = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("_4rR01T")));
		results.get(0).click();
	}

	public String clickAddTocart() {
		driver.navigate().refresh();
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		driver.manage().timeouts().pageLoadTimeout(IMPLITICIT_WAIT_10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_15);
		WebElement addtocart = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2U9uOA._3v1-ww")));
		addtocart.click();
		WebElement placeorder = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2ObVJD._3AWRsL")));

		return placeorder.getText();
	}

	public void removeFromCart() {
		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_20, TimeUnit.SECONDS);
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
		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_10, TimeUnit.SECONDS);
		int num = Integer.parseInt(count.getText());
		return num;
	}

	protected void waitForElementTobeClickable(WebElement webElement) {
		new WebDriverWait(driver, IMPLITICIT_WAIT_10).until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public void gotoCart() {

		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_15);
		WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.className("KK-o3G")));
		cart.click();

	}
}
