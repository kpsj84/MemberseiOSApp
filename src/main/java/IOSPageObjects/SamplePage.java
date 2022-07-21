package IOSPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SamplePage {
	
	public SamplePage(AppiumDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@iOSXCUITFindBy(accessibility="Alert Views") 
	private WebElement AlertViewsButton;
	
	public WebElement AlertViewsButton(){    
		return AlertViewsButton;
	}

}
