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
	private WebElement Email;
	
	public WebElement Email(){    
		return Email;
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
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Login\"`]") 
	private WebElement loginButton;
	
	public WebElement loginButton(){    
		return loginButton;
	}
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeOther[`label == \"Login Email Password Forgot Password? Login OR New to Memberse? Register\"`][2]/XCUIElementTypeOther[6]/XCUIElementTypeOther[1]") 
	private WebElement appleLogin;
	
	public WebElement appleLogin(){    
		return appleLogin;
	}
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeOther[`label == \"Login Email Password Forgot Password? Login OR New to Memberse? Register\"`][2]/XCUIElementTypeOther[6]/XCUIElementTypeOther[2]") 
	private WebElement signinWithGoogle;
	
	public WebElement signinWithGoogle(){    
		return signinWithGoogle;
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Continue']") 
	private WebElement GoogleLoginConfirmation;
	
	public WebElement GoogleLoginConfirmation(){    
		return GoogleLoginConfirmation;
	}
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeOther[`label == \"Login Email Password Forgot Password? Login OR New to Memberse? Register\"`][2]/XCUIElementTypeOther[6]/XCUIElementTypeOther[3]") 
	private WebElement signinWithFacebook;
	
	public WebElement signinWithFacebook(){    
		return signinWithFacebook;
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Continue']") 
	private WebElement FacebookLoginConfirmation;
	
	public WebElement FacebookLoginConfirmation(){    
		return FacebookLoginConfirmation;
	}
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Register\"]") 
	private WebElement Register;
	
	public WebElement Register(){    
		return Register;
	}

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"New to Memberse?\"]") 
	private WebElement BottomText;
	
	public WebElement BottomText(){    
		return BottomText;
	}
	
}
