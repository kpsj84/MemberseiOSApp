package IOSPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginOptionPage {
	
	public LoginOptionPage(AppiumDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Login']") 
	private WebElement LoginText;
	
	public WebElement LoginText(){    
		return LoginText;
	}
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"Email\"])[3]/XCUIElementTypeTextField") 
	private WebElement signinWithEmail;
	
	public WebElement signinWithEmail(){    
		return signinWithEmail;
	}
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"Password\"])[3]/XCUIElementTypeTextField") 
	private WebElement emailPassword;
	
	public WebElement emailPassword(){    
		return emailPassword;
	}
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"Password\"])[2]/XCUIElementTypeOther[2]") 
	private WebElement revealPassword;
	
	public WebElement revealPassword(){    
		return revealPassword;
	}
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeOther[`label == \"Login\"`]") 
	private WebElement loginButton;
	
	public WebElement loginButton(){    
		return loginButton;
	}

}
