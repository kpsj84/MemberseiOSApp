package Memberse.IOSAutomation;

import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;

public class iLoginWithFacebookTest extends IBase {
	
	@Test
	public void iLoginWithFacebookTestCase() throws InterruptedException {
		IUtilities u = new IUtilities(driver);
		u.Direct2LoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithFacebook().click();
		Thread.sleep(2000);
		
		String email = "qatesting9999@gmail.com";
		String password = "Softqa@1313";
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Continue\"]").click();
		
		//driver.findElementByXPath("//android.widget.Button[@text='Only allow essential cookies']").click();
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField").sendKeys(email);
		driver.findElementByXPath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeSecureTextField").sendKeys(password);
		
		try
		{
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Log In\"]").click();
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		finally
		{
			driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"लॉग इन करा\"])").click();
		}
		
		Thread.sleep(2000);
		System.out.println("As if this message print in Server Logs, this means Facebook Button is clickable and furthur Web view is responsive");
	}

}
