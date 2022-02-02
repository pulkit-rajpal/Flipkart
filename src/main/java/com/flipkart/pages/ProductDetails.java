package com.flipkart.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetails {

	WebDriver driver;

	public ProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//img[@class='_2r_T1I _396QI4']")
	public WebElement img;

	@FindBy(how = How.XPATH, using = "")
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
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> sizElements = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a._1fGeJ5._2UVyXR._31hAvz")));
		WebElement sizElement = sizElements.get(0);
		sizElement.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement wbElement = wait1.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[7]/div[1]/div/div[2]/div[2]/span[2]")));
		WebElement wbElement1 = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a._1fGeJ5._2UVyXR._31hAvz")));
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		System.out.println(wbElement1.getText());
		System.out.println(wbElement.getText().replace("Size:", ""));
		if (wbElement1.getText().compareTo(wbElement.getText().replace("Size:", ""))==0) {
			return true;
		} else {
			return false;
		}
	}
}
