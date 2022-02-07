package com.flipkart.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.flipkart.utils.FileReadExcel;
import com.flipkart.utils.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public static String name;
	public static String mobNo;
	public static String pwd;
	public static String nameval;
	public static String mob;
	public static String pin;
	public static String invalidpin;
	public static String ad1;
	public static String ad2;
	public static String cty;
	public static String st;

	public static WebDriver driver;
	static File file1 = new File(".\\Resources\\config.properties");
	static File file2 = new File(".\\Resources\\testData.properties");
	static FileInputStream fis1 = null;
	static FileInputStream fis2 = null;
	static Properties prop1 = new Properties();
	static Properties prop2 = new Properties();
	static FileReadExcel fileExcel;
	

	public static final Logger logger = Logger.getLogger(BaseTest.class);

	public static ExtentReports extent;
	public static ExtentTest extentTest;
	static {
		try {
			fis1 = new FileInputStream(file1);
			fis2 = new FileInputStream(file2);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			prop1.load(fis1);
			prop2.load(fis2);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite(groups = { "Login", "Logout", "validlogin", "profile", "cart", "wishlist", "product" })
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\extentreport.html");
		logger.info("Extent Reporting is  Initiated");
		fileExcel = new FileReadExcel(".\\Resources\\TestCasesFile.xlsx");
	}

	/*
	 * @BeforeSuite(groups = { "Login", "Logout", "validlogin", "profile"
	 * ,"cart","wishlist"}) public void getTestData() throws
	 * EncryptedDocumentException, InvalidFormatException, IOException {
	 * FileReadExcel testData = FileReadExcel.getData(); name =
	 * testData.name.replace("\"", ""); mobNo = testData.mobNo.replace("\"", "");
	 * pwd = testData.pwd.replace("\"", ""); nameval =
	 * testData.nameval.replace("\"", ""); mob = testData.mob.replace("\"", ""); pin
	 * = testData.pin.replace("\"", ""); invalidpin =
	 * testData.invalidpin.replace("\"", ""); ad1 = testData.ad1.replace("\"", "");
	 * ad2 = testData.ad2; cty = testData.cty; st = testData.st; }
	 */

	@AfterSuite(groups = { "Login", "Logout", "validlogin", "profile", "cart", "wishlist", "product" })
	public void endReport() {
		extent.flush();
		extent.close();
		logger.info("Extent Reporting  is Finished");
	}

	@BeforeSuite(groups = { "Login", "Logout", "validlogin", "profile", "cart", "wishlist", "product" })
	public static void initializeWebdriver() {
		if (prop1.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty(prop1.getProperty("chromeDriverProperty"), prop1.getProperty("chromeDriverPath"));
			ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		} else if (prop1.getProperty("Browser").equalsIgnoreCase("ie")) {
			System.setProperty(prop1.getProperty("ieDriverProperty"), prop1.getProperty("ieDriverPath"));
			driver = new InternetExplorerDriver();
		} else if (prop1.getProperty("Browser").equalsIgnoreCase("edge")) {
			System.setProperty(prop1.getProperty("edgeDriverProperty"), prop1.getProperty("edgeDriverPath"));
			driver = new EdgeDriver();
		} else if (prop1.getProperty("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty(prop1.getProperty("firefoxDriverProperty"), prop1.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
		}
	}

	@BeforeMethod(groups = { "Login", "Logout", "validlogin", "profile", "cart", "wishlist" })
	public static void navigateToFlipkart(Method m) {
//        Test t = m.getAnnotation(Test.class);
//        System.out.println(t.groups()[0]);//or however you want to use it.
		driver.get(prop1.getProperty("loginurl"));
	}

	@BeforeMethod(groups = { "product" })

	public static void navigateToFlipkartlogin(Method m) {
		driver.get(prop1.getProperty("login"));
	}

	@AfterSuite(groups = { "Login", "Logout", "validlogin", "profile", "cart", "wishlist", "product" })
	public static void closebrowser() {
//		driver.close();
//		driver.quit();
		logger.info("Webdriver is Closed");

	}

	@AfterMethod(groups = { "Login", "Logout", "validlogin", "profile", "cart", "wishlist", "product" })
	public void attachScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Screenshot.captureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extent.endTest(extentTest);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passed Successfully!!!");
		}
	}

	public static void ReturnToLoginInPage() {
		driver.get(prop1.getProperty("login"));
	}

	public static void gottLogoutPage() {
		driver.get(prop1.getProperty("accounturl"));
	}

	public static void gotoCart() {
		driver.get(prop1.getProperty("carturl"));
	}

	public static void gotoWishlist() {
		driver.get(prop1.getProperty("wishlisturl"));
	}

	public static void gotoAddress() {
		driver.get(prop1.getProperty("addressurl"));
	}

}
