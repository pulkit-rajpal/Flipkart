package com.flipkart.tests;

import org.testng.annotations.Test;

import com.flipkart.pages.Product;
import com.flipkart.pages.Wishlist;

public class WishlistTest extends BaseTest {

	@Test(priority = 0, dependsOnGroups = "validLogin")
	public void addTowishlist() {
		extentTest = extent.startTest("Verify Add a product To WishList");
		Product search = new Product(driver);
		search.search("iPhone");
		Wishlist wish = new Wishlist(driver);
		wish.clickWishlist();
		extent.endTest(extentTest);
	}

	@Test(priority = 1, enabled = false)
	public void removeTowishlist() {
		extentTest = extent.startTest("Verify Remove a product To WishList");
		Wishlist wish = new Wishlist(driver);
		gotoWishlist();
		wish.removeWishlist();
		extent.endTest(extentTest);
	}
}
