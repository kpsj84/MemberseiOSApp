package IOSPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WelcomePage {
	
	public WelcomePage(AppiumDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@iOSXCUITFindBy(xpath="//*[@name='Log in']") 
	private WebElement LoginButton;
	
	public WebElement LoginButton(){    
		return LoginButton;
	}
	
	@iOSXCUITFindBy(xpath="//*[@name='Sign up']") 
	private WebElement SignupButton;
	
	public WebElement SignupButton(){    
		return SignupButton;
	}

}
