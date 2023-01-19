package KpcuTestcases;

import org.testng.annotations.Test;

import KpcuPage_Objects.LoginPage;

public class Dashboard_Tests extends BaseTest
{	
	
	
	@Test(groups={"regression"})
	public void verify_Dashboard_Page() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		login.Verify_Header();
		login.Verify_Footer();
	}


}
