package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.Product;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class ProductTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(ProductTest.class);
	private static String testPageData = "ProductTestData";

	@Test(groups = { "product" }, priority = 6, enabled = true)
	public void relevantProducts() {
		String testName = "relevantProducts";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Relevent Product Test Case Started");
		Product search = new Product(driver);
		extentTest = extent.startTest(
				"Verify that the result that one get after searching for a product is similar to search keyword ");
		search.search(testData.get("keyword"));
		int result = search.getResults(testData.get("brand"));
		extent.endTest(extentTest);
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		Assert.assertTrue(result > 5);
		logger.info("Test :: Relevent Product Test Case Ended");
	}

	@Test(groups = { "product" }, priority = 7, enabled = true)
	public void sortProductByPriceHtoL() {

		String testName = "sortProductByPriceHtoL";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));

		logger.info("Test :: Sorting By price High to Low  Test Case Started");
		extentTest = extent
				.startTest("Verify that the result are sorted in Descending Price when Sorted from High to Low Price");
		Product search = new Product(driver);

		search.search(testData.get("keyword"));
		search.sortHToL();
		assertEquals(search.verifySort(), "DESC");
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		logger.info("Test :: Sorting By price High to Low  Test Case Ended");

	}

	@Test(groups = { "product" }, priority = 8, enabled = true)
	public void sortProductByPriceLtoH() {

		String testName = "sortProductByPriceLtoH";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));

		logger.info("Test :: Sorting By price Low to High  Test Case Ended");
		extentTest = extent
				.startTest("Verify that the result are sorted in Ascending Price when Sorted from Low to High Price");
		Product search = new Product(driver);
		search.search(testData.get("keyword"));
		search.sortLToH();
		assertEquals(search.verifySort(), "ASC");
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		logger.info("Test :: Sorting By price Low to High  Test Case Started");
	}

	@Test(groups = { "product" }, priority = 9, enabled = true)
	public void chooseProductBrand() {
		String testName = "chooseProductBrand";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Filter  Product By Brand  Test Case Started");
		extentTest = extent.startTest("Verify that the Brand Filter is working Fine!");
		Product search = new Product(driver);
		search.search(testData.get("keyword"));
		search.addbrand(testData.get("brand"));
		extent.endTest(extentTest);
		Assert.assertTrue(search.verifyBrand("apple"));
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		logger.info("Test :: Filter  Product By Brand  Test Case Ended");
	}

	@Test(groups = { "product" }, priority = 10, enabled = true)
	public void chooseProductRating() {
		String testName = "chooseProductRating";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Filter  Product By Rating  Test Case Started");
		extentTest = extent.startTest("Verify that the result that Filter  Product By Rating  is achiveable ");
		Product search = new Product(driver);
		search.search(testData.get("keyword"));
		search.addRating();
		extent.endTest(extentTest);
		Assert.assertEquals(driver.getTitle(),
				"Iphone- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");

		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		logger.info("Test :: Filter  Product By Rating  Test Case Ended");
	}
}
