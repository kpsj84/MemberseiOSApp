package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.AppMenus;
import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.ProfileMenuPage;

public class iRegisterWithEmailTest extends IBase{
	
	@Test
	public void iRegisterWithEmailTestCase() throws InterruptedException {
		IUtilities u = new IUtilities(driver);
		u.Direct2LoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.Register().click();
		
		String userNumber = IUsersDetail.RegisterTestNumber;
		String firstName = "AutoUser"+userNumber;
		String lastName = "QATest"+userNumber;
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		Thread.sleep(1000);
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[3]/XCUIElementTypeTextField").sendKeys(email);
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Password\"])[2]/XCUIElementTypeOther[2]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Password\"])[3]/XCUIElementTypeTextField").sendKeys(password);
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Confirm Password\"])[2]/XCUIElementTypeOther[2]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Confirm Password\"])[3]/XCUIElementTypeTextField").sendKeys(password);
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		Thread.sleep(1000);
		driver.findElementByIosClassChain("**/XCUIElementTypeOther[`label == \"Continue\"`][2]").click();
		Thread.sleep(6000);
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"As a creator Create your own channel and monetize your content.\"])[2]").click();
		Thread.sleep(2000);
		
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
