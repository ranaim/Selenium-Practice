package KpcuTestcases;


import org.testng.annotations.Test;

import KpcuPage_Objects.HomePage;
import KpcuPage_Objects.LoginPage;
import KpcuPage_Objects.ServicesPage;;

public class ServicesTests extends BaseTest
{
	
	@Test(groups={"regression"})	
	public void verifyServices_Dropdowns() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login(); 
		ServicesPage servicePage = new ServicesPage(); 		
		servicePage.verify_stopPayment();
		servicePage.veriy_DebitCardActivation();
		servicePage.verify_AmusementParkDiscounts();
		servicePage.verify_TuboTax();
		servicePage.verify_CardHolderDispute();
	}

}
