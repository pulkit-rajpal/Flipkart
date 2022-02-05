package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Wishlist {

	WebDriver driver;

	public Wishlist(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "path.eX72wL")
	public WebElement Wishlist;

	@FindBy(how = How.XPATH, using = "//img[@class='_2Nq6Qc']")
	public WebElement removeWish;

	public void clickWishlist() {
		Wishlist.click();
	}

	public void removeWishlist() {
		removeWish.click();
	}

}
