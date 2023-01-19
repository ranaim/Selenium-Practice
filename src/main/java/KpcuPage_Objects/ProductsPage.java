package KpcuPage_Objects;
import org.openqa.selenium.By;

import Utilities.PropertiesManager;
import Utilities.SeleniumUtils;

public class ProductsPage extends SeleniumUtils
{
	
	By Products_Link = By.xpath("//div[contains(text(),'Products')]/..");
	By Open_Account= By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[5]/ul/li[1]/a");
    By HomeLoans = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[5]/ul/li[2]/a");
    By Check_Application_Status = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[5]/ul/li[3]/a");
    By IRAS_HSAs = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[5]/ul/li[3]/a");
    By ViewOffers= By.xpath("//*[@id='M_pageTemplateHeader_vie']/div/nav/div/div/div/ul/li[5]/ul/li[5]/a");
    
    // validate_OpenAccountLoank
    By vehiclLoansLink = By.linkText("Vehicle Loan");
    By creditCardLink = By.linkText("Credit Card");
    By personalLoanLink = By.linkText("Personal Loan");
    By newAdditionalAccountLink = By.linkText("New Additional Account");
    By depositeRatesLink = By.linkText("Deposit Rates");
    By loanRateLink = By.linkText("Loan Rates");
    
    // validate_HomeLoans
    By firstMortgageLink = By.linkText("First Mortgage");
    By homeEquityLoanLink = By.linkText("Home Equity Loan");
    By homeEquityLineofCreditLink = By.linkText("Home Equity Line of Credit");
    By homeLoansLink = By.linkText("Home Loans");
    By homeEquityLoansLink = By.linkText("Home Equity Loans");
    By homeEquityLineofCreditRatesLink = By.linkText("Home Equity Line of Credit Rates");
    
    //check_ApplicationStatus
    By firstMortgageAndHomeEquityLink = By.linkText("First Mortgage and Home Equity");
    By allOtherProductsLink = By.linkText("All Other Products");   
    
    
    //validate_IRA
    By retirementCentralLink = By.linkText("Retirement Central");
    By healthSavingsAccountLink = By.linkText("Health Savings Account");
    
    //validate_ViewOffers
    
    public void Verify_Products()
    {
    	select_Bootstrap(Products_Link,"Open Account/Loan","Open Account/Loan Link");
		defaultWait(5);
    	
		select_Bootstrap(Products_Link,"Home Loans","Home Loans Link");
		defaultWait(5);
		
		select_Bootstrap(Products_Link,"Check Application Status","Check Application Status Link");
		defaultWait(5);
		
		select_Bootstrap(Products_Link,"IRAs & HSAs","IRAs & HSAs Link");
		defaultWait(5);
		
		select_Bootstrap(Products_Link,"View Offers","View Offers Link");
		
    }
    
    public void validate_OpenAccountLoank() throws Exception {
    	select_Bootstrap(Products_Link,"Open Account/Loan","Open Account/Loan Link");
    	click(vehiclLoansLink,"vehiclLoansLink");
    	defaultWait(3);
    	SwitchToNewPage();
    	displayed(By.xpath("//div[text()='Vehicle Loan']"), "Vehicle Loan Header ") ;
    	SwitchToMainPage();
    	
    	select_Bootstrap(Products_Link,"Open Account/Loan","Open Account/Loan Link");
    	click(creditCardLink,"creditCardLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//div[text()='Credit Cards']"), "Credit Cards Header ") ;    	
    	SwitchToMainPage();
    	
    	select_Bootstrap(Products_Link,"Open Account/Loan","Open Account/Loan Link");
    	click(personalLoanLink,"personalLoanLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//div[text()='Personal Loan/Line of Credit']"), "Personal Loan/Line of Credit Header ") ;  
    	SwitchToMainPage();
    	
    	select_Bootstrap(Products_Link,"Open Account/Loan","Open Account/Loan Link");
    	click(newAdditionalAccountLink,"newAdditionalAccountLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//div[text()='Open An Additional Account']"), "Open An Additional Account") ;  
    	SwitchToMainPage();
    	
    	select_Bootstrap(Products_Link,"Open Account/Loan","Open Account/Loan Link");
    	click(depositeRatesLink,"depositeRatesLink");
    	if(!PropertiesManager.sharedConfig("browser").contains("edge")) {
    		SwitchToNewPage();
        	SwitchToMainPage();
    	}    	
    	
    	select_Bootstrap(Products_Link,"Open Account/Loan","Open Account/Loan Link");
    	click(loanRateLink,"loanRateLink");
    	
		/*
		 * SwitchToNewPage(); SwitchToMainPage();
		 */
    }
    
    public void validate_HomeLoans() throws Exception  {
    	select_Bootstrap(Products_Link,"Home Loans","Home Loans Link");
    	click(firstMortgageLink,"firstMortgageLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//button[text()='Continue']"), "Continue Button") ;
    	SwitchToMainPage();
    	
    	select_Bootstrap(Products_Link,"Home Loans","Home Loans Link");
    	click(homeEquityLoanLink,"homeEquityLoanLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//button[text()='Continue']"), "Continue Button") ;
    	SwitchToMainPage();
    	
    	
    	select_Bootstrap(Products_Link,"Home Loans","Home Loans Link");
    	click(homeEquityLineofCreditLink,"homeEquityLineofCreditLink");
    	SwitchToNewPage();
    	//displayed(By.xpath("//div[text()='Home Equity Line of Credit']"), "'Home Equity Line of Credit' Header") ;
    	SwitchToMainPage();
    	
    	
    	select_Bootstrap(Products_Link,"Home Loans","Home Loans Link");
    	click(homeLoansLink,"homeLoansLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//h1[text()='Home Loans']"), "Home Loans Header") ;
    	SwitchToMainPage();
    	
    	
    	select_Bootstrap(Products_Link,"Home Loans","Home Loans Link");
    	click(homeEquityLoansLink,"homeEquityLoansLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//h1[text()='Home Equity Loan']"), "Home Equity Loan Header") ;
    	SwitchToMainPage();
    	
    	
    	select_Bootstrap(Products_Link,"Home Loans","Home Loans Link");
    	click(homeEquityLineofCreditRatesLink,"homeEquityLineofCreditRatesLink");    
    	String browserType = PropertiesManager.sharedConfig("browser");	
    	if(!browserType.equals("edge")) {
    		SwitchToNewPage();    	
        	SwitchToMainPage();
    	}
    }
    
    public void check_ApplicationStatus()throws Exception  {
    	select_Bootstrap(Products_Link,"Check Application Status","Check Application Status Link");
    	click(firstMortgageAndHomeEquityLink,"firstMortgageAndHomeEquityLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//h1[text()='Sign in to your account']"), "Sign in to your account Header") ;
    	SwitchToMainPage();
    	
    	select_Bootstrap(Products_Link,"Check Application Status","Check Application Status Link");
    	click(allOtherProductsLink,"allOtherProductsLink");
    	SwitchToNewPage();
    	//displayed(By.xpath("//button[text()='Continue']"), "Continue Button") ;
    	SwitchToMainPage();
    	
    }
    
    public void validate_IRA_HSAS() throws Exception {
    	select_Bootstrap(Products_Link,"IRAs & HSAs","IRAs & HSAs Link");
    	click(retirementCentralLink,"retirementCentralLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//h1[text()='Retirement Central']"), "Retirement Central Header") ;
    	SwitchToMainPage();
    	
    	select_Bootstrap(Products_Link,"IRAs & HSAs","IRAs & HSAs Link");
    	click(healthSavingsAccountLink,"healthSavingsAccountLink");
    	SwitchToNewPage();
    	displayed(By.xpath("//h1[text()='Health Savings Accounts']"), "Health Savings Accounts Header") ;
    	SwitchToMainPage();
    }
    
    public void validate_ViewOffers() throws Exception {
    	select_Bootstrap(Products_Link,"View Offers","View Offers Link");
    	//pending page not available
    }   
    
}
