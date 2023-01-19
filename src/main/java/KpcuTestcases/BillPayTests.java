package KpcuTestcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import KpcuPage_Objects.BillPayPage;
import KpcuPage_Objects.LoginPage;

public class BillPayTests extends BaseTest {

	@Test(groups={"regression"})	
	public void verifyBillPay_Dropdowns() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		BillPayPage billpay = new BillPayPage();
		billpay.verifyBillPay_Dropdowns();
		
	
	}
}
