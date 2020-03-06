package com.mobileapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileapp.qa.base.TestBase;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	WebElement preference;

	/* To initialize the page objects */
	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/* Actions */
	public void clickOnPreference() {
		preference.click();
	}

}
