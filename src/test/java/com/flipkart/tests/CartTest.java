package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.Cart;
import com.flipkart.pages.Login;
import com.relevantcodes.extentreports.LogStatus;

public class CartTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(CartTest.class);

	@Test(groups = "cart", priority = 8)
	public void addToCart() throws InterruptedException {
		logger.info("Test :: Add To Cart Test Case Started");
		extentTest = extent.startTest("Verify Add a product To Cart");
		Login login = new Login(driver);
		Cart cart = new Cart(driver);
		login.entermobileNo(mobNo);
		login.enterPassword(pwd);
		login.click_LoginButton();
		cart.search("micromax");
		cart.click_product();
		String title = cart.clickAddTocart();
		Assert.assertEquals(title, "Shopping Cart | Flipkart.com");
		extent.endTest(extentTest);
		extentTest.log(LogStatus.PASS, "Add To Cart Test Passed ");
		logger.info("Test :: Add To Cart Test Case Ended");
	}

	@Test(groups = "cart", priority = 9, enabled = false)
	public void deletefromCart() {
		logger.info("Test :: Delete From  Cart Test Case Started");
		extentTest = extent.startTest("Verify Add a product To Cart");
		Cart cart = new Cart(driver);
		gotoCart();
		cart.removeFromCart();
		extent.endTest(extentTest);
		extentTest.log(LogStatus.PASS, "Delete From  Cart Test Passed");
		logger.info("Test :: Delete From  Cart Test Case Ended");

	}

	@Test(groups = "cart", priority = 10, enabled = false)
	public void addtoCartOutofStock() {
		logger.info("Test :: Unable Add to Cart for Out of Stock Product Test Case Started");
		extentTest = extent.startTest("Verify Add a product To Cart");
		Cart cart = new Cart(driver);
		cart.search("iphone 13 se 128");
		cart.click_product();
		extent.endTest(extentTest);
		assertEquals(cart.verifySoldOut(), "Sold Out");
		extentTest.log(LogStatus.PASS, "Unable Add to Cart for Out of Stock Product Test Case Passed");
		logger.info("Test :: Unable Add to Cart for Out of Stock Product Test Case Ended");
	}

}
