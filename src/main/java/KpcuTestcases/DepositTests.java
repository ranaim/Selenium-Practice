package KpcuTestcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import KpcuPage_Objects.LoginPage;
import KpcuPage_Objects.DepositPage;

public class DepositTests extends BaseTest{
	
	
  @Test(groups={"regression"})	
	public void verify_Deposits() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		DepositPage mydeposit = new DepositPage();
		mydeposit.verifyDeposits_Dropdowns();
	}

	

}
