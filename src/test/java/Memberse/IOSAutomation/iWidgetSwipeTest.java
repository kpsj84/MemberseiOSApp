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
			
			//App update Continue Button
			driver.findElementByAccessibilityId("Don’t Allow").click();
			System.out.println("Wait for application to load");
			Thread.sleep(8000);
			
			//Create object of Utilities class for Swipe Action
			IUtilities u = new IUtilities(driver);
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("1st Widget Swipe Executed");
			Thread.sleep(2000);
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("2nd Widget Swipe Executed");
			Thread.sleep(2000);
			
			//Skip Button clicked on Widget Screen
			driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Skip\"])[4]").click();
			System.out.println("Last Swipe Executed");
			Thread.sleep(2000);
			
			System.out.println("Landing on Login Options Screen");
			String Text = driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Login']").getText();
			System.out.println(Text);
			
			//Verify the Text available on Login Option Page
			Assert.assertEquals(Text, "Login");
			System.out.println("Swipe Action and Click Action functionality on Widget screens are working as Expected");
			System.out.println("This referes to Smoke Testing as well and its QA Pass");
		}

}
