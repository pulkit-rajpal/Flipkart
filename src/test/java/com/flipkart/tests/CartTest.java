package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.Cart;
import com.flipkart.pages.Login;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class CartTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(CartTest.class);
	private static String testPageData = "CartTestData";

	@Test(groups = { "cart" }, priority = 14, enabled = true)
	public void addToCart() {
		String testName = "addToCart";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		extentTest = extent.startTest("Verify adding a Product to Cart");
		logger.info("Test :: Add To Cart Test Case Started");
		Cart cart = new Cart(driver);
		logger.info("Test :: " + testName + " -Signing Up to Flipkart Web App");
		Login login = new Login(driver);
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		cart.search(testData.get("key"));
		cart.click_product();
		logger.info("Test :: " + testName + " -Clicked to view the Product");
		String title = cart.clickAddTocart();
		extentTest.log(LogStatus.PASS, testName + " -Test has Passed");
		Assert.assertEquals(title, "PLACE ORDER");
		extent.endTest(extentTest);
		logger.info("Test :: Add To Cart Test Case Ended");

	}
	/*
	 * @Test(groups = { "cart" }, priority = 15, enabled = true) public void
	 * deletefromCart() { String testName = "deletefromCart"; HashMap<String,
	 * String> testData = fileExcel.getRowTestData(testPageData, testName);
	 * ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
	 * extentTest = extent.startTest("Verify Removing a Product from  Cart");
	 * logger.info("Test :: Delete From  Cart Test Case Started"); Cart cart = new
	 * Cart(driver); Login login = new Login(driver); logger.info("Test :: " +
	 * testName + " Signing Up to Flipkart Web App");
	 * login.entermobileNo(testData.get("mob").replace("\"", ""));
	 * login.enterPassword(testData.get("pwd")); login.click_LoginButton();
	 * cart.gotoCart(); cart.removeFromCart(); logger.info("Test :: " + testName +
	 * " -Product Removed from cart"); assertEquals(driver.getTitle(),
	 * "Shopping Cart | Flipkart.com"); extentTest.log(LogStatus.PASS, testName +
	 * " Test has Passed"); extent.endTest(extentTest);
	 * logger.info("Test :: Delete From  Cart Test Case Ended"); }
	 */
	
	

	@Test(groups = { "cart" }, priority = 15, enabled = true)
	public void addtoCartOutofStock() {
		String testName = "addtoCartOutofStock";
		extentTest = extent.startTest("Verify Unable Add to Cart for Out of Stock Product Test");

		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		extentTest = extent.startTest("Verify Unable Add to Cart for Out of Stock Product Test");
		logger.info("Test :: Unable Add to Cart for Out of Stock Product Test Case Started");
		Login login = new Login(driver);
		Cart cart = new Cart(driver);
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		cart.search(testData.get("key"));
		cart.click_product();
		assertEquals(cart.verifySoldOut(), "Sold Out");
		extentTest.log(LogStatus.PASS, "Unable Add to Cart for Out of Stock Product Test Case Passed");
		extent.endTest(extentTest);
		logger.info("Test :: Unable Add to Cart for Out of Stock Product Test Case Ended");
	}

}
