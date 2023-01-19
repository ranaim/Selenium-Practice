package KpcuPage_Objects;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.SeleniumUtils;
import Utilities.WebDriverFactory;

public class ServicesPage extends SeleniumUtils
{
	By Services_Link = By.xpath("//div[contains(text(),'Services')]/..");
	By services = By.linkText("Services");
	
	By stopPaymentTitle = By.xpath("//h1[text()='Stop Payment']");
	By stopPaymentAmount = By.xpath("//select[@id='M_layout_content_PCDZ_MLY4KCZ_ctl00_stopPaymentAccounts']");	
	By singleCheck = By.xpath("//input[@id='M_layout_content_PCDZ_MLY4KCZ_ctl00_optStateSingle']");
	By rangeOfChecks = By.xpath("//input[@id='M_layout_content_PCDZ_MLY4KCZ_ctl00_optStateRange']");	
	By checkNumber = By.xpath("//input[@id='M_layout_content_PCDZ_MLY4KCZ_ctl00_mvState_checkNumber']");
	By checkAMount = By.xpath("//input[@id='M_layout_content_PCDZ_MLY4KCZ_ctl00_mvState_checkAmount']");
	By reason = By.xpath("//select[@id='M_layout_content_PCDZ_MLY4KCZ_ctl00_ddlReason']");
	By submit = By.xpath("//input[@id='M_layout_content_PCDZ_MLY4KCZ_ctl00_stopPayment']");
		
	By debitCardActivationTitle = By.xpath("//h1[text()='Debit Card Activation']");
	By beginLink = By.xpath("//a[text()='here']");
	
	By amusementParkDiscounts_title = By.xpath("//h1[text()='Amusement Park Discounts']");
	By keyPointMenu = By.xpath("//iframe[@id='M_layout_content_PCDZ_MCI5DC5_ctl00_PageDisplayFrame']");
	
	By turboTaxTitle = By.xpath("//h1[text()='Intuit Turbo Tax']");
	By continueLink = By.xpath("//a[text()='Click here to continue to Turbo Tax']");	
	By backToSummaryLink = By.xpath("//a[strong[text()='Click here to go Back to Account Summary']]");
	
	By CardholderDisputeFormTitle = By.xpath("//h1[text()='Cardholder Dispute Form']");
	By disputeLink = By.xpath("//strong[text()='Cardholder Dispute']/ancestor::a");
	
	
	
	public void verify_stopPayment() throws Exception{
		clickServiceLinkFromMenu();
		click(By.linkText("Stop Payment"),"Stop Payment");
		displayed(stopPaymentTitle, "stopPaymentTitle");
		displayed(stopPaymentAmount, "stopPaymentAmount");
		//waitForElementClickable(singleCheck,5);
		//waitForElementClickable(rangeOfChecks,5);
		displayed(checkNumber, "checkNumber");
		displayed(checkAMount, "checkAMount");
		displayed(reason, "reason");
		displayed(submit, "submit");
	}
	
	public void veriy_DebitCardActivation() throws Exception{		
		clickServiceLinkFromMenu();
		click(By.linkText("Debit Card Activation"),"Debit Card Activation");
		displayed(debitCardActivationTitle, "debitCardActivationTitle");
		click(beginLink,"Click Here for Activate Link");
		switchWindowUsingWindowCount(0,2);		
		String title = WebDriverFactory.getDriver().getTitle();
		boolean bln = title==("KPDebitCard  - Digital Platform");
		//Assert.assertTrue(bln, "KPDebitCard  - Digital Platform is not moved");
		WebDriverFactory.getDriver().close();
		switchWindowUsingWindowCount(0,1);
	}
	
	public void verify_AmusementParkDiscounts()throws Exception {
		clickServiceLinkFromMenu();
		click(By.linkText("Amusement Park Discounts"),"Amusement Park Discounts");
		displayed(amusementParkDiscounts_title,"amusementParkDiscounts_title");
		displayed(keyPointMenu,"keyPointMenu");
		
	}
	
	public void verify_TuboTax() throws Exception {	
		clickServiceLinkFromMenu();
		click(By.linkText("Turbo Tax"),"Turbo Tax");		
		displayed(turboTaxTitle,"turboTaxTitle");		
		displayed(backToSummaryLink,"backToSummaryLink");
		click(continueLink,"continueLink");
		switchWindowUsingWindowCount(0,2);		
		boolean bln = WebDriverFactory.getDriver().getTitle().contains("");
		//Assert.assertTrue(bln, "TurboTax® #1 Best-Selling Tax Software, Taxes Done Right");
		WebDriverFactory.getDriver().close();
		switchWindowUsingWindowCount(0,1);
	}
	
	public void verify_CardHolderDispute()throws Exception {
		clickServiceLinkFromMenu();
		click(By.linkText("Cardholder Dispute"),"Cardholder Dispute");		
		displayed(CardholderDisputeFormTitle,"CardholderDisputeFormTitle");
		click(disputeLink,"disputeLink");	
		/*
		 * switchWindowUsingWindowCount(0,2); switchWindowUsingWindowCount(0,1);
		 */
		
	}
	
	private void clickServiceLinkFromMenu() throws Exception{
		click(Services_Link,"Services Link");
	}
	
	 public void Verify_Services() throws Exception
	    {
	    	select_Bootstrap(Services_Link,"Stop Payment","Stop Payment Link");
			defaultWait(5);			
			Assert.assertTrue(WebDriverFactory.getDriver().getTitle().contains("Stop Payment - KeyPoint Credit Union - online.kpcu.com"), "Stop Payment not displayed");
			
			WebDriverFactory.getDriver().navigate().back();
			
			select_Bootstrap(Services_Link,"Amusement Park Discounts","AmusementParkDiscount not linked");
			defaultWait(5);
			Assert.assertTrue(WebDriverFactory.getDriver().getTitle().contains("Amusement Park Discounts"), "Stop Payment not displayed");
			WebDriverFactory.getDriver().navigate().back();
			
			select_Bootstrap(Services_Link,"Turbo Tax","Turbo Tax Link");
			Assert.assertTrue(WebDriverFactory.getDriver().getTitle().contains("Turbo Tax"), "Do paper Turbo not displayed");
			defaultWait(5);
			WebDriverFactory.getDriver().navigate().back();
			
			select_Bootstrap(Services_Link,"Cardholder Dispute","Cardholder Dispute Link");
			Assert.assertTrue(WebDriverFactory.getDriver().getTitle().contains("Cardholder Dispute"), "caac not displayed");
			
			//AmusementParkDiscount
	    }
	
}
