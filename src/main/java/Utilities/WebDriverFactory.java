package Utilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

	static WebDriver driver = null;
	
	/*public static WebDriver LaunchDriver() throws Exception{	
		
				
		System.setProperty("webdriver.chrome.driver", "Browserdrivers/chromedriver.exe");
		driver= new ChromeDriver();
		String url = PropertiesManager.sharedConfig(PropertiesManager.getEnvironment()+"_url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		setDriver(driver);
		return driver;
	}*/

	public static WebDriver LaunchRemoteDriver(){
		
		return driver;
	}
	
	public static WebDriver LaunchDriver() throws Exception{	
		String browserType = PropertiesManager.sharedConfig("browser");	
		String deviceName = PropertiesManager.sharedConfig("deviceName");	
		
		switch(browserType.toLowerCase())
		{		 
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "Browserdrivers/chromedriver.exe");				
				Map<String, String> mobileEmulation = new HashMap<>();
				ChromeOptions options = new ChromeOptions();
				if(!deviceName.equals("") ){
					mobileEmulation.put("deviceName", deviceName);	
					options.setExperimentalOption("mobileEmulation", mobileEmulation);
				}				
				driver = new ChromeDriver(options);				
				break;
			/*case "ie":
				System.setProperty("webdriver.ie.driver", "Browserdrivers/IEDriverServer.exe");
				driver= new InternetExplorerDriver();
				break;*/
			case "edge":
				try {
					System.setProperty("webdriver.edge.driver", "Browserdrivers/msedgedriver.exe");
					driver= new EdgeDriver();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
						
				break;
			case "firefox": 
				try {
					//System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");

					System.setProperty("webdriver.gecko.driver","Browserdrivers/geckodriver.exe");
					File pathBinary = new File("C:\\Users\\inazir\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
					FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
					DesiredCapabilities desired = DesiredCapabilities.firefox();
					FirefoxOptions options1 = new FirefoxOptions();
					desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options1.setBinary(firefoxBinary));
					driver = new FirefoxDriver(options1);
					
//					File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox15\\Firefox.exe");
//					FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//					FirefoxProfile firefoxProfile = new FirefoxProfile();
//					driver = new FirefoxDriver(ffBinary,firefoxProfile);
					
//					System.setProperty("webdriver.firefox.bin", "C:\\Users\\inazir\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//					/*
//					 * String Firefoxdriverpath = "Browserdrivers/geckodriver.exe"; //String
//					 * Firefoxdriverpath =
//					 * "C:\\Users\\inazir\\Desktop\\Kpcuweb\\Browserdrivers\\geckodriver.exe";
//					 * System.setProperty("webdriver.gecko.marionette", Firefoxdriverpath);
//					 */
//					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//					capabilities.setCapability("marionette", true);
//					driver = new FirefoxDriver(capabilities);	
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
							
				
				break;
			
		}
		String url = PropertiesManager.sharedConfig(PropertiesManager.getEnvironment()+"_url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		setDriver(driver);
		return driver;
	}
	
	public static WebDriver getDriver() throws Exception{
		if(driver.equals(null))
			return LaunchDriver();
		else
			return driver;
			
	}
	
	public static void setDriver(WebDriver driver){
		WebDriverFactory.driver = driver;		
	}
}
