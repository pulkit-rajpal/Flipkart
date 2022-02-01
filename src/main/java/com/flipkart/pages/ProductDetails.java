package com.flipkart.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {

	WebDriver driver;

	public ProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//img[@class='_2r_T1I _396QI4']")
	public WebElement img;
	
	
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div/div[@class='_2c7YLP UtUXW0 _6t1WkM _3HqJxg']/div[@class='_1YokD2 _2GoDe3']/div[@class='_1YokD2 _3Mn1Gg col-8-12']/div[@class='_1YokD2 _3Mn1Gg']/div[@class='_1AtVbE col-12-12']/div[@class='_3uK0Jr row']/div/div[@class='_1uwxYY']/span[1]")
	public WebElement getSize;

	
	public boolean checkimage() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		return img.isDisplayed();
	}

	public void changecolor() {

	}

	public boolean changeSize() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		String currentHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		for (String handle : handleSet) {
			if (!handle.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		WebElement sizElement = driver.findElements(By.cssSelector("a._1fGeJ5._2UVyXR._31hAvz")).get(0);
		sizElement.click();
		if (sizElement.getText() == getSize.getText()) {return true;};
		return false;
	}
}
