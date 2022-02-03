package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.Cart;

public class CartTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(CartTest.class);

	@Test(priority = 0)
	public void addToCart() {
		logger.info("Test :: Add To Cart Test Case Started");
		extentTest = extent.startTest("Verify Add a product To Cart");
		Cart cart = new Cart(driver);
		cart.search("micromax");
		cart.click_product();
		cart.clickAddTocart();
		extent.endTest(extentTest);
		logger.info("Test :: Add To Cart Test Case Ended");
	}

	@Test(priority = 1)
	public void deletefromCart() {
		logger.info("Test :: Delete From  Cart Test Case Started");
		extentTest = extent.startTest("Verify Add a product To Cart");
		Cart cart = new Cart(driver);
		gotoCart();
		cart.removeFromCart();
		extent.endTest(extentTest);
		logger.info("Test :: Delete From  Cart Test Case Ended");

	}

	@Test(priority = 1)
	public void addtoCartOutofStock() {
		logger.info("Test :: Unable Add to Cart for Out of Stock Product Test Case Started");
		extentTest = extent.startTest("Verify Add a product To Cart");
		Cart cart = new Cart(driver);
		cart.search("iphone 13 se 128");
		cart.click_product();
		extent.endTest(extentTest);
		assertEquals(cart.verifySoldOut(), "Sold Out");
		logger.info("Test :: Unable Add to Cart for Out of Stock Product Test Case Ended");
	}

}
