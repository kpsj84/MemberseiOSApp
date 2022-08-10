package IOSPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AppMenus {
	
	public AppMenus(AppiumDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeButton[1]") 
	private WebElement HomeMenu;
	
	public WebElement HomeMenu(){    
		return HomeMenu;
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeButton[2]") 
	private WebElement ExploreMenu;
	
	public WebElement ExploreMenu(){    
		return HomeMenu;
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeButton[3]") 
	private WebElement ActivitiesMenu;
	
	public WebElement ActivitiesMenu(){    
		return ActivitiesMenu;
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeButton[4]") 
	private WebElement ProfileMenu;
	
	public WebElement ProfileMenu(){    
		return ProfileMenu;
	}

}
