package Memberse.IOSAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class iWidgetSwipeTest extends IBase {
    
  //Represents as one Test Case
	@Test
	public void iWidgetSwipeTestCase() throws InterruptedException {
			//Wait upto for next element to available and will execute immediately once element appear
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElementByAccessibilityId("Don’t Allow").click();
			
			//Create object of Utilities class for Swipe Action
			IUtilities u = new IUtilities(driver);
			System.out.println("Wait for application to load");
			Thread.sleep(2000);
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("1st Widget Swipe Executed");
			Thread.sleep(2000);
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("2nd Widget Swipe Executed");
			Thread.sleep(2000);
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("Last Swipe Executed");
			Thread.sleep(2000);
			
			System.out.println("Landing on Login Options Screen");
			String Text = driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Login']").getText();
			System.out.println(Text);
			//Verify the Maybe later available on Login Option Page
			Assert.assertEquals(Text, "Login");
		}

}
