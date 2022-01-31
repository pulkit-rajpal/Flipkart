package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Address {

	WebDriver driver;

	public Address(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

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

	public void click_add() {
		addAddress.click();
	}

	public void add_details(String nameval, String mob, String pin, String ad1, String ad2, String cty, String st) {
		name.sendKeys(nameval);
		phone.sendKeys(mob);
		pincode.sendKeys(pin);
		addressLine1.sendKeys(ad1);
		addressLine2.sendKeys(ad2);
		city.sendKeys(cty);
		type.click();
		state.sendKeys(st);
		savebutton.click();
	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}

}
