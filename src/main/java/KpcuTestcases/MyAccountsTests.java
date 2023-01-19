package KpcuTestcases;
import org.testng.annotations.Test;

import KpcuPage_Objects.LoginPage;
import KpcuPage_Objects.MyAccountsPage;
import KpcuPage_Objects.SignInPage;





public class MyAccountsTests extends BaseTest 
{
	
	@Test(groups={"regression"})	
	public void verify_UserTab_ProfileMenu() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		MyAccountsPage account = new MyAccountsPage();
		account.verifyProfileMenu();
	
	}
	
	@Test(groups={"regression"})
	public void verify_UserTab_SettingMenu() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		MyAccountsPage account = new MyAccountsPage();
		account.verifySettingMenu();
	
	}
	
	@Test(groups={"regression"})
	public void verify_UserTab_MessagesMenu() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		MyAccountsPage account = new MyAccountsPage();
		account.verifyMessagesMenu();
	
	}
	
	
	@Test
	public void ValidateAccountSummary() throws Exception
	{		
		LoginPage login = new LoginPage();
		login.Login();
		MyAccountsPage account = new MyAccountsPage();
		account.verifySummaryPage();
		account.gotoAccountPage();
	}
	
////	@Test	
////	public void verify_AcountActivity_Page() throws Exception
////	{
////		LoginPage login = new LoginPage();
////		login.Login();
////		MyAccountsPage account = new MyAccountsPage();
////		account.verifyAccountActivity();		
////	}
	
	@Test
	public void verify_DownloadQuickBooks() throws Exception  {
		LoginPage login = new LoginPage();
		login.Login();
		
		  MyAccountsPage account = new MyAccountsPage(); account.DownloadQuickBooks();
		 
	}

	
	@Test	
	public void verify_Estatements_Page() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		MyAccountsPage account = new MyAccountsPage();
		account.verify_estatements();
	
	}
	
	@Test(groups={"regression"})
	public void verifyFicoScore() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		MyAccountsPage account = new MyAccountsPage();
		account.verifyFicoScore();
	
	}
	
	@Test(groups={"regression"})
	public void Verify_Sign_In_Page() throws Exception
	{		
		SignInPage signin = new SignInPage();
		signin.Verify_KeypointInfo();
	}
	
	@Test(groups={"regression"})
	public void verify_Download_To_Quicken_Dropdowns() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		MyAccountsPage account = new MyAccountsPage();
		account.verify_Download_To_Quicken();	
	}
	@Test(groups={"regression"})
	public void Validate_Download_To_Quicken() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		MyAccountsPage account = new MyAccountsPage();
		account.verify_Download_To_Quicken();	
	}	
	
}
