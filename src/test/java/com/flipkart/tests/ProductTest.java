package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.Product;

public class ProductTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(ProductTest.class);

	@Test(priority = 1)
	public void relevantProducts() {
		logger.info("Test :: Relevent Product Test Case Started");
		Product search = new Product(driver);
		extentTest = extent.startTest(
				"Verify that the result that one get after searching for a product is similar to search keyword ");
		search.search("iPhone");
		int result = search.getResults("iPhone");
		extent.endTest(extentTest);
		Assert.assertTrue(result > 5);
		logger.info("Test :: Relevent Product Test Case Ended");

	}

	@Test(priority = 2)
	public void sortProductByPriceHtoL() {
		logger.info("Test :: Sorting By price High to Low  Test Case Started");
		extentTest = extent
				.startTest("Verify that the result are sorted in Descending Price when Sorted from High to Low Price");
		Product search = new Product(driver);
		ReturnToLoginInPage();
		search.search("iPhone");
		search.sortHToL();
		assertEquals(search.verifySort(), "DEC");
		extent.endTest(extentTest);
		logger.info("Test :: Sorting By price High to Low  Test Case Ended");

	}

	@Test(priority = 3)
	public void sortProductByPriceLtoH() {
		logger.info("Test :: Sorting By price Low to High  Test Case Ended");
		extentTest = extent
				.startTest("Verify that the result are sorted in Ascending Price when Sorted from Low to High Price");
		Product search = new Product(driver);
		ReturnToLoginInPage();
		search.search("iPhone");
		search.sortHToL();
		assertEquals(search.verifySort(), "ASC");
		extent.endTest(extentTest);
		logger.info("Test :: Sorting By price Low to High  Test Case Started");

	}

	@Test(priority = 4)
	public void chooseProductBrand() {
		logger.info("Test :: Filter  Product By Brand  Test Case Started");
		extentTest = extent.startTest("Verify that the Brand Filter is working Fine!");
		Product search = new Product(driver);
		ReturnToLoginInPage();
		search.search("mobile");
		search.addbrand("apple");
		extent.endTest(extentTest);
		Assert.assertTrue(search.verifyBrand("apple"));
		logger.info("Test :: Filter  Product By Brand  Test Case Ended");
	}

	@Test(priority = 5)
	public void chooseProductRating() {
		logger.info("Test :: Filter  Product By Rating  Test Case Started");
		extentTest = extent.startTest("Verify that the result that ");
		Product search = new Product(driver);
		ReturnToLoginInPage();
		search.search("mobile");
		search.addRating();
		extent.endTest(extentTest);
		logger.info("Test :: Filter  Product By Rating  Test Case Ended");
	}

}
