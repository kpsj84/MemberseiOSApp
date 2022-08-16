package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.WidgetScreenPage;

public class iRegisterFormValidationTest extends IBase {
	
	@Test
	public void iRegisterFormValidationTestCase() throws InterruptedException {
		System.out.println("Wait for application to load");
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Don’t Allow").click();
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.Register().click();
		
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Continue\"]").click();
		
		String ValidateEmail = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Email is required\"]").getText();
		System.out.println(ValidateEmail);
		String ValidatePassword = driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Password is required\"])[1]").getText();
		System.out.println(ValidatePassword);
		String ValidateConfirmPassword = driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Password is required\"])[2]").getText();
		System.out.println(ValidateConfirmPassword);
		Assert.assertEquals(ValidateEmail, "Email is required");
		Assert.assertEquals(ValidatePassword, "Password is required");
		Assert.assertEquals(ValidateConfirmPassword, "Password is required");
		Thread.sleep(1000);
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[2]/XCUIElementTypeTextField").sendKeys("abc@abc");
		String ValidateWrongEmail = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Must be formatted: user@domain.com\"]").getText();
		Assert.assertEquals(ValidateWrongEmail, "Must be formatted: user@domain.com");
	}

}
