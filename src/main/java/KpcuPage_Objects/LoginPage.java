package KpcuPage_Objects;

import org.openqa.selenium.By;

import Utilities.PropertiesManager;
import Utilities.SeleniumUtils;
import Utilities.WebDriverFactory;

public class LoginPage extends SeleniumUtils{
	
	By userId =  By.id("M_layout_content_PCDZ_MMCA7G7_ctl00_webInputForm_txtLoginName");
	By password = By.id("M_layout_content_PCDZ_MMCA7G7_ctl00_webInputForm_txtPassword");
	By button = By.id("M_layout_content_PCDZ_MMCA7G7_ctl00_webInputForm_cmdContinue");
	By dontSave = By.xpath("//input[@value='Got it']");
	By keypointlogo= By.xpath("//*[@id='page-bottom-container']/footer/div/div[1]/a");
	By ContactCenter= By.xpath("//*[@id=\"Desktop\"]");
	By routing_num= By.xpath("//div[contains(text(),'Routing Number #')]");
	By customer_Service= By.xpath("//div[contains(text(),'Contact Center:')][@id='Desktop']");
	By copyrights= By.xpath("//div[contains(text(),'©')]");
	By equal_housing= By.xpath("//div[contains(text(),'Equal Housing Lender')]");
	By federally_insured= By.xpath("(//div[@class='footer-text']/div[contains(text(),'  ')])[1]");
	By Keypoint_Logo_Header = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/header/div/div[1]/a");
	By UserName_Drop_Down = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/header/div/div[2]/div/div[1]/div/button");
	By Help = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/header/div/div[2]/div/div[2]/button/span");
	By Live_Chat = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/header/div/div[2]/div/div[3]/button/span");
	By Contact_US = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/header/div/div[2]/div/div[4]/a");
	By Log_Out = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/header/div/div[2]/div/div[5]/button/span");
	By Overview_virbeage = By.xpath("//div[@role='dialog']//h2[contains(text(),'Overview')]");
	By closeOverView = By.xpath("(//div[@role='dialog']//button[contains(@aria-label,'Close')])[2]");
	
	
	public HomePage Login(String uName,String password) throws Exception{
		enterText(userId,uName);
		enterText(this.password,password);
		click(button,"LoginButton");
		if(isDisplayed(dontSave))
			click(dontSave,"Dont Save Button");
		return new HomePage();
	}
	
	public HomePage Login() throws Exception{
		String uName = PropertiesManager.sharedConfig("username");
		String password =  PropertiesManager.sharedConfig("password");
		enterText(userId,uName);
		enterText(this.password,password);
		click(button,"LoginButton");
		if(isDisplayed(dontSave))
			click(dontSave,"Dont Save Button");
		return new HomePage();
	}
	
	public HomePage Verify_Footer() throws Exception{
		//displayed(keypointlogo,"Keypoint_Logo_Text");
		displayed(routing_num,"routing_number_Text");
		displayed(customer_Service,"customer_service_number_Text");
		displayed(copyrights,"copy_rights_Text");
		displayed(equal_housing,"Equal_Housing_Lender_Text");
		displayed(federally_insured,"Federally_Insured_Text");
		
		return new HomePage();
		
	}
	
	public HomePage Verify_Header() throws Exception
	{
		displayed(Keypoint_Logo_Header,"Keypoint_Logo_Text_Header");
		//displayed(UserName_Drop_Down,"User_Name_Text");
//		displayed(Help,"Help Link");
//		click(Help,"Help Link");
//		displayed(Overview_virbeage,"overview");
//		click(closeOverView,"Close Overview");	
		
		displayed(Live_Chat,"Live_Chat_Text");
		click(Live_Chat,"Live_Chat_Text");
		switchWindowUsingWindowCount(2, 2);		
		assertText(WebDriverFactory.getDriver().getTitle(), "Patron Facing Chat");
		WebDriverFactory.getDriver().close();
		switchWindowUsingWindowCount(2, 1);	
		
		displayed(Contact_US,"Contact_Us_Text");
		click(Contact_US,"Contact_Us_Text");
		switchWindowUsingWindowCount(2, 2);		
		assertText(WebDriverFactory.getDriver().getTitle(), "Contact Us | California Credit Union | KeyPoint Credit Union");
		WebDriverFactory.getDriver().close();
		switchWindowUsingWindowCount(2, 1);	
		defaultWait(2);
		displayed(Log_Out,"Log_Out_Text");
		
		return new HomePage();
	}
	
}
