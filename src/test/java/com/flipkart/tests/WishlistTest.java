package com.flipkart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.Product;
import com.flipkart.pages.Wishlist;

public class WishlistTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(WishlistTest.class);

	@Test(priority = 0, dependsOnGroups = "validLogin")
	public void addTowishlist() {
		logger.info("Test :: Adding   Product to  Wishlist  Test Case Started");
		extentTest = extent.startTest("Verify Add a product To WishList");
		Product search = new Product(driver);
		search.search("iPhone");
		Wishlist wish = new Wishlist(driver);
		wish.clickWishlist();
		extent.endTest(extentTest);
		logger.info("Test :: Adding   Product to  Wishlist  Test Case Ended");
	}

	@Test(priority = 1, enabled = false)
	public void removeTowishlist() {
		logger.info("Test :: Removing  Product from  Wishlist  Test Case Started");
		extentTest = extent.startTest("Verify Remove a product To WishList");
		Wishlist wish = new Wishlist(driver);
		gotoWishlist();
		wish.removeWishlist();
		extent.endTest(extentTest);
		logger.info("Test :: Removing  Product from  Wishlist  Test Case Ended");
	}
}
