package IOSPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RegisterPage {
	
	public RegisterPage(AppiumDriver<IOSElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@iOSXCUITFindBy(xpath="//*[@name='Email']") 
	private WebElement email;
	
	public WebElement email(){    
		return email;
	}
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"Password\"])[2]/XCUIElementTypeTextField") 
	private WebElement password;
	
	public WebElement password(){    
		return password;
	}
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"Confirm Password\"])[2]/XCUIElementTypeTextField") 
	private WebElement confirmPassword;
	
	public WebElement confirmPassword(){    
		return confirmPassword;
	}
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Agree to Terms and Conditions'`][1]/XCUIElementTypeOther[1]") 
	private WebElement termsCheckbox;
	
	public WebElement termsCheckbox(){    
		return termsCheckbox;
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Continue\"]") 
	private WebElement continueButton;
	
	public WebElement continueButton(){    
		return continueButton;
	}

}
