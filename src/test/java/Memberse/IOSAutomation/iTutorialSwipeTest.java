package Memberse.IOSAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOSPageObjects.LoginOptionPage;
import IOSPageObjects.TutorialScreenPage;

public class iTutorialSwipeTest extends IBase {
    
  //Represents as one Test Case
	@Test
	public void iTutorialSwipeTestCase() throws InterruptedException {
			//Wait up to for next element to available and will execute immediately once element appear
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			System.out.println("Wait for application to load, It may take few seconds to perform first action");
			
			//App Notification Confirmation Button
			driver.findElementByAccessibilityId("Don’t Allow").click();
			
			//Create object of Utilities class for Swipe Action
			IUtilities u = new IUtilities(driver);
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("1st Widget Swipe Executed");
			
			u.swipeScreen(IUtilities.Direction.LEFT);
			System.out.println("2nd Widget Swipe Executed");
			
			//Next Button
			//TutorialScreenPage tsp = new TutorialScreenPage(driver);
			//tsp.NextButton().click();
			
			//Skip Button clicked on Widget Screen
			TutorialScreenPage tsp = new TutorialScreenPage(driver);
			tsp.SkipButton().click();
			System.out.println("Last Swipe Executed");
			
			System.out.println("Landing on Login Options Screen");
			LoginOptionPage lop = new LoginOptionPage(driver);
			String Text1 = lop.LoginText().getText();
			System.out.println(Text1);
			String Text2 = lop.BottomText().getText();
			System.out.println(Text2);
			
			//Verify the Text available on Login Option Page
			Assert.assertEquals(Text1, "Login");
			Assert.assertEquals(Text2, "New to Memberse?");
			
			System.out.println("Swipe Action and Click Action functionality on Tutorial Screens are working as Expected");
			System.out.println("This referes to Smoke Testing as well and its QA Pass");
		}

}
