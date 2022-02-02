package com.flipkart.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.Cart;
import com.flipkart.pages.ProductDetails;


public class ProductDetailsTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(ProductDetailsTest.class);
	
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
		extentTest = extent.startTest("Verify that the User can change the Color of the Particular Product Like Shirt");
		ProductDetails prodDetail = new ProductDetails(driver);
		Cart cart = new Cart(driver);
		ReturnToLoginInPage();
		cart.search("shirt");
		cart.click_product();
		prodDetail.changecolor();
		gottLogoutPage();
		extent.endTest(extentTest);
	}

	@Test(priority = 0)
	public void changeSizeofProduct() {
		extentTest = extent.startTest("Verify that the User can change the Size of the Particular Product Like Shirt");
		logger.info("Test :: The Verify Size Change of Product");
		ProductDetails prodDetail = new ProductDetails(driver);
		Cart cart = new Cart(driver);
		ReturnToLoginInPage();
		cart.search("shirt");
		cart.click_product();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		assertTrue(prodDetail.changeSize());
		logger.info("Test :: The Verify Size Change of Product has Ended");
		extent.endTest(extentTest);
	}

}
