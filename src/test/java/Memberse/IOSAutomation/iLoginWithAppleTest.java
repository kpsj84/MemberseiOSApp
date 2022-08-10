package Memberse.IOSAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.WidgetScreenPage;

public class iLoginWithAppleTest extends IBase {
	
	@Test
	public void iLoginWithAppleTestCase() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//App update Continue Button
		driver.findElementByAccessibilityId("Don’t Allow").click();
		System.out.println("Wait for application to load");
		Thread.sleep(5000);
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver); 
		lop.appleLogin().click();
		
		Thread.sleep(3000);
		System.out.println("As if this message print in server logs that means Login with Apple Button is clickable as further testing is not possible as Real Apple Id is not able to configure on cloud Service");
	}

}
