package com.mobileapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileapp.qa.base.TestBase;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferencesPage extends TestBase {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	WebElement preferenceDependecies;

	public PreferencesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/* Actions */
	public void clickOnPreferenceDependices() {
		preferenceDependecies.click();
	}

}
