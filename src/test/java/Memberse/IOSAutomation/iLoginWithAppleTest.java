package Memberse.IOSAutomation;

import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;

public class iLoginWithAppleTest extends IBase {
	
	@Test
	public void iLoginWithAppleTestCase() throws InterruptedException {
		
		IUtilities u = new IUtilities(driver);
		u.Direct2LoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver); 
		lop.appleLogin().click();
		
		Thread.sleep(2000);
		System.out.println("As if this message print in server logs that means Login with Apple Button is clickable and further testing is not possible as Real Apple Id is not able to configure on cloud Service");
	}

}
