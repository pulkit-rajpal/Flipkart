package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.flipkart.pages.Cart;

public class CartTest extends BaseTest {

	@Test(priority = 0)
	public void addToCart() {
		extentTest = extent.startTest("Verify Add a product To Cart");
		Cart cart = new Cart(driver);
		cart.search("micromax");
		cart.click_product();
		cart.clickAddTocart();
		extent.endTest(extentTest);
	}

	@Test(priority = 1)
	public void deletefromCart() {
		extentTest = extent.startTest("Verify Add a product To Cart");
		Cart cart = new Cart(driver);
		gotoCart();
		cart.removeFromCart();
		extent.endTest(extentTest);
	}

	@Test(priority = 1)
	public void addtoCartOutofStock() {
		extentTest = extent.startTest("Verify Add a product To Cart");
		Cart cart = new Cart(driver);
		cart.search("iphone 13 se 128");
		cart.click_product();
		extent.endTest(extentTest);
		assertEquals(cart.verifySoldOut(), "Sold Out");
	}

}
