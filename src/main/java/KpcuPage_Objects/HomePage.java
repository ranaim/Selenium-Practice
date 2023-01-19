package KpcuPage_Objects;


import org.openqa.selenium.By;

import Utilities.SeleniumUtils;


public class HomePage extends SeleniumUtils
{
	By myAccounts = By.xpath("//button[div[text()='My Accounts']]");
	By Overview = By.xpath("//button[div[text()='Overview']]");
	By accountActivity = By.linkText("Account Activity");
	By eStatements = By.linkText("eStatements");
	By ficoScore = By.linkText("FICO® Score");
	
	By billPay = By.linkText("Bill Pay");	
	By moveMoney = By.xpath("//button[div[text()='Move Money']]");
	
	By manageMoney = By.linkText("Manage Money");
	
	
	By products = By.linkText("Products");
	
	By services = By.linkText("Services");
	
	
	By Forms= By.linkText("Forms");
			
	
	By mySetting = By.linkText("My Settings");
	
	
	public void verifyAccountSummary(){
		select_Bootstrap(myAccounts,"Account Summary","Account Summary Link");	
		//displayed();
	}
	
	public void gotoPage(String tabName,String linkName) throws Exception{
		By element = By.xpath("//button[div[text()='"+tabName+"']]");
		select_Bootstrap(element,linkName," Link");
		click(element,linkName+" Link");
	}
	
	public void verifyDashBoard() throws Exception{
		defaultWait(5);
		//click(myAccounts,"My Accounts Tab ");		
			
		
		
		/*select_Bootstrap(myAccounts,"eStatements","Statement Link");
		
		displayed(Overview,"Overview");
		displayed(accountActivity,"accountActivity");
		displayed(eStatements, "eStatements");
		displayed(ficoScore,"ficoScore");
	
		displayed(billPay,"billPay");
		click(billPay,"billPay");
		
		displayed(moveMoney,"moveMoney");
		click(moveMoney,"moveMoney");
		
		displayed(manageMoney,"manageMoney");
		click(manageMoney,"manageMoney");
		
		displayed(products,"products");
		click(products,"products");
		
		displayed(services,"services");
		click(services,"services");
		
		displayed(Forms,"Forms");
		click(Forms,"Forms");
		
		displayed(mySetting,"mySetting");
		click(mySetting,"mySetting");*/	
		
	}
	
	public MoveMoneyPage gotoMoveMoneyPage() throws Exception{
		displayed(moveMoney,"moveMoney");
		click(moveMoney,"moveMoney");
		return new MoveMoneyPage();
	}
	
	public ServicesPage gotServicesPage() throws Exception{
		displayed(services,"Services Link");
		click(services,"Services Link");
		return new ServicesPage();
	}
	
}
