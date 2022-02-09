package com.flipkart.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wishlist extends BasePage {

	WebDriver driver;

	/*
	 * Wishlist Page for getting Locators which will be required to perform task
	 * fields
	 */

	public Wishlist(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* Declare web elements using different locators. */

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	public WebElement searchkey;

	@FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
	public WebElement searchIcon;

	@FindAll({ @FindBy(className = "_3FVYY1") })
	public List<WebElement> Wishlistproducts;

	@FindBy(how = How.CSS, using = "path.eX72wL")
	public WebElement Wishlist;

	@FindBy(how = How.XPATH, using = "//img[@class='_2Nq6Qc']")
	public WebElement removeWish;

	/*
	 * Various task Methods for performing the required task for executing Wishlist
	 * Test Completely .
	 */

	public void clickWishlist() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Wishlist.click();
	}

	public void removeWishlist() {
		removeWish.click();
	}

	public void search(String keyword) {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_20, TimeUnit.SECONDS);
		waitForElementTobeClickable(searchkey, driver);
		searchkey.sendKeys(keyword);
		waitForElementTobeClickable(searchIcon, driver);
		searchIcon.click();
	}

	public boolean verifyClick() {
		if (Wishlist.isDisplayed())
			return true;
		else
			return false;
	}

	public void gotToWishlist() {

		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		WebElement menu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//div[@class='exehdJ'][normalize-space()='pulkit']")));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		WebElement prof = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Wishlist']")));
		actions.moveToElement(prof);
		actions.click().build().perform();
	}

	public List<WebElement> getProductInWishlist() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return Wishlistproducts;

	}

	public void verifyRemove()

	{

	}

}
