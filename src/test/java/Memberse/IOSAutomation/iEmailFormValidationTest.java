package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;

public class iEmailFormValidationTest extends IBase {
	
	@Test
	public void iEmailFormValidationTestCase() throws InterruptedException {
		
		IUtilities u = new IUtilities(driver);
		u.Direct2LoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.loginButton().click();
		
		String ValidateEmail = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Email is required\"]").getText();
		System.out.println(ValidateEmail);
		String ValidatePassword = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Password is required\"]").getText();
		System.out.println(ValidatePassword);
		Assert.assertEquals(ValidateEmail, "Email is required");
		Assert.assertEquals(ValidatePassword, "Password is required");
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[2]/XCUIElementTypeTextField").sendKeys("abc@abc");
		String ValidateWrongEmail = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Must be formatted: user@domain.com\"]").getText();
		Assert.assertEquals(ValidateWrongEmail, "Must be formatted: user@domain.com");
	}
	
}
