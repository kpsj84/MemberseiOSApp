package Memberse.IOSAutomation;

import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.WidgetScreenPage;

public class iLoginWithAppleTest extends IBase {
	
	@Test
	public void iLoginWithAppleTestCase() throws InterruptedException {
		
		System.out.println("Wait for application to load");
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Don’t Allow").click();
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver); 
		lop.appleLogin().click();
		
		Thread.sleep(1000);
		System.out.println("As if this message print in server logs that means Login with Apple Button is clickable and further testing is not possible as Real Apple Id is not able to configure on cloud Service");
	}

}
