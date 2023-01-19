package KpcuPage_Objects;

import org.openqa.selenium.By;

import Utilities.SeleniumUtils;

public class BillPayPage extends SeleniumUtils 
{	
	
	
	By billPay = By.xpath("//div[contains(text(),'Bill Pay')]/..");
	By PaymentCenter = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[2]/ul/li[1]/a");
	By DefaultBillPaymentAccount = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[2]/ul/li[4]/a");
	By Manage_Payments = By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[2]/ul/li[2]/a");
	By PaymentActivity= By.xpath("//*[@id='M_pageTemplateHeader_view']/div/nav/div/div/div/ul/li[2]/ul/li[3]/a");
	
	
	/*public void verify_PaymentCenter() throws Exception
	{
		defaultWait(5);
		displayed(billPay,"billPay");
		click(billPay,"billPay");
		click(PaymentCenter,"Payment Center");
		//displayed(PaymentCenter_Header,"Payment Center Header");
		
	}
	
	public void verify_Manage_Payments() throws Exception
	{
		defaultWait(5);
		displayed(billPay,"billPay");
		click(billPay,"billPay");
		click(Manage_Payments,"Manage Payments");
		//displayed(ManagePayments_Header,"Manage Payment Center");
	}*/

      public void verifyBillPay_Dropdowns() throws Exception
      {	
		
		
		select_Bootstrap(billPay,"Payment Center","Payment Center Link");
		defaultWait(3);
		select_Bootstrap(billPay,"Manage Payments","Manage Payments Link");
		defaultWait(3);
		select_Bootstrap(billPay,"Payment Activity","Payment Activity Link");
		defaultWait(5);
		select_Bootstrap(billPay,"Default Bill Payment Account","Default Bill Payment Account Link");
		
      }
	

	
}
