package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.Product;

public class ProductTest extends BaseTest {

	@Test(priority = 1)
	public void relevantProducts() {
		Product search = new Product(driver);
		extentTest = extent.startTest(
				"Verify that the result that one get after searching for a product is similar to search keyword ");
		search.search("iPhone");
		int result = search.getResults("iPhone");
		extent.endTest(extentTest);
		Assert.assertTrue(result > 5);
	}

	@Test(priority = 2)
	public void sortProductByPriceHtoL() {
		extentTest = extent
				.startTest("Verify that the result are sorted in Descending Price when Sorted from High to Low Price");
		Product search = new Product(driver);
		ReturnToLoginInPage();
		search.search("iPhone");
		search.sortHToL();
		assertEquals(search.verifySort(), "DEC");
		extent.endTest(extentTest);
	}

	@Test(priority = 3)
	public void sortProductByPriceLtoH() {
		extentTest = extent
				.startTest("Verify that the result are sorted in Ascending Price when Sorted from Low to High Price");
		Product search = new Product(driver);
		ReturnToLoginInPage();
		search.search("iPhone");
		search.sortHToL();
		assertEquals(search.verifySort(), "ASC");
		extent.endTest(extentTest);
	}

	@Test(priority = 4)
	public void chooseProductBrand() {
		extentTest = extent.startTest("Verify that the Brand Filter is working Fine!");
		Product search = new Product(driver);
		ReturnToLoginInPage();
		search.search("mobile");
		search.addbrand("apple");
		extent.endTest(extentTest);
		Assert.assertTrue(search.verifyBrand("apple"));
	}

	@Test(priority = 5)
	public void chooseProductRating() {
		extentTest = extent.startTest("Verify that the result that ");
		Product search = new Product(driver);
		ReturnToLoginInPage();
		search.search("mobile");
		search.addRating();
		extent.endTest(extentTest);
	}

}
