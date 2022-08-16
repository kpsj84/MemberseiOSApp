package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.AppMenus;
import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.ProfileMenuPage;
import IOSPageObjects.WidgetScreenPage;

public class iRegisterWithEmailTest extends IBase{
	
	@Test
	public void iRegisterWithEmailTestCase() throws InterruptedException {
		System.out.println("Wait for application to load");
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Don’t Allow").click();
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.Register().click();
		
		String userNumber = IUsersDetail.RegisterTestNumber;
		String firstName = "AutoUser"+userNumber;
		String lastName = "QATest"+userNumber;
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		Thread.sleep(2000);
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[3]/XCUIElementTypeTextField").sendKeys(email);
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Password\"])[3]/XCUIElementTypeSecureTextField").sendKeys(password);
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Confirm Password\"])[3]/XCUIElementTypeSecureTextField").sendKeys(password);
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Continue\"]").click();
		Thread.sleep(6000);
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"As a creator Create your own channel and monetize your content.\"])[2]").click();
		Thread.sleep(3000);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		Thread.sleep(2000);
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.UserInfo().click();
		
		String VerifyEmail = driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField").getText();
		Assert.assertEquals(email, VerifyEmail);
		System.out.println("Expected Vs Actual is: "+ email + " Vs " + VerifyEmail);
		System.out.println(firstName + lastName + " Register Test Passed");
	}

}
