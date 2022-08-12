package Memberse.IOSAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.WidgetScreenPage;

public class iLoginWithGoogleTest extends IBase {
	
	@Test
	public void iLoginWithGoogleTestCase() throws InterruptedException {
		
		System.out.println("Wait for application to load");
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Don’t Allow").click();
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithGoogle().click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Continue\"]").click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Next\"]").click();
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[5]").sendKeys("testsingh998@gmail.com");
		driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"Sign in\"`]").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Next\"]").click();
		
		//Input data for Password
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Next\"]").click();
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]").sendKeys("test@123#");
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Enter a password\"]").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Next\"]").click();
		Thread.sleep(1000);
		
		System.out.println("As if this message print in Server Logs, this means Google Button is clickable and furthur Web view is responsive");
		}

}
