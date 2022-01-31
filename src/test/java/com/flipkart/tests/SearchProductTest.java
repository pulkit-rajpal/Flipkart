package com.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.SearchProduct;

public class SearchProductTest extends BaseTest {

	@Test(priority = 1)
	public void validLogin() {
		SearchProduct search = new SearchProduct(driver);
		extentTest = extent.startTest(
				"Verify that the result that one get after searching for a product is similar to search keyword ");
		search.search("iPhone");
		int result = search.getResults("iPhone");
		extent.endTest(extentTest);
		Assert.assertTrue(result > 5);
		
	}

}
