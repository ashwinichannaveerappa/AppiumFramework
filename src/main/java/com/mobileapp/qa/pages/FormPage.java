package com.mobileapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.mobileapp.qa.base.TestBase;
import com.mobileapp.qa.util.TestUtil;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends TestBase {

	TestUtil testutil;

	public FormPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		testutil = new TestUtil();
	}


	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	WebElement nameField;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	WebElement femaleRadio;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	WebElement btnLetsShop;

	/* Actions */
	public void enterName(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}

	public void clickOnLetsShopButton() {
		btnLetsShop.click();
	}

	public void selectFemale() {
		femaleRadio.click();
	}

	public void selectCountry(String countryName) {
		driver.findElementById("android:id/text1").click();
		testutil.scrollToText(countryName);
		driver.findElementByXPath("//*[@text='"+ countryName+"']").click();

	}
	
}
