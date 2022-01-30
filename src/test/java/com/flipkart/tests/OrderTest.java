package com.flipkart.tests;

import org.testng.annotations.Test;

import com.flipkart.pages.Order;

public class OrderTest extends BaseTest {

	@Test
	public void searchProduct() {
		Order order = new Order(driver);
	}

}
