package KpcuPage_Objects;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.PropertiesManager;
import Utilities.SeleniumUtils;
import Utilities.WebDriverFactory;


public class SignInPage extends SeleniumUtils  
{
	By usernamefield= By.xpath("//*[@id='M_layout_content_PCDZ_MMCA7G7_ctl00_webInputForm_txtLoginName']");
	By passwordfield= By.xpath("//*[@id='M_layout_content_PCDZ_MMCA7G7_ctl00_webInputForm_txtPassword']");
	By remember_my_userid_Checkbox= By.xpath("//*[@id='M_layout_content_PCDZ_MMCA7G7_ctl00_webInputForm_chkRememberMe_C']/span/span/label");
	By login_button= By.xpath("//*[@id='M_layout_content_PCDZ_MMCA7G7_ctl00_webInputForm_cmdContinue']");
	By forgot_password_Link= By.xpath("//a[contains(@id,'lnkForgotPassword')]");
	By Register_Link= By.linkText("Register");
	By Supported_Browsers_Link= By.linkText("Supported Browsers");
	By Privacy_Policy_Link= By.linkText("Privacy Policy");
	By Disclaimer_Link= By.linkText("Disclaimer");
	By SignIn_Problems_Link= By.linkText("Sign In Problems FAQ");
	By keypoint_footer_logo= By.xpath("//*[@id='page-bottom-container']/footer/div/div[1]/a");
	By keypoint_header_logo= By.xpath("//*[@id=\'M_pageTemplateHeader_view\']/div/header/div/div/a/img");
	By routing_num= By.xpath("//div[contains(text(),'Routing Number')]");
	By customer_Service= By.xpath("//div[contains(text(),'Contact Center')]");
	By copyrights= By.xpath("//div[contains(text(),'©')]");
	By equal_housing= By.xpath("//div[contains(text(),'Equal Housing Lender')]");
	By federally_insured= By.xpath("//div[@class='footer-text'][2]/div[1]");
	By FORGOT_PASSWOD_HEADER= By.xpath("//h1[contains(text(),'Forgot Password')]");
	By CANCEL_Button= By.xpath("//input[@value='Cancel']");
	By Registeration_Header= By.xpath("//h1[text()='Registration']");
	By Edge_Link= By.linkText("Edge");
	By Chrome_Link= By.linkText("Chrome");
	By Firefox_Link= By.linkText("Firefox");
	By Safari_Link= By.linkText("Safari");
	By SingIn_Problems_FAQ = By.xpath("//*[@id='M_layout_content_PCDZ_MO1D65T_ctl00']/div/div/div/h1");
	
	public void Verify_KeypointInfo() throws Exception{
		displayed(usernamefield,"usernamefield_box");
		displayed(passwordfield,"passwordfield_box");
		displayed(remember_my_userid_Checkbox," Remember my Userid checkbox");
		displayed(login_button,"Login button");	
		displayed(forgot_password_Link,"Forgot Password Link");
		click(forgot_password_Link,"Forgot Password Link");
		displayed(FORGOT_PASSWOD_HEADER,"FORGOT PASSWORD TITILE");
		click(CANCEL_Button,"CANCEL Button");	
		displayed(Register_Link,"Register Link");
		click(Register_Link,"Register Link");
		displayed(Registeration_Header,"Registeration Header");
		click(keypoint_header_logo,"Key point Header");
		displayed(Supported_Browsers_Link,"Supported Browser Link");
		click(Supported_Browsers_Link,"Supported Browser Link");
		switchWindowUsingWindowCount(2,2);
		displayed(Edge_Link,"Edge Link");
		displayed(Firefox_Link,"Firefox Link");
		displayed(Chrome_Link,"Chrome Link");
		displayed(Safari_Link,"Safari Link");
		WebDriverFactory.getDriver().close();
		switchWindowUsingWindowCount(2,1);
				
		
		
		// Privacy Policy
		click(Privacy_Policy_Link,"Privacy Policy Link");
		String browserType = PropertiesManager.sharedConfig("browser");
		defaultWait(5);
		if(!browserType.equals("edge")){
			switchWindowUsingWindowCount(2,2);
			defaultWait(2);
			String url = WebDriverFactory.getDriver().getCurrentUrl();
			Assert.assertTrue(url.contains("privacynotice"),"Privacy Notice Page Not Displayed");
			WebDriverFactory.getDriver().close();
			switchWindowUsingWindowCount(1,1);
		}			
		
		//Disclaimer Validation
		click(Disclaimer_Link,"Disclaimer Link");
		defaultWait(2);
		switchWindowUsingWindowCount(2,2);
		defaultWait(5);
		String title = WebDriverFactory.getDriver().getTitle();
		assertText(title,"KeyPoint Credit Union - online.kpcu.com");
		WebDriverFactory.getDriver().close();
		switchWindowUsingWindowCount(1,1);
		
		//sIGN iN pROBLEM Validation
		displayed(SignIn_Problems_Link,"SignIn Problems Link");
		click(SignIn_Problems_Link,"SignIn Problems Link");
		defaultWait(3);		
		switchWindowUsingWindowCount(2,2);
		title = WebDriverFactory.getDriver().getTitle();
		assertText(title,"Sign In Problems FAQ - KeyPoint Credit Union - online.kpcu.com");
		WebDriverFactory.getDriver().close();
		switchWindowUsingWindowCount(1,1);
			
		//displayed(keypoint_footer_logo,"Keypoint_Logo_Text");
		displayed(routing_num,"routing_number_Text");
		displayed(customer_Service,"customer_service_number_Text");
		displayed(copyrights,"copy_rights_Text");
		displayed(equal_housing,"Equal_Housing_Lender_Text");
		displayed(federally_insured,"Federally_Insured_Text");
		
		
		
	}
	
}
