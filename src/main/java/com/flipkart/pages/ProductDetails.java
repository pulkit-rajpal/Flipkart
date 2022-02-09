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

public class ProductDetails extends BasePage{

	WebDriver driver;

	/*
	 * ProductDetails Page for getting Locators which will be required to perform
	 * task fields
	 */

	public ProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* Declare web elements using different locators. */

	@FindBy(how = How.XPATH, using = "//img[@class='_2r_T1I _396QI4']")
	public WebElement img;

	@FindBy(how = How.XPATH, using = "")
	public WebElement getSize;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	public WebElement searchkey;

	@FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
	public WebElement searchIcon;

	/*
	 * Various task Methods for performing the required task for executing ProductDetails
	 * Test Completely .
	 */

	public boolean checkimage() {
		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_5, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		return img.isDisplayed();
	}

	public void search(String keyword) {
		searchkey.sendKeys(keyword);
		searchIcon.click();
	}

	public void click_product() {
		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_5, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		List<WebElement> results = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("img._2r_T1I")));
		results.get(0).click();
	}

	public boolean changecolor() {

		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_5, TimeUnit.SECONDS);
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		List<WebElement> colorElements = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div._2C41yO._1pH70n._31hAvz")));
		WebElement colorElement = colorElements.get(0);
		colorElement.click();
		List<WebElement> colorElements1 = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div._2C41yO._1pH70n._31hAvz")));
		WebElement colorElement1 = colorElements1.get(0);
		if (colorElement1.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean changeSize() {
		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_5, TimeUnit.SECONDS);
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		List<WebElement> sizElements = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a._1fGeJ5._2UVyXR._31hAvz")));
		WebElement sizElement = sizElements.get(0);
		sizElement.click();
		WebDriverWait wait1 = new WebDriverWait(driver,IMPLITICIT_WAIT_10);
		WebElement wbElement = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a._1fGeJ5.PP89tw._2UVyXR._31hAvz")));
		WebElement wbElement1 = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a._1fGeJ5._2UVyXR._31hAvz")));
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		if (wbElement1.getText().compareTo(wbElement.getText().replace("Size:", "")) == 0) {
			return true;
		} else {
			return false;
		}
	}
}
