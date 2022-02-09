package com.flipkart.tests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.ProductDetails;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class ProductDetailsTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(ProductDetailsTest.class);
	private static String testPageData = "ProductDetailsTestData";

	
	
	
	@Test(groups = { "product" }, priority = 11, enabled = true)
	public void checkImageDisplayed() {

		String testName = "checkImageDisplayed";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Check Image of Product Displayed Test Case Started");
		extentTest = extent.startTest("Verify that an Image is Displayed corresponding to a Product");
		ProductDetails prodDetail = new ProductDetails(driver);
		prodDetail.search(testData.get("search"));
		prodDetail.click_product();
		extent.endTest(extentTest);
		extentTest.log(LogStatus.PASS, testName + "Test has Passed");
		Assert.assertTrue(prodDetail.checkimage(), "The Image is Displayed");
		logger.info("Test :: Check Image of Product Displayed Test Case Ended");

	}

	
	
	
	
	@Test(groups = { "product" }, priority = 12, enabled = true)
	public void changeColorofProduct() {
		String testName = "changeColorofProduct";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Check Change color  of Product Displayed Test Case Started");
		extentTest = extent.startTest("Verify that the User can change the Color of the Particular Product Like Shirt");
		ProductDetails prodDetail = new ProductDetails(driver);
		prodDetail.search(testData.get("search"));
		prodDetail.click_product();
		Assert.assertTrue(prodDetail.changecolor());
		extent.endTest(extentTest);
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		logger.info("Test ::Check Change color  of Product Displayed Test Case Ended");
	}

	@Test(groups = { "product" }, priority = 13, enabled = true)
	public void changeSizeofProduct() {
		String testName = "changeSizeofProduct";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Check Change Size  of Product Displayed Test Case Started");
		extentTest = extent.startTest("Verify that the User can change the Size of the Particular Product Like Shirt");
		logger.info("Test :: The Verify Size Change of Product");
		ProductDetails prodDetail = new ProductDetails(driver);
		prodDetail.search(testData.get("search"));
		prodDetail.click_product();
		assertTrue(prodDetail.changeSize());
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		logger.info("Test :: The Verify Size Change of Product has Ended");
		extent.endTest(extentTest);
		logger.info("Test :: Check Change Size  of Product Displayed Test Case Started");
	}

}
