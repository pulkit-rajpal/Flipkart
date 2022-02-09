package com.flipkart.tests;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.Login;
import com.flipkart.pages.Wishlist;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class WishlistTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(WishlistTest.class);
	private static String testPageData = "WishlistTestData";

	@Test(groups = { "wishlist" }, priority = 20, enabled = true)
	public void addTowishlist() {
		String testName = "addTowishlist";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Adding   Product to  Wishlist  Test Case Started");
		extentTest = extent.startTest("Verify Add a product To WishList");
		Login login = new Login(driver);
		logger.info("Test :: " + testName + " Signing Up to Flipkart Web App");
		
		Wishlist wish = new Wishlist(driver);
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		String keyword = testData.get("keyword");
		wish.search(keyword);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wish.clickWishlist();
		Assert.assertTrue(wish.verifyClick());
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		logger.info("Test :: Adding Product to Wishlist  Test Case Ended");
	}

	@Test(groups = { "wishlist" }, priority = 21, enabled = true)
	public void getProductsInwishlist() {
		String testName = "getProductsInwishlist";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test ::Getting  Product from  Wishlist  Test Case Started");
		extentTest = extent.startTest("Verify Getting  product To WishList");
		Wishlist wish = new Wishlist(driver);
		Login login = new Login(driver);
		logger.info("Test :: " + testName + " Signing Up to Flipkart Web App");
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		wish.gotToWishlist();
		logger.info("Products in the Wishlist");
		List<WebElement> productList = wish.getProductInWishlist();
		logger.info(productList.get(0).getText());
		Assert.assertTrue(productList.size() > 0);
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		logger.info("Test :: Getting  Product from  Wishlist  Test Case Ended");
	}

	/*
	 * @Test(groups = "wishlist") public void removeFromwishlist() { String testName
	 * = "removeFromwishlist"; HashMap<String, String> testData =
	 * fileExcel.getRowTestData(testPageData, testName);
	 * ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
	 * logger.info("Test :: Removing  Product from  Wishlist  Test Case Started");
	 * extentTest = extent.startTest("Verify Remove a product To WishList");
	 * Wishlist wish = new Wishlist(driver); Login login = new Login(driver);
	 * login.entermobileNo(testData.get("mob").replace("\"", ""));
	 * login.enterPassword(testData.get("pwd")); login.click_LoginButton();
	 * wish.gotToWishlist(); wish.removeWishlist(); extent.endTest(extentTest);
	 * logger.info("Test :: Removing  Product from  Wishlist  Test Case Ended"); }
	 */
}
