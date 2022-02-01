package com.flipkart.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.Cart;
import com.flipkart.pages.ProductDetails;

public class ProductDetailsTest extends BaseTest {

	@Test(priority = 0)
	public void checkImageDisplayed() {
		extentTest = extent.startTest("Verify that an Image is Displayed corresponding to a Product");
		ProductDetails prodDetail = new ProductDetails(driver);
		Cart cart = new Cart(driver);
		ReturnToLoginInPage();
		cart.search("shirt");
		cart.click_product();
		extent.endTest(extentTest);
		Assert.assertTrue(prodDetail.checkimage(), "The Image is Displayed");
	}

	@Test(priority = 0)
	public void changeColorofProduct() {
		ProductDetails prodDetail = new ProductDetails(driver);
		Cart cart = new Cart(driver);
		ReturnToLoginInPage();
		cart.search("shirt");
		cart.click_product();
		prodDetail.changecolor();
		extentTest = extent.startTest("Verify that the function");
		gottLogoutPage();
		extent.endTest(extentTest);
	}

	@Test(priority = 0)
	public void changeSizeofProduct() {
		ProductDetails prodDetail = new ProductDetails(driver);
		extentTest = extent.startTest("Verify LogOut  with Valid Credentials");
		Cart cart = new Cart(driver);
		ReturnToLoginInPage();
		cart.search("shirt");
		cart.click_product();
		prodDetail.changeSize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		extent.endTest(extentTest);
	}

}
