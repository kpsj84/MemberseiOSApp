package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.WidgetScreenPage;

public class iEmailFormValidationTest extends IBase {
	
	@Test
	public void iEmailFormValidationTestCase() throws InterruptedException {
		
		System.out.println("Wait for application to load");
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Don’t Allow").click();
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.loginButton().click();
		
		String ValidateEmail = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Email is required\"]").getText();
		System.out.println(ValidateEmail);
		String ValidatePassword = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Password is required\"]").getText();
		System.out.println(ValidatePassword);
		Assert.assertEquals(ValidateEmail, "Email is required");
		Assert.assertEquals(ValidatePassword, "Password is required");
		Thread.sleep(1000);
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[2]/XCUIElementTypeTextField").sendKeys("abc@abc");
		String ValidateWrongEmail = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Must be formatted: user@domain.com\"]").getText();
		Assert.assertEquals(ValidateWrongEmail, "Must be formatted: user@domain.com");
	}
	
}
