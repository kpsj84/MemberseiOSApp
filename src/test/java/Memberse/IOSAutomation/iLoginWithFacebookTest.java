package Memberse.IOSAutomation;

import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.WidgetScreenPage;

public class iLoginWithFacebookTest extends IBase {
	
	@Test
	public void iLoginWithFacebookTestCase() throws InterruptedException {
		System.out.println("Wait for application to load");
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Don’t Allow").click();
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithFacebook().click();
		Thread.sleep(1000);
		
		String email = "qatesting9999@gmail.com";
		String password = "Softqa@1313";
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Continue\"]").click();
		
		//driver.findElementByXPath("//android.widget.Button[@text='Only allow essential cookies']").click();
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField").sendKeys(email);
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeSecureTextField").sendKeys(password);
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Log In\"]").click();
		Thread.sleep(3000);
		
		System.out.println("As if this message print in Server Logs, this means Facebook Button is clickable and furthur Web view is responsive");
	}

}
