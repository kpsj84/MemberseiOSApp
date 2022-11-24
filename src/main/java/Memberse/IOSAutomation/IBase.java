package Memberse.IOSAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IBase {
	
	//Flags use to run Test on different Environment, make it true for where to run. (Testing App on Simulator is not yet working due to signing Profile matter)
		public static boolean sampleTest    = false;
		public static boolean MemberseReal  = false;
		public static boolean MemberseCS    = false;
		public static boolean MemberseCloud = true;
		public static boolean MemberseProd  = false;
		
	
	//Initiate IOS Driver, Appium Driver Service & Desired Capabilities
		public static IOSDriver<IOSElement> 	driver;
		public static AppiumDriverLocalService 	service;
		public static DesiredCapabilities 		cap;
		
	//Starts the Appium Server by checking that Server is already running or not, by calling other Method
		public AppiumDriverLocalService startServer() {
			boolean flag = checkIfServerIsRunnning(4723);
			if(!flag)
			{	
				service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
						  .usingDriverExecutable(new File("/usr/local/bin/node"))
						  .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						  .withIPAddress("127.0.0.1").usingPort(4723));
				service.start();
			}
			return service;
		}
		
	//Checks the Server running status and return boolean value to startServer Method
		public static boolean checkIfServerIsRunnning(int port) {	
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			
			try 
			{
				serverSocket = new ServerSocket(port);		
				serverSocket.close();
			} 
			catch (IOException e) 
			{
				//If control comes here, then it means that the port is in use
				isServerRunning = true;
			} 
			finally 
			{
				serverSocket = null;
			}
			return isServerRunning;
		}

	//Path for Simulator with Terminal command
		public static void startEmulator() throws IOException, InterruptedException {		
			if(MemberseReal == true)
			{
				System.out.println("Test's are running on Real device");
			}
			else if(MemberseCloud == true || MemberseProd == true)
			{
				System.out.println("Simulator is running on cloud");
			}
			else if(MemberseCS == true) 
			{	
				//For CS Server, Active following path of Simulator and uses the same UDID if the Xcode version is same
				Runtime.getRuntime().exec("open -a Simulator --args -CurrentDeviceUDID C1F0A116-CC95-4AD1-9022-C222B2D8D570");
				System.out.println("Simulator is running on CS Soft Server");
			}
			else 
			{
				//Path to run test on local machine Simulator
				Runtime.getRuntime().exec("open -a Simulator --args -CurrentDeviceUDID 5CCC7ABE-5393-477D-9793-AD42F0EE2D5D"); 		//iPhone 13 Pro
			  //Runtime.getRuntime().exec("open -a Simulator --args -CurrentDeviceUDID 82E9C914-0D91-4B7F-AEB4-071DAA2739F5");		//iPhone 12 Mini
				System.out.println("Simulator is running on Local Machine");
			}
		}
		
	//Set Capabilities for IOS driver and get the appName from Iglobal.properties file, pass appName from Test Class (here coming from @BeforeTest Annotation) & name of String Argument can be different in this Method and in Test Class
		public static void capabilities(String appName) throws IOException, InterruptedException {		
			//Path for global properties file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Memberse/IOSAutomation/Iglobal.properties");
			
			Properties prop = new Properties();							//Create object of Properties class  
			prop.load(fis);												//Load global.properties file
			
			//Path to IOS Application File folder
			//File appDir = new File("src/Application");
			File appDir = new File("/Users/kamaljhinjer/Documents/Z-IOS-Memberse-Builds");
			File app = new File(appDir, (String)prop.get(appName)); 	//Assign application file Directory & get appName from Properties class object 
			
			//Device name given in Iglobal.properties file
			String device = (String)prop.get("deviceName");
			if(device.contains("iPhone"))								//Start Emulator
			{
				startEmulator();
			}
			
			//Path of Chrome Driver for WEBVIEW
			String chromeDriver = (System.getProperty("user.dir")+"/src/chromedriver/chromedriver");
			
			//Set Desired Capabilities
			cap = new DesiredCapabilities();
			if(MemberseReal == true)
			{
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");			//Keyword used to run test on real device	
				cap.setCapability("xcodeOrgId", "CGYHFCCU8D"); 							//Provide here Team ID which get by subscribing for developer a/c or get from Team
				cap.setCapability("xcodeSigningId", "iPhone Developer"); 				//Static
				cap.setCapability("udid", "00008101-000808921AB8001E"); 				//By click on iphone name or serial number in Finder, this will show up when iphone connected to Mac via cable
				cap.setCapability("updateWDABundlId", "dog.fa.so.app"); 				//Provide this by creating provision profile from Xcode or get from Team
			}
			else
			{
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);						//Get Device Name from Iglobal.properties file
			}
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");							//Set OS Name
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.6");						//Set OS Version
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());						//Get Application Path
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);	//Set XCUIT to perform action in application
			cap.setCapability("chromedriverExecutable", chromeDriver);								//Get the Path of Chrome Driver
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180); 						//Set time in seconds to wait for next action by WDA, means timeout 180 Seconds = 3 Minutes
			cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 180000); 						//Set timeout as 180 secs = 3 Minutes, This is application Launch timeout
			//cap.setCapability("commandTimeouts", 10000); 											//This is to set timeout for scrolling & other things
			//cap.setCapability("waitForQuiescence", false);
			//cap.setCapability("wdaEventloopIdleDelay", 3);											
			//cap.setCapability("eventLoopIdleDelaySec", 1);
			//cap.setCapability("useNewWDA", false);
			//cap.setCapability("wdaStartupRetries", "4");
			//cap.setCapability("iosInstallPause","8000" );
		}
		
		//Set Cloud Capabilities for IOS driver and get the appName from Iglobal.properties file, pass appName from Test Class (here coming from @BeforeTest Annotation) & name of String Argument can be different in this Method and in Test Class
		public static void cloudCapabilities(String appName) throws IOException, InterruptedException{		
				//This method called just to print the message written in startEmulator()
				startEmulator();
				
				//Path of Chrome Driver for WEBVIEW, It can be different depends on the version of Chrome in Device
				String chromeDriver = (System.getProperty("user.dir")+"/src/chromedriver/chromedriver");
				
				//Set Cloud Desired Capabilities
				cap = new DesiredCapabilities();
				cap.setCapability("browserstack.user", "kamal_BOZ8Ie");									//BrowserStack User Key
				cap.setCapability("browserstack.key", "FJzpiZvMvStzQQNzQHdD");							//BrowserStack Password Key
				//cap.setCapability("app", "bs://77fec00777fc89be3b248e533b1df214a313110d");			//BrowserStack uploaded App reference -> QA build-5.1.2(45)
				//cap.setCapability("app", "bs://0e40e8d451b489c4c75e85492af9c8e94a6edbee");			//BrowserStack uploaded App reference for sample App
				cap.setCapability("app", "MemberseiOSApp");												//This is use of customd_id, Uploaded QA build-35
				//cap.setCapability("app", "kamal_BOZ8Ie/MemberseiOSApp");								//This is use of shareable_is, If team member to test this app w/o password credentials
				cap.setCapability("device", "iPhone 13 Pro");											//BrowserStack Simulator Name
				cap.setCapability("os_version", "15.6");												//BrowserStack Simulator OS info
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);	//BowserStack Type of Automation Reference
				cap.setCapability("chromedriverExecutable", chromeDriver);	
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180); 
				cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 180000);
			}
		
		public static void prodCapabilities(String appName) throws IOException, InterruptedException{		
			startEmulator();
			
			String chromeDriver = (System.getProperty("user.dir")+"/src/chromedriver/chromedriver");
			
			cap = new DesiredCapabilities();
			cap.setCapability("browserstack.user", "kamal_BOZ8Ie");									
			cap.setCapability("browserstack.key", "FJzpiZvMvStzQQNzQHdD");							
			//cap.setCapability("app", "bs://77fec00777fc89be3b248e533b1df214a313110d");			
			//cap.setCapability("app", "bs://0e40e8d451b489c4c75e85492af9c8e94a6edbee");			
			cap.setCapability("app", "MemberseiOSProdApp");											//This is use of customd_id, Uploaded Prod build-5.1.2(38)
			//cap.setCapability("app", "kamal_BOZ8Ie/MemberseiOSProdApp");							//This is use of shareable_is, If team member to test this app w/o password credentials
			cap.setCapability("device", "iPhone 13 Pro");											//BrowserStack Simulator Name
			cap.setCapability("os_version", "15.6");												//BrowserStack Simulator OS info
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);	//BowserStack Type of Automation Reference
			cap.setCapability("chromedriverExecutable", chromeDriver);	
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180); 
			cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 180000);
		}
			
		@BeforeTest
		public void startService() throws IOException, InterruptedException {	
			System.out.println("Entered Before Test, Starting Server & Launching App");
			
			if(MemberseCloud == true || MemberseProd == true)
			{
				System.out.println("Server is running on cloud, so start server manage by cloud itself");
			}
			else
			{
				//Starts the Server before to <test> tag execution in testng.xml file i.e. before to all classes given in xml file
				service=startServer();
			}
			
			//Launch the desired Application by fetching the appName from IGlobal Properties which is according to string argument passed
			if(sampleTest == true) 
			{
				capabilities("sampleApp");	
			}
			else if(MemberseCloud == true)
			{
				cloudCapabilities("MemberseApp");
			}
			else if(MemberseProd == true)
			{
				prodCapabilities("MemberseApp");
			}
			else 
			{
				capabilities("MemberseApp");
			}
		}
		
		@AfterTest
		public void stopService() {		
			System.out.println("Entered After Test & Stoping Server");
			
			if(MemberseCloud == true || MemberseProd == true)
			{
				System.out.println("Server is running on cloud, so stop server manage by cloud only");
			}
			else
			{
				//Stop the service after executing Tests in all Test Classes
				service.stop();
			}
		}
		
		@BeforeClass
		public IOSDriver<IOSElement> startDriver() throws MalformedURLException {
			System.out.println("Entered Before Class & passing capabilities to driver every time the Test's Start in New Class");
			
			if(MemberseCloud == true || MemberseProd == true)
			{
				//IOS Driver is redirect to cloud Service (BrowserStack)
				driver = new IOSDriver<>(new URL("http://hub.browserstack.com/wd/hub"),cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			else
			{
				//Tell IOSDriver where the Appium Server is listening to it
				driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(driver == null) 
				{
					System.out.println("Driver is Null");
				}
			}
			return driver;	
		}
		
		@AfterClass
		public void quitDriver() throws InterruptedException {	
			System.out.println("Execute quiting Driver");
			driver.quit();
		}
		
		@BeforeMethod
		public void beforeMethod() throws IOException, InterruptedException {	
			System.out.println("Entered Before Method, Starting Test");
		}
		
		@AfterMethod
		public void afterMethod() {
			System.out.println("Entered After Method and Confirming the Test code was executed");
		}

}
