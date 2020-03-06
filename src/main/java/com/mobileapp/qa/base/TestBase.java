

/* ***************************************************************************************************
	@creation: 16.02.2020
	@author: Ashwini Matthi Channaveerappa
	@version: 1.0

	TestBase class implements to intialize the Android driver and to launch the application under
	test.
 *****************************************************************************************************/
package com.mobileapp.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestBase {
	/* global variables */
	public static 	AndroidDriver<AndroidElement> driver;
	public static Properties prop;
	public static String userdir=System.getProperty("user.dir");
	public static String Config_File_Path = userdir+"\\"+"\\src\\main\\java\\com\\mobileapp\\qa\\config\\config.properties";
	public static String appPath=userdir+"\\"+"\\APK";
	public static AppiumDriverLocalService service;
	public static String emulatorBatchFilePath=userdir+"\\"+"\\src\\main\\java\\resources\\startEmulator.bat";
	
	/* This constructor reads the properties from config.properties file */
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(Config_File_Path);
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* to start appium server */
	public  AppiumDriverLocalService  getServer() {	
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		  service = AppiumDriverLocalService.buildDefaultService();
		  service.start();
	}
	return service;
	}
	
	/* to start emulator */
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(emulatorBatchFilePath);
		Thread.sleep(8000);
	}
	
	/* to check Server is Running  or not */
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	/**
	* This method is the initialize the Android driver and launch the Cara care application
	* @param DEVICE_NAME,VERSION,platformName,appPackage,appActivity
	 * @throws IOException 
	 * @throws InterruptedException 
	*/
	public static void capabiliteis(String appName) throws IOException, InterruptedException {
		//String deviceName = prop.getProperty("deviceName");
		
		/* to run sent device info through Maven */
		String deviceName = System.getProperty("deviceName");
		String automationName=prop.getProperty("automationName");
		File appDir=new File(appPath);
		File app = new File(appDir,(String)prop.getProperty(appName));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if (deviceName.contains("emulator")) {
			startEmulator();
		} 
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);

		try {
			
	        // Initialize driver

			driver = new AndroidDriver<> (new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			} catch (NullPointerException | MalformedURLException ex) {
            throw new RuntimeException("appium driver could not be initialised for device ");
			}
//		
//		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//		System.out.println("syssc");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
