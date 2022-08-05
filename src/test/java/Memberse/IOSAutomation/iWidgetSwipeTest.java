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
			
			driver.findElementByAccessibilityId("Don’t Allow").click(); //abc
			
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
			
			driver.findElementByIosClassChain("**/XCUIElementTypeTextField[`value == \"Email\"`]").sendKeys("kqacd@yopmail.com");
			driver.findElementByIosClassChain("**/XCUIElementTypeSecureTextField[`value == \"Password\"`]").sendKeys("kqacd");
			
			driver.findElementByIosClassChain("**/XCUIElementTypeOther[`label == \"Login\"`]").click();
			Thread.sleep(10000);
			driver.findElementByIosClassChain("**/XCUIElementTypeTabBar[`label == \"Tab Bar\"`]/XCUIElementTypeButton[2]").click();
			Thread.sleep(4000);
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"Search for Creators...\"`]").sendKeys("kqacd");
			Thread.sleep(4000);
			driver.findElementByIosClassChain("**/XCUIElementTypeTabBar[`label == \"Tab Bar\"`]/XCUIElementTypeButton[4]").click();
			Thread.sleep(4000);
			System.out.println("Demo Test is completed");
			Thread.sleep(4000);
			
			
			
		}

}
