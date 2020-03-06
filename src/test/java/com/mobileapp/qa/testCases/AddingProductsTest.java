package com.mobileapp.qa.testCases;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mobileapp.qa.base.TestBase;
import com.mobileapp.qa.pages.FormPage;
import com.mobileapp.qa.util.TestUtil;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AddingProductsTest extends TestBase {
	
	TestBase testBase;
	FormPage formPage;
	AppiumDriverLocalService service;
	public  static Logger log = LogManager.getLogger(AddingProductsTest.class.getName());
	String sheetName="contacts";

	@BeforeMethod
	public void launchapp() throws IOException, InterruptedException {
		//Runtime.getRuntime().exec("taskkill /F /IM node.exe"); //to kill all nodes before starting the test
		service=getServer();
		testBase= new TestBase();
		formPage=new FormPage();
		capabiliteis("generalStore");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		log.info("application launched successfully");
		}
	
	public AddingProductsTest() {
		//to call TestBase Class constructor
		super();
		}
	
	//@Test(priority = 1, dataProvider = "getNames")
	@Test
	public void loginForm() throws MalformedURLException {
		//formPage.selectCountry("Argentina");
		formPage.enterName("firstName");
	}
	
//	@DataProvider
//	public Object[][] getNames() throws EncryptedDocumentException, IOException{
//		Object data[][]=TestUtil.getTestData(sheetName);
//		return data;
//	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		 service.stop();
	}
}
