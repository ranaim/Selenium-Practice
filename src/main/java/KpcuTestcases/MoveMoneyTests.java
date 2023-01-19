package KpcuTestcases;

import org.testng.annotations.Test;

import KpcuPage_Objects.HomePage;
import KpcuPage_Objects.LoginPage;
import KpcuPage_Objects.MoveMoneyPage;

public class MoveMoneyTests extends BaseTest{

	
	
	
	@Test(groups={"regression"}) 
	  public void BetweenKeyPointAccounts() throws Exception{ 
		  	LoginPage login = new LoginPage(); 
	  		HomePage dashboardPage = login.Login(); 
	  		MoveMoneyPage moveMoney= dashboardPage.gotoMoveMoneyPage(); 
	  		moveMoney.populateKeyPointAccounts();	 
	  		moveMoney.verifySuccess();
	  }
	  
	  
	  @Test(groups={"regression"})
	  public void BetweenNonKeyPointAccounts() throws Exception{
		  LoginPage login = new	  LoginPage(); 
		  HomePage dashboardPage = login.Login(); 
		  MoveMoneyPage moveMoney=	  dashboardPage.gotoMoveMoneyPage(); 
		  moveMoney.populateNonKeyPointAccounts(); 
	  }
	 
	  @Test(groups={"regression"})
	  public void PayAnyone() throws Exception{
		  LoginPage login = new	  LoginPage(); 
		  HomePage dashboardPage = login.Login(); 
		  MoveMoneyPage moveMoney=	  dashboardPage.gotoMoveMoneyPage(); 
		  moveMoney.populatePayAnyOne(); 
	  }
	
	  @Test(groups={"regression"}) 
	  public void ManageTrasferAccounts() throws Exception{ 
		  LoginPage login = new LoginPage(); 
		  HomePage dashboardPage = login.Login(); 
		  MoveMoneyPage moveMoney=  dashboardPage.gotoMoveMoneyPage();
		  moveMoney.verifyManageTrasferAccounts();
	  }	  
	  
		
	  @Test(groups={"regression"})
	  public void TrasferActivity() throws Exception{ 
		LoginPage login = new LoginPage();
		HomePage dashboardPage = login.Login();
		MoveMoneyPage moveMoney= dashboardPage.gotoMoveMoneyPage(); 
		moveMoney.verifyTrasferActivity();
	}
	
	  @Test(groups={"regression"})   
	public void WireTransfers() throws Exception{ 
		LoginPage login = new  LoginPage();
		HomePage dashboardPage = login.Login();
		MoveMoneyPage moveMoney= dashboardPage.gotoMoveMoneyPage(); 
		moveMoney.verifyWireTransfers();
		moveMoney.verifyWireRequestFormPage();
		moveMoney.verifyCourtesyPayPage();
		moveMoney.verifyTravelNotificationPage();
		moveMoney.verifyAtmRebatesPage();
		moveMoney.verifyPhotoCopyRequestPage();
		moveMoney.verifyCDRateRequestPage();
	}	 
	 	
	
	
}
