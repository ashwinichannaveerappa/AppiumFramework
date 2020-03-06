package com.mobileapp.qa.testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobileapp.qa.base.TestBase;
import com.mobileapp.qa.pages.HomePage;
import com.mobileapp.qa.pages.PreferencesPage;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class HomePageTest extends TestBase {
	
	/* global objects */
	TestBase testBase;
	HomePage homePage;
	AppiumDriverLocalService service;
	public  static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest
	public void setUP() throws IOException, InterruptedException {
		//Runtime.getRuntime().exec("taskkill /F /IM node.exe"); //to kill all nodes before starting the test
		service=getServer();
		homePage=new HomePage();	
		capabiliteis("apiDemo");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		log.info("succss");

	}
	
	@Test
	public void verifyPreference() {
		homePage.clickOnPreference();
	}

	@AfterTest
	public void tearDown() {
		 driver.quit();
		 service.stop();
	}

}
