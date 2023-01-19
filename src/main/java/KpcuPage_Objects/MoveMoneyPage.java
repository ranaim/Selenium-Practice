package KpcuPage_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utilities.PropertiesManager;
import Utilities.SeleniumUtils;
import Utilities.WebDriverFactory;

import org.testng.Assert;

public class MoveMoneyPage extends SeleniumUtils{
	
	By fromAccount = By.xpath("//div/label[contains(text(),'From Account')]/following::select[1]//following-sibling::span[1]/a");
	By toAccount = By.xpath("//div/label[contains(text(),'To Account')]/following::select[1]/following-sibling::span[1]/a");
	By amount = By.xpath("//div/label[text()='Amount']/following::input[1]");
	By schedulingOption = By.xpath("//div/label[contains(text(),'Scheduling Option')]/following::select[1]/following-sibling::span[1]/a");
	By description = By.xpath("//input[contains(@id,'webInputForm_grpEditor_txtDescription')]");
	By submitBtn = By.xpath("//input[contains(@id,'webInputForm_grpEditor_btnSubmit')]");
	By MoveMoney = By.xpath("//div[contains(text(),'Move Money')]/..");
	
	
	
	// Extenal Transfer Controls
	By external_To = By.xpath("//div[@id='unifiedTransfer-toAccount-select']");
	By toOptions = By.xpath("//li[contains(@id,'unifiedTransfer-toAccount-selection-CUSTOMER_ACCOUNT')]");
	By external_From = By.xpath("//div[@id='transferCash-fromAccount-select']");
	By externalAccount = By.xpath("//h3[@id='transferCash-fromAccount-selection-extAccounts-title']");
	
	
	By transferMemberTitle = By.xpath("//h1[text()='Transfer to Member']");
	By settingUpLinkedAccount = By.xpath("(//h2)[1]");
	//By linkedAccountList = By.xpath("(//h2)[2]");
	By addAccount = By.xpath("//button[@aria-label='Add Account']");
	
	
	By transferActivityTitle = By.xpath("//h1[text()='Transfer Activity']");
	By searchPayees = By.xpath("//input[@id='paymentHistory-search']");
	By dateRanges = By.xpath("//div[@id='paymentHistory-select-dateRange']");
	
	By scheduleTrasferTab = By.id("ctl1_scheduledTransfersTab");
	By processedTransfersTab = By.id("ctl1_processedTransfersTab");
	By scheduleTransferColumns = By.xpath("//div[@id='ctl1_scheduledTransfersTab_panel']//th/button");
	By processedTransfersColumns = By.xpath("//div[@id='ctl1_processedTransfersTab_panel']//th/button");
	
	By wireRequestForm = By.id("wiretransfer");
	By courtesypay = By.id("courtesypay");
	By travelnotification = By.id("travelnotification");
	By atmrebate = By.id("atmrebate");
	By checkphotocopy = By.id("checkphotocopy");
	By resetCDrateChangeRequest = By.id("A6");
	
	
	public void populateKeyPointAccounts() throws Exception {
		click(By.linkText("Between KeyPoint Accounts"),"Between KeyPoint Accounts");
		
		String sFromAccount = PropertiesManager.testConfig("FromAccount");
		String sToAccount = PropertiesManager.testConfig("ToAccount");
		String sAmount = PropertiesManager.testConfig("Amount");
		String sSchedulingOption = PropertiesManager.testConfig("SchedulingOption");
		String sDescription = PropertiesManager.testConfig("Description");
		By from = By.xpath("//div/span[contains(text(),'From')]/../following-sibling::div/div/button");
		By to = By.xpath("//div/span[contains(text(),'To')]/../following-sibling::div/div/button");
		By paymentType = By.xpath("//div/span[contains(text(),'Payment Option')]/../following-sibling::div/div/button");
		//By scheduleOption = By.xpath("//div/span[contains(text(),'Schedule')]/following::button[1]");
		By scheduleOption = By.xpath("//div/span[contains(text(),'Schedule')]/../following-sibling::div/div/button");
		
		String options = "//span[text()='arg']/../..//div[@role='listbox']/button";
		click(from, "FromAccount");
		//click(By.xpath("(//div[text()='"+sFromAccount+"'])[1]/../../.."),"["+sFromAccount+ "] From Account Name");
				
		clickByIndex(By.xpath("//div[@role='listbox']/button"),1, "from Account");
		
		click(to,"ToAccount");		
		//click(By.xpath("(//div[text()='"+sToAccount+"'])[2]/../../.."), "["+sToAccount+ "] To Account Name");
		clickByIndex(By.xpath("//span[text()='To']/../..//div[@role='listbox']/button[div]"),2, "To Account");
		
		boolean bln = isDisplayed(paymentType);		
		if(bln) {//choose payment type
			click(paymentType,"paymentType");
			clickByIndex(By.xpath(options.replace("arg", "Payment Option")),1, "PAyment Type");
		}
		
		bln = isDisplayed(amount);	
		if(bln)
			enterText(amount,sAmount);					
			
		//select_Bootstrap(By.xpath("//div/span[contains(text(),'Schedule')]/following::button[1]"), sSchedulingOption, "SchedulingOption");
		//enterText(description,sDescription);
		
		click(scheduleOption,"Schedule Option");		
		click(By.xpath("//button[@role='option'][text()='"+sSchedulingOption+"']"), sSchedulingOption+ "is selected");
		
		click(By.xpath("//button[span[contains(text(),'Continue')]]"),"Continue Button");
		
		defaultWait(3);
		click(By.xpath("//button[@aria-label='Transfer']"),"Transfer Button");
		
	}
	
	public void verifySuccess() throws Exception {
		displayed(By.xpath("//div[@class='alert icon alert-success']"), "Success Toaster Message");
	}
	
	public void populateNonKeyPointAccounts() throws Exception {			
		click(By.linkText("Between Non-KeyPoint Accounts"),"Between Non-KeyPoint Accounts");
		
		switchToFrame(By.xpath("//iframe[contains(@id,'M_layout_content_PCDZ_M38B000_ctl00_PayverisIFrame')]"));
		Wait(30).until(ExpectedConditions.elementToBeClickable(external_To));
		highlightElement(external_To);
		hoverAndClick(external_To);
		//clickJS(external_To, "To Account");
		Wait(30).until(ExpectedConditions.elementToBeClickable(toOptions));
		clickByIndex(toOptions,1, "To Account");
		defaultWait(2);
		//hoverAndClick(external_From);
		defaultWait(2);
		//click(external_From, "From Account");
		//displayed(externalAccount,"External Account");
	}
	
	public void populatePayAnyOne() throws Exception {			
		click(By.linkText("Pay Anyone"),"Pay Anyone");
		
		switchToFrame(By.xpath("//iframe[contains(@id,'M_layout_content_PCDZ_M38B000_ctl00_PayverisIFrame')]"));
		Wait(30).until(ExpectedConditions.elementToBeClickable(external_To));
		highlightElement(external_To);
		hoverAndClick(external_To);
		//clickJS(external_To, "To Account");
		Wait(30).until(ExpectedConditions.elementToBeClickable(toOptions));
		clickByIndex(toOptions,1, "To Account");
		defaultWait(2);
		//hoverAndClick(external_From);
		defaultWait(2);
	}

	public void verifyManageTrasferAccounts() throws Exception {
		click(By.linkText("Manage Transfer Accounts"),"Manage Transfer Accounts");
		try {
			displayed(settingUpLinkedAccount,"Setting Up Button");
			//displayed(linkedAccountList,"Linked Account List Button");
		}catch(Exception e){			
		}
		
	}
	
	public void gotoPage(String linkText) throws Exception {
		click(By.linkText(linkText),linkText+" Button");
		defaultWait(2);
	}
	
	public void addAcount()  throws Exception  {
		defaultWait(2);
		hoverAndClick(addAccount);
	}

	public void verifyTrasferActivity() throws Exception {
		click(By.linkText("Transfer Activity"),"Transfer Activity Button");	
		defaultWait(7);
		displayed(By.xpath("//h1[text()='Transfer Activity']"),"Transfer Activity Header");
		displayed(scheduleTrasferTab,"scheduleTrasfer Tab");
		displayed(processedTransfersTab,"Trasfer History Tab");
		//String[] text = get_All_Text(scheduleTransferColumns);
		defaultWait(2);
		click(processedTransfersTab,"Trasfer History Tab");
		//text =  get_All_Text(processedTransfersColumns);		
		
	}
	
	
	  public void verifyWireTransfers() throws Exception{
	  click(By.linkText("Wire Transfers"),"WireTransfers Button"); defaultWait(1);
	  displayed(By.xpath("//h1[text()='Forms']"),"Forms Header");
	  switchToFrame(By.xpath("//iframe[@src='WireSSO.aspx']"));
	  displayed(wireRequestForm,"wiretransfer");
	  displayed(courtesypay,"courtesypay");
	  displayed(travelnotification,"travelnotification");
	  displayed(atmrebate,"atmrebate"); displayed(checkphotocopy,"checkphotocopy");
	  displayed(resetCDrateChangeRequest,"resetCDrateChangeRequest"); }
	 
	public void verifyWireRequestFormPage()throws Exception {
		click(wireRequestForm,"wiretransfer");
		defaultWait(1);
		switchWindowUsingWindowCount(0, 2);			
		Assert.assertTrue(WebDriverFactory.getDriver().getCurrentUrl().contains("WireTransfer.aspx"));
		/*
		 * displayed(By.id("MainContent_txtDomAmount"), "Amount");
		 * displayed(By.xpath("//input[@value='Send Code']"), "Send Code Button");
		 * displayed(By.xpath("//input[@value='Verify Code']"), "Verify Code Button");
		 */
		closePage();
		switchWindowUsingWindowCount(0, 1);
	}
	
	public void verifyCourtesyPayPage() throws Exception{
		switchToFrame(By.xpath("//iframe[@src='WireSSO.aspx']"));
		click(courtesypay,"courtesypay");
		switchWindowUsingWindowCount(0, 2);		
		closePage();
		switchWindowUsingWindowCount(0, 1);
	}

	public void verifyTravelNotificationPage() throws Exception{
		switchToFrame(By.xpath("//iframe[@src='WireSSO.aspx']"));
		click(travelnotification,"travelnotification");
		switchWindowUsingWindowCount(0, 2);		
		closePage();
		switchWindowUsingWindowCount(0, 1);
		
	}
	public void verifyAtmRebatesPage() throws Exception {
		switchToFrame(By.xpath("//iframe[@src='WireSSO.aspx']"));
		click(atmrebate,"atmrebate");
		switchWindowUsingWindowCount(0, 2);		
		closePage();
		switchWindowUsingWindowCount(0, 1);
	}
	public void verifyPhotoCopyRequestPage() throws Exception {
		switchToFrame(By.xpath("//iframe[@src='WireSSO.aspx']"));
		click(checkphotocopy,"checkphotocopy");
		switchWindowUsingWindowCount(0, 2);		
		closePage();
		switchWindowUsingWindowCount(0, 1);
	}
	public void verifyCDRateRequestPage() throws Exception{
		switchToFrame(By.xpath("//iframe[@src='WireSSO.aspx']"));
		click(resetCDrateChangeRequest,"resetCDrateChangeRequest");
		switchWindowUsingWindowCount(0, 2);		
		closePage();
		switchWindowUsingWindowCount(0, 1);
	}

	
	public void verifyMoveMoney_Dropdowns() throws Exception
    {	
		
		click(By.linkText("Between KeyPoint Accounts"),"Between KeyPoint Accounts Button");
		defaultWait(5);
		click(By.linkText("Manage Transfer Accounts"),"Manage Transfer Accounts Button");
		defaultWait(5);
		click(By.linkText("Between Non-KeyPoint Accounts"),"Between Non-KeyPoint Accounts Button");	
		defaultWait(5);
		click(By.linkText("Pay Anyone"),"Pay Anyone Button");	
		defaultWait(5);
		click(By.linkText("Transfer Activity"),"Transfer Activity Button");	
		defaultWait(5);
		click(By.linkText("Wire Transfers"),"WireTransfers Button");
		
		/*
		 * select_Bootstrap(MoveMoney,"Make a Transfer","Make a Transfer Link");
		 * defaultWait(5);
		 * select_Bootstrap(MoveMoney,"Transfer Approval","Transfer Approval Link");
		 * defaultWait(5);
		 * select_Bootstrap(MoveMoney,"Transfer Activity","Transfer Activity Link");
		 * defaultWait(5);
		 * select_Bootstrap(MoveMoney,"Transfer Accounts","Transfer Accounts Link");
		 */
		
    }
	
}
