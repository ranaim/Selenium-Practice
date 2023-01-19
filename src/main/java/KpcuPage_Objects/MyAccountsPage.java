package KpcuPage_Objects;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.SeleniumUtils;
import Utilities.WebDriverFactory;

public class MyAccountsPage extends SeleniumUtils{

	
	By myAccounts = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[1]/button");
	By Overview = By.linkText("Overview");
	By Deposits = By.id("Module-MXWGDOM");
	By EasyPay = By.id("Module-MU09E30");
	By Loans= By.id("Module-M702WF4");	
	By ScheduledBillPayment= By.id("Module-MI15UBA");
	By RecentTransactions= By.id("Module-M3EZK4K");
	By Portfolio= By.id("Module-MFI3COW");
	By messages_menu = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/header/div/div[2]/div/div[1]/div/div/div/ul/li[3]/a");
	By Messages_Title= By.xpath("//*[@id='Module-MATVZ4F']/div[1]/h1");
	
	
	By ficoScore = By.linkText("FICO® Score");
	By FicoScore_Title = By.xpath("//h1[text()='FICO® Score']");
	
	By quicknBooks = By.linkText("Download to Quicken/QuickBooks");
	By quicknBooks_Title = By.xpath("//h1[text()='WebConnect']");
	By accountDropDown = By.xpath("//select[contains(@id,'webInputForm_accountDropDown')]");
	By quickBooksradio = By.xpath("//input[@value='QBO']");
	By startDate = By.xpath("//input[contains(@id,'_webInputForm_calStartDate_TB')]");
	By endDate = By.xpath("//input[contains(@id,'webInputForm_calEndDate_TB')]");
	By downloadBtn = By.xpath("//input[@value='Download']");
	
	By eStatements = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[1]/ul/li[3]/a");
	By statementsLink = By.xpath("/html/body/table/tbody/tr[3]/td[2]/div");
	By DisclosureLink= By.xpath("//a[text()='Disclosure']");
	By Account_Reconciliation= By.xpath("//a[text()='Account Reconciliation']");
	By ProfileLink = By.xpath("//a[text()='Profile']");
	By ExitLink = By.xpath("//a[text()='Exit']");
	By Download_To_Quicken = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[1]/ul/li[3]/a");
	
	
	By accoutnHistory = By.xpath("//h2[normalize-space(text())='Account History']");
	By downloadLink = By.linkText("Download to Quicken/QuickBooks");
	By downloadTitle = By.tagName("h1");
	By accountActivity = By.linkText("Account Activity");	
	
	By accountLink = By.xpath("(//table//button[@type='button'])[1]");
	
	By orderCheckLsink = By.xpath("//span[text()='Order Checks']/..");
	By detailsLink =  By.xpath("//span[text()='Details']/..");
	By statementsLink1 =  By.xpath("//span[text()='eStatements']/..");
	By alertsLinkLink=  By.linkText("Alerts");
	By DownloadLink =  By.xpath("//span[text()='Download']/..");
	By SearchLink =  By.xpath("//span[text()='Search']/..");
	
	// Account Menu
	By userAvtar = By.xpath("//div[@class='user-info-menu-button-container']/button");
	By profileMenu = By.xpath("//button[div[text()='Profile']]");	
	By contactInformation_lnk = By.linkText("Contact Information");
	By UserID_lnk = By.linkText("User ID");
	By Password_lnk = By.linkText("Password");
	By Profile_Picture_lnk = By.linkText("Profile Picture");
	By Income_lnk = By.linkText("Income");
	
	
	By settingsmenu = By.xpath("//button[div[text()='Settings']]");
	By Alerts_lnk = By.linkText("Alerts");
	
	
	By FastBalances_lnk = By.linkText("Fast Balances");
	
	
	By TextBanking_lnk = By.linkText("Text Banking");
	
	
	By ShareAccess_lnk = By.linkText("Share Access");
	
	
	By SessionActivity_lnk = By.linkText("Session Activity");
	
	
	By Disclosures_lnk = By.linkText("Disclosures");
	
	public void clickSettingMenu() throws Exception{
		defaultWait(5);
		click(userAvtar,"userAvtar Menu");
		click(settingsmenu,"settings menu");
	}
	
	public void clickProfileMenu() throws Exception{
		defaultWait(3);
		click(userAvtar,"userAvtar Menu");
		click(profileMenu,"profile Menu");
	}
	
	public void clickMessagesMenu() throws Exception{
		defaultWait(3);
		click(userAvtar,"userAvtar Menu");
		click(messages_menu,"messages Menu");
	}
	
	public void verifyProfileMenu() throws Exception{
		clickProfileMenu();		
		click(contactInformation_lnk,"contactInformation_lnk");
		displayed(By.xpath("(//h1)[1]"),"Address And Phone Number Header");
		displayed(By.xpath("(//h1)[1]"),"Email Address Header");
		displayed(By.name("M$layout$content$PCDZ$MU7KWV5$ctl00$ctl00$webInputForm$grpAddress$Street1"),"Address Input");
		displayed(By.name("M$layout$content$PCDZ$MU7KWV5$ctl00$ctl00$webInputForm$grpAddress$Street2"),"Address2 Header");
		displayed(By.name("M$layout$content$PCDZ$MU7KWV5$ctl00$ctl00$webInputForm$grpAddress$City"),"City input");
		displayed(By.name("M$layout$content$PCDZ$MU7KWV5$ctl00$ctl00$webInputForm$grpAddress$Domestic$State"),"State Dropdown");
		displayed(By.name("M$layout$content$PCDZ$MU7KWV5$ctl00$ctl00$webInputForm$pncHome$0"),"Home input");
		displayed(By.name("M$layout$content$PCDZ$MU7KWV5$ctl00$ctl00$webInputForm$pncMobile$0"),"Mobile Input");
		displayed(By.name("M$layout$content$PCDZ$MU7KWV5$ctl00$ctl00$webInputForm$pncWork$0"),"Work Input");
		displayed(By.xpath("//input[@id='M_layout_content_PCDZ_MU7KWV5_ctl00_ctl00_webInputForm_btnUpdate']"),"Update Button");
				
		clickProfileMenu();
		click(UserID_lnk,"UserID_lnk");
		displayed(By.tagName("h1"),"User ID Header");
		displayed(By.id("M_layout_content_PCDZ_MGMWUCW_ctl00_txtNewLoginName1"),"New User ID Input");
		displayed(By.id("M_layout_content_PCDZ_MGMWUCW_ctl00_txtNewLoginName2"),"Confirm User ID input");
		displayed(By.id("M_layout_content_PCDZ_MGMWUCW_ctl00_cmdConfirm"),"Update Button");
		
		clickProfileMenu();
		click(Password_lnk,"Password_lnk");
		displayed(By.tagName("h1"),"Password Header");
		displayed(By.id("M_layout_content_PCDZ_M22NCVC_ctl00_txtPassword"),"Current Password Input");
		displayed(By.id("M_layout_content_PCDZ_M22NCVC_ctl00_txtNewPassword1"),"New Password Input");
		displayed(By.id("M_layout_content_PCDZ_M22NCVC_ctl00_txtNewPassword2"),"Confirm Password input");
		displayed(By.id("M_layout_content_PCDZ_M22NCVC_ctl00_cmdConfirm"),"Update Button");
		
		
		  clickProfileMenu(); click(Profile_Picture_lnk,"Profile_Picture_lnk");
		  displayed(By.tagName("h1"),"Profile Picture Header");
		  displayed(By.xpath("//button[@class='btn btn-secondary btn-file-picker']"),"Add Prfile Photo Button");
		  //displayed(By.xpath("//div[@class='user-initials-large']"),"Profile Image");
		 
				
		clickProfileMenu();
		click(Income_lnk,"Income_lnk");
		displayed(By.tagName("h1"),"Update Income Header");
		displayed(By.id("M_layout_content_PCDZ_M2HBEIS_ctl00_webInputForm_txtgrossmothlyincome"),"Monthly Income Input");
		displayed(By.id("M_layout_content_PCDZ_M2HBEIS_ctl00_btnSave"),"Save button");
		
		
	}
	
	public void verifySettingMenu() throws Exception{
		clickSettingMenu();
		click(Alerts_lnk,"Alerts_lnk");
		displayed(By.xpath("//h1[normalize-space(text())='Visa Credit and Debit Card Alerts']"),"Visa Credit and Debit Card Alerts Header");
		displayed(By.xpath("//h1[normalize-space(text())='Important Information about Alerts']"),"Important Information About Alerts Header");
		displayed(By.xpath("//h1[normalize-space(text())='Add/Edit an Alert']"),"Add/Edit an Alert Header");
		displayed(By.id("M_layout_content_PCDZ_MBR2NU8_ctl00_webInputForm_lstNotificationTypes-button"),"Alert Type Dropdown");
		displayed(By.id("M_layout_content_PCDZ_MBR2NU8_ctl00_listSubmitButtons"),"Add Subscription Button");
		displayed(By.xpath("//h1[normalize-space(text())='Current Alerts']"),"Current Alerts Header");
		displayed(By.xpath("//h1[normalize-space(text())='Alert History']"),"Alert History Header");		
		displayed(By.xpath("//h1[normalize-space(text())='Current Alerts']"),"Current Alerts Header");
		
		clickSettingMenu();
		click(FastBalances_lnk,"FastBalances_lnk");
		displayed(By.xpath("//h1[normalize-space(text())='Fast Balances Devices']"),"Fast Balances Devices Header");
		displayed(By.id("M_layout_content_PCDZ_MGVY6CL_ctl00_ctl00_btnSave"),"Submit Button");
		displayed(By.id("M_layout_content_PCDZ_MGVY6CL_ctl00_ctl00_btnCancel"),"cancel Button");
		
		clickSettingMenu();
		click(TextBanking_lnk,"TextBanking_lnk");
		displayed(By.xpath("//h1[normalize-space(text())='Text Banking']"),"Text Banking Header");
		//displayed(By.id("M_layout_content_PCDZ_MUMEUQZ_ctl00_ctl00_btnMobileNicknames"),"MobileNicknames Header");
		displayed(By.xpath("//input[@value='Add Phone']"),"Add Phone Button");
				
		clickSettingMenu();
		click(ShareAccess_lnk,"ShareAccess_lnk");
		displayed(By.xpath("//h1[normalize-space(text())='Users']"),"Users Header");
		displayed(By.xpath("//input[@value='Add User']"),"AddUser Button");		
		
		clickSettingMenu();
		click(SessionActivity_lnk,"SessionActivity_lnk");
		displayed(By.xpath("//h1[normalize-space(text())='User Activity']"),"User Activity Header");
		displayed(By.xpath("//tr[@class='table_pagination']"),"Pagination");
		
//		clickSettingMenu();
//		click(Disclosures_lnk,"Disclosures_lnk");
//		displayed(By.xpath("//h1[normalize-space(text())='Details']"),"Details Header");
//		switchToFrame(By.id("disclosureframe"));
//		displayed(By.xpath("//h2[normalize-space(text())='Online Banking Disclosures']"),"Online Banking Disclosures Header");
//		displayed(By.xpath("//h4[contains(text(),'Courtesy Pay Agreement')]"),"Courtesy Pay Agreement Header");
//		displayed(By.xpath("//h4[contains(text(),'Fee Schedule')]"),"Fee Schedule Header");
//		displayed(By.xpath("//h4[contains(text(),'Member Handbooks')]"),"Member Handbooks Header");
//		displayed(By.xpath("//h4[contains(text(),'Truth In Savings (TISA)')]"),"Truth In Savings (TISA) Header");
		
	}	
	
	public void verifyMessagesMenu() throws Exception{
		clickMessagesMenu();
		defaultWait(3);
		displayed(By.xpath("//*[@id='Module-MATVZ4F']/div[1]/h1"),"Messages Title");
		
	}
	
	
	public void verify_FicoScore() throws Exception
	{
		defaultWait(5);
		click(myAccounts,"My Accounts Tab ");
		displayed(ficoScore,"Fico@Score");
		click(ficoScore,"Fico@Score");
		displayed(FicoScore_Title,"FicoScore_Header");
		
	}
	
	public void verifyAccountActivity() throws Exception
	{		
		waitForElementClickable(myAccounts,20);
		click(myAccounts,"My Accounts Tab ");
		displayed(accountActivity,"accountActivity");
		click(accountActivity,"AccountActivity");
		displayed(accoutnHistory,"Account History");		
		click(downloadLink,"Download QuickBooks");
		displayed(downloadTitle,"Download to Quicken/QuickBooks");
	}
	
	public void DownloadQuickBooks() throws Exception {
		defaultWait(3);
		click(myAccounts,"My Accounts Tab ");
		displayed(quicknBooks,"quicknBooks");
		click(quicknBooks,"quicknBooks");
		displayed(quicknBooks_Title,"quicknBooks_Title");	
		
		displayed(accountDropDown,"accountDropDown");	
		displayed(startDate,"startDate");
		displayed(endDate,"endDate");
		//displayed(quickBooksradio,"QuickBooks Radio");
		displayed(downloadBtn,"Downlaod Button");
		
	}
	
	/*public void verify_estatements() throws Exception
	{
		defaultWait(5);
		click(myAccounts,"My Accounts Tab ");
		displayed(eStatements,"Estatements");
		click(eStatements,"Estatements");		
		switchWindowUsingWindowCount(3,2);
		displayed(statementsLink,"Statements");
		displayed(DisclosureLink,"Disclosure");
		displayed(Account_Reconciliation,"AccountReconciliation");
		displayed(ProfileLink,"Profile"); 
		displayed(ExitLink,"Exit");
		WebDriverFactory.getDriver().close();
		switchWindowUsingWindowCount(3,1);
	}*/
	
	public void verifyOverview() throws Exception
	{
		defaultWait(5);
		click(myAccounts,"My Accounts Tab ");
		displayed(Overview,"Overview");
		click(Overview,"Overview");
		displayed(Deposits,"Deposits");
		displayed(EasyPay,"EasyPay");
		displayed(Loans,"Loans");
		displayed(ScheduledBillPayment,"ScheduledBillPayment");
		displayed(RecentTransactions,"RecentTransactions");
		displayed(Portfolio,"Portfolio");
		
	}
	
	
	
	public void verifySummaryPage() throws Exception{
		
		defaultWait(10);
		select_Bootstrap(myAccounts,"Account Summary","Account Summary Link");
		defaultWait(5);
		displayed(By.xpath("(//*[text()='Account Summary'])[2]"),"Account Summary Tittle");
		displayed(By.xpath("(//*[text()='Checking Accounts'])"),"Checking Account Title");
	}
	
	public void verifyFicoScore() throws Exception{
		select_Bootstrap(myAccounts,"FICO® Score","Fico score Link");
		defaultWait(2);
		displayed(By.xpath("//h1[@class='module-title'][text()]"),"Fico Score Title");	
		
	}
	
public void verify_estatements() throws Exception{	
		
		select_Bootstrap(myAccounts,"eStatements","statementsLink");
		switchWindowUsingWindowCount(10,2);
		displayed(By.xpath("//div[@class='head2']"),"eStatement Tittle");
	}
	

public void verify_Download_To_Quicken() throws Exception
{	
	
	select_Bootstrap(myAccounts,"Download to Quicken/QuickBooks","Download To Quicken");
	//switchWindowUsingWindowCount(10,2);
	displayed(By.xpath("//*[@id='Module-M70CWMM']/div[1]/h1"),"Download To Quicken Tittle");
}

public void gotoAccountPage() throws Exception{
	select_Bootstrap(myAccounts,"Account Summary","Account Summary Link");
	click(accountLink,getElement(accountLink).getText()+" Account link");
	validatedetails();
	validateStatements();
	validateAlerts();
	validateDownlaod();
	validateSearch();
}

public void validateOrderChecks()  throws Exception{
	click(orderCheckLsink,"Order Checks Link");
	// pending validation
}

public void validatedetails()  throws Exception{
	//hoverAndClick(detailsLink);
	defaultWait(1);
	click(detailsLink,"Details Link");
	defaultWait(3);
	displayed(By.xpath("//div[@class='modal-dialog']//h3"),"Account Details Header ");
	displayed(By.xpath("(//div[@class='modal-dialog']//span[text()='Account Nickname']/following::div[@class='field-row'])[1]"),"Account NickName ");
	displayed(By.xpath("(//div[@class='modal-dialog']//span[text()='Change Account Nickname']/following::div[@class='field-row'])[1]"),"Change Account ");
	displayed(By.xpath("(//div[@class='modal-dialog']//span[text()='Account Number']/following::div[@class='field-row'])[1]"),"Account Number ");
	displayed(By.xpath("//div[@class='modal-dialog']//button[@aria-label='Close']")," Close Popup");
	click(By.xpath("//div[@class='modal-dialog']//button[@aria-label='Close']")," Close Popup");
	
}

public void validateStatements()  throws Exception{
	//switchWindowUsingWindowCount(1, 1);
	select_Bootstrap(myAccounts,"eStatements","Statements Link");
	//click(statementsLink1,"Statements Link");
	defaultWait(3);
	switchWindowUsingWindowCount(1, 2);
	String title = WebDriverFactory.getDriver().getCurrentUrl();
	Assert.assertTrue(title.contains("kycupilot.infoimageinc.com/home.jsp"));
	//displayed(By.xpath("//div[text()='eStatement']"), "E Statements Header");
	closePage();
	switchWindowUsingWindowCount(1, 1);
//	displayed(By.xpath("//div[@class='modal-dialog']//h3"),"Statement Header ");
//	displayed(By.xpath("//div[@class='modal-dialog']//span[text()='Year']/following::button[1]"),"Year Dropdown");
//	displayed(By.xpath("(//div[@class='modal-dialog']//span[contains(text(),' Statement')])[1]"),"Statement Links Popup");
//	
//	displayed(By.xpath("//div[@class='modal-dialog']//button[@aria-label='Close']")," Close Popup");
//	click(By.xpath("//div[@class='modal-dialog']//button[@aria-label='Close']")," Close Popup");
	
}

public void validateAlerts()  throws Exception{
	click(alertsLinkLink,"Alerts Link");	
	Assert.assertTrue(WebDriverFactory.getDriver().getCurrentUrl().contains("BasicAlerts"), "Alertspage not displayed");	
	displayed(By.xpath("//h1[text()='Visa Credit and Debit Card Alerts']"),"Credit and Debit Card Alerts Headers");
	displayed(By.xpath("//h1[text()='Important Information about Alerts']"),"Important Information about Alerts Header");
	displayed(By.xpath("//select[@id='M_layout_content_PCDZ_MBR2NU8_ctl00_webInputForm_lstNotificationTypes']"),"Alert Type Dropdown");
	displayed(By.xpath("//input[@value='Add Subscription']")," Add Subscription Button");
	displayed(By.xpath("//h1[text()='Current Alerts']")," Current Alerts Header");
	displayed(By.xpath("//h1[text()='Alert History ']"),"Alert History Header");	
	WebDriverFactory.getDriver().navigate().back();
}

public void validateDownlaod()  throws Exception{
	log("Downlaod Validation");
	select_Bootstrap(myAccounts,"Account Summary","Account Summary Link");
	click(accountLink,getElement(accountLink).getText()+" Account link");
	//click(DownloadLink,"Download Link");
	defaultWait(10);
	select_Bootstrap(DownloadLink,"Spreadsheet","Download Spread Sheet");
	
}


public void validateSearch()  throws Exception{
	click(SearchLink,"Search Link");
	displayed(By.xpath("//p[text()='Search']")," Search Header");
	displayed(By.xpath("(//button[@class='btn dropdown-toggle'])[1]"),"Trasaction Dropdown ");
	displayed(By.xpath("(//button[@class='btn dropdown-toggle'])[2]"),"Date Dropdown ");
	displayed(By.xpath("//label[text()='Description']/following::input"),"Description input ");
	displayed(By.xpath("//button[@aria-label='Search']"),"Search Button ");
	displayed(By.xpath("//span[text()='Search by Amount & Check Number']/.."),"Search By Amount and Check Number Link ");
}

}
