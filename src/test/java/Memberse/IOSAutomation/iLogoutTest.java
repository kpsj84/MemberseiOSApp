package Memberse.IOSAutomation;

import org.testng.annotations.Test;

import IOSPageObjects.AppMenus;
import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.ProfileMenuPage;
import IOSPageObjects.WelcomePage;
import Memberse.IOSAutomation.IUtilities.Direction;

public class iLogoutTest extends IBase {
	
	@Test
	public void iLogoutTestCase() throws InterruptedException {
		
		System.out.println("Wait for application to load");
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Don’t Allow").click();
		
		WelcomePage wsp = new WelcomePage(driver);
		//wsp.SkipButton().click();
		
		String userNumber = "40";
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
		Thread.sleep(5000);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		IUtilities u = new IUtilities(driver);
		u.swipeScreen(Direction.UP);
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.Logout().click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Yes\"]").click();
		Thread.sleep(5000);
		System.out.println(userName + " Logout Test is Pass");
	}

}
