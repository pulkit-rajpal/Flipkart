package com.flipkart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Address extends BasePage {

	WebDriver driver;

	public Address(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//	@FindBy(how = How.XPATH, using = "//div[@class='NS64GK _1MZ7_i']")
//	public WebElement manageAddress;

	@FindBy(how = How.XPATH, using = "//div[@class='_1QhEVk']")
	public WebElement addAddress;

	@FindBy(how = How.NAME, using = "name")
	public WebElement name;

	@FindBy(how = How.NAME, using = "phone")
	public WebElement phone;

	@FindBy(how = How.NAME, using = "pincode")
	public WebElement pincode;

	@FindBy(how = How.NAME, using = "addressLine1")
	public WebElement addressLine1;

	@FindBy(how = How.NAME, using = "addressLine2")
	public WebElement addressLine2;

	@FindBy(how = How.NAME, using = "city")
	public WebElement city;

	@FindBy(how = How.NAME, using = "state")
	public WebElement state;

	@FindBy(how = How.XPATH, using = "//label[@for='HOME']//div[@class='_1XFPmK']")
	public WebElement type;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Save']")
	public WebElement savebutton;

	@FindBy(how = How.XPATH, using = "//div[@class='_2x29pL']")
	public WebElement errorMsg;

	public void click_ManageAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement manageAddress = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Manage Addresses']")));
		System.out.println(manageAddress.getText());
		manageAddress.click();
	}

	public void click_add() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		addAddress.click();
	}

	public void add_details(String nameval, String mob, String pin, String ad1, String ad2, String cty) {
		name.sendKeys(nameval);
		phone.sendKeys(mob);
		pincode.sendKeys(pin);
		addressLine1.sendKeys(ad1);
		addressLine2.sendKeys(ad2);
		city.clear();
		city.sendKeys("Gurugram");
		type.click();
		new Select(state).selectByIndex(12);
		savebutton.click();
	}

	public String getErrorMsg() {
		waitForElementToBeVisible(errorMsg,driver);
		return errorMsg.getText();
	}

	public void gotoProfile() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement menu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='exehdJ'][normalize-space()='pulkit']")));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		WebElement prof = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='My Profile']")));
		actions.moveToElement(prof);
		actions.click().build().perform();
	}


}
