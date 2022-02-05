package com.flipkart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.Cart;
import com.flipkart.pages.Login;
import com.flipkart.pages.Wishlist;

public class WishlistTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(WishlistTest.class);

	@Test(groups = "wishlist", priority = 0)
	public void addTowishlist() throws InterruptedException {
		logger.info("Test :: Adding   Product to  Wishlist  Test Case Started");
		extentTest = extent.startTest("Verify Add a product To WishList");
		Cart search = new Cart(driver);
		Login login = new Login(driver);
		Wishlist wish = new Wishlist(driver);
		login.entermobileNo(mobNo);
		login.enterPassword(pwd);
		login.click_LoginButton();
		search.search("iPhone");
		wish.clickWishlist();
		extent.endTest(extentTest);
		logger.info("Test :: Adding   Product to  Wishlist  Test Case Ended");
	}
	/*
	 * @Test(groups = "wishlist",priority = 1) public void removeTowishlist() {
	 * logger.info("Test :: Removing  Product from  Wishlist  Test Case Started");
	 * extentTest = extent.startTest("Verify Remove a product To WishList");
	 * Wishlist wish = new Wishlist(driver); gotoWishlist(); wish.removeWishlist();
	 * extent.endTest(extentTest);
	 * logger.info("Test :: Removing  Product from  Wishlist  Test Case Ended"); }
	 */
}
