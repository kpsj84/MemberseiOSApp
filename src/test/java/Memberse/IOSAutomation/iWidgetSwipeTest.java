package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.WidgetScreenPage;

public class iWidgetSwipeTest extends IBase {
    
  //Represents as one Test Case
	@Test
	public void iWidgetSwipeTestCase() throws InterruptedException {
			//Wait upto for next element to available and will execute immediately once element appear
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Wait for application to load");
			Thread.sleep(1000);
			
			//App Notification Confirmation Button
			driver.findElementByAccessibilityId("Don’t Allow").click();
			
			//Create object of Utilities class for Swipe Action
			IUtilities u = new IUtilities(driver);
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("1st Widget Swipe Executed");
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("2nd Widget Swipe Executed");
			
			//Skip Button clicked on Widget Screen
			WidgetScreenPage wsp = new WidgetScreenPage(driver);
			wsp.SkipButton().click();
			System.out.println("Last Swipe Executed");
			
			System.out.println("Landing on Login Options Screen");
			LoginOptionPage lop = new LoginOptionPage(driver);
			String Text = lop.LoginText().getText();
			System.out.println(Text);
			
			//Verify the Text available on Login Option Page
			Assert.assertEquals(Text, "Login");
			System.out.println("Swipe Action and Click Action functionality on Widget screens are working as Expected");
			System.out.println("This referes to Smoke Testing as well and its QA Pass");
		}

}
