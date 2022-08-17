package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;

public class iRegisterFormValidationTest extends IBase {
	
	@Test
	public void iRegisterFormValidationTestCase() throws InterruptedException {
		IUtilities u = new IUtilities(driver);
		u.Direct2LoginOptionPage();
		
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
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[2]/XCUIElementTypeTextField").sendKeys("abc@abc");
		String ValidateWrongEmail = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Must be formatted: user@domain.com\"]").getText();
		Assert.assertEquals(ValidateWrongEmail, "Must be formatted: user@domain.com");
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Password\"])[1]/XCUIElementTypeOther[2]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Password\"])[2]/XCUIElementTypeTextField").sendKeys("abc");
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		String ValidatePasswordlength = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Password must be at least 5 characters\"]").getText();
		System.out.println(ValidatePasswordlength);
		Assert.assertEquals(ValidatePasswordlength, "Password must be at least 5 characters");
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Confirm Password\"])[1]/XCUIElementTypeOther[2]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Confirm Password\"])[2]/XCUIElementTypeTextField").sendKeys("xyz");
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		String ValidateConfirmPasswordLength = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Passwords must match\"]").getText();
		System.out.println(ValidateConfirmPasswordLength);
		Assert.assertEquals(ValidateConfirmPasswordLength, "Passwords must match");
	}

}
