package KpcuPage_Objects;
import org.openqa.selenium.By;
import Utilities.SeleniumUtils;


public class DepositPage extends SeleniumUtils 
{
	By Deposits = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[4]/button/div");
	
	public void verifyDeposits_Dropdowns() throws Exception
    {	
		
		
		select_Bootstrap(Deposits,"Deposit History","Deposit History Link");
		
    }
}
