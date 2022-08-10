package IOSPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProfileMenuPage {
	
	public ProfileMenuPage(AppiumDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"User Info View and edit your user information\"])[3]") 
	private WebElement UserInfo;
	
	public WebElement UserInfo(){    
		return UserInfo;
	}

}
