package IOSPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TutorialScreenPage {
	
	public TutorialScreenPage(AppiumDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"Skip\"])[4]") 
	private WebElement SkipButton;
	
	public WebElement SkipButton(){    
		return SkipButton;
	}
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"Skip Welcome to Memberse A community where Creators and Fans come together to truly support each other like never before. Feeedom to create & consume Creators can share any content they want with their audience, and because their fans are supporting their content, there are no ads, no paywalls, no restrictions. Read: Utopia Creators get paid fairly to do what they love, and fans get unlimited, un-restricted access to 100% uncensored content. It's not a utopia anymore Email Password Horizontal scroll bar, 1 page\"])[6]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther") 
	private WebElement NextButton;
	
	public WebElement NextButton(){    
		return NextButton;
	}

}
