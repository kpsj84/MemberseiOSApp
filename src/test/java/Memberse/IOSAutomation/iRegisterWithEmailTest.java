package Memberse.IOSAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.AppMenus;
import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.ProfileMenuPage;

import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class iRegisterWithEmailTest extends IBase{
	
	@Test
	public void iRegisterWithEmailTestCase() throws InterruptedException {
		IUtilities u = new IUtilities(driver);
		u.Direct2LoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.Register().click();
		Thread.sleep(1000);
		
		String autoString = getSaltString();
		String emailDomain = "@yopmail.com";
		String email = autoString+emailDomain;
		String password = "12345";
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[3]/XCUIElementTypeTextField").sendKeys(email);
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Password\"])[2]/XCUIElementTypeOther[2]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Password\"])[3]/XCUIElementTypeTextField").sendKeys(password);
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Confirm Password\"])[2]/XCUIElementTypeOther[2]").click();
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Confirm Password\"])[3]/XCUIElementTypeTextField").sendKeys(password);
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign up\"]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Continue\"]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"OK\"]").click();
		Thread.sleep(1000);
		
		IOSTouchAction t = new IOSTouchAction(driver);
		@SuppressWarnings("rawtypes")
		PointOption Coordinates = PointOption.point(42,544);
		t.press(Coordinates).perform();
		
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Continue\"]").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"As a Creator Start your Community and invite Members to enjoy your content!\"])[2]").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@text='Next']").click();
		driver.findElementByXPath("//*[@name='Next']").click();
		driver.findElementByXPath("//*[@name='Next']").click();
		driver.findElementByXPath("//*[@name='Close']").click();
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		Thread.sleep(2000);
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.UserInfo().click();
		
		String VerifyEmail = driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Email\"])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField").getText();
		Assert.assertEquals(email, VerifyEmail);
		System.out.println("Expected Vs Actual is: "+ email + " Vs " + VerifyEmail);
		System.out.println(email + " Register Test Passed");
	}

	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
