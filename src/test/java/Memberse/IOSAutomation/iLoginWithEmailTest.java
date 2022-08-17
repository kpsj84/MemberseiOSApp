package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.AppMenus;
import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.ProfileMenuPage;

public class iLoginWithEmailTest extends IBase{
	
	@Test
	public void iLoginwithEmailTestCase() throws InterruptedException {
		
		IUtilities u = new IUtilities(driver);
		u.Direct2LoginOptionPage();
		
		String userNumber = "iA40";
		String userName = "AutoUser"+userNumber;
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.Email().sendKeys(email);
		lop.LoginText().click();
		lop.revealPassword().click();
		lop.emailPassword().click();
		lop.emailPassword().sendKeys(password);
		lop.LoginText().click();
		lop.loginButton().click();
		Thread.sleep(6000);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.UserInfo().click();
		
		String VerifyEmail = driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField").getText();
		Assert.assertEquals(email, VerifyEmail);
		System.out.println("Expected Vs Actual is: "+ email + " Vs " + VerifyEmail);
		System.out.println(userName + " Login Test Case Passed");
	}

}