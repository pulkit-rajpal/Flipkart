package com.flipkart.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Product {

	WebDriver driver;

	public Product(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	public WebElement searchkey;

	@FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
	public WebElement searchIcon;

	@FindBy(xpath = "//div[normalize-space()='Price -- Low to High']")
	public WebElement sortLtoH;

	@FindBy(xpath = "//div[normalize-space()='Price -- High to Low']")
	public WebElement sortHtoL;

	@FindBy(className = "_34uFYj")
	public WebElement brandclass;

	@FindBy(xpath = "//div[@title='APPLE']//div[@class='_24_Dny']")
	public WebElement brandvalue;

	@FindBy(xpath = "//div[@title='4★ & above']//label[@class='_2iDkf8 t0pPfW']")
	public WebElement ratingProd;

	public void search(String keyword) {
		searchkey.sendKeys(keyword);
		searchIcon.click();
	}

	public int getResults(String keyword) {
		int count = 0;
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		List<WebElement> results = driver.findElements(By.className("_4rR01T"));
		for (int i = 0; i < results.size(); i++) {
			if (results.get(i).getText().contains(keyword))
				count++;
		}
		return count;
	}

	public void sortLToH() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		sortLtoH.click();
	}

	public void sortHToL() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		sortHtoL.click();
	}

	public String verifySort() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		List<WebElement> results = driver.findElements(By.cssSelector("div._30jeq3._1_WHN1"));
		int e1 = Integer.valueOf(results.get(0).getText().substring(1).replace(",", ""));
		int e2 = Integer.valueOf(results.get(1).getText().substring(1).replace(",", ""));
		int e3 = Integer.valueOf(results.get(2).getText().substring(1).replace(",", ""));
		if (e1 > e2 && e2 > e3) {
			return "ASC";
		}
		return "DESC";
	}

	public void addbrand(String brand) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		brandclass.sendKeys(brand);
		brandvalue.click();
	}

	public void addRating() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ratingProd.click();
	}

	public boolean verifyBrand(String brand) {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.navigate().refresh();
		List<WebElement> results = driver.findElements(By.className("_4rR01T"));
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		boolean conc = results.get(0).getText().toLowerCase().contains(brand);
		return conc;
	}
}
