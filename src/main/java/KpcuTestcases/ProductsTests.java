package KpcuTestcases;
import org.testng.annotations.Test;
import KpcuPage_Objects.LoginPage;
import KpcuPage_Objects.ProductsPage;

public class ProductsTests extends BaseTest
{

//	@Test(groups={"regression"})	
//	public void verifyProducts_Dropdowns() throws Exception
//	{
//		LoginPage login = new LoginPage();
//		login.Login();
//		ProductsPage myproducts = new ProductsPage();
//		myproducts.Verify_Products();
//	
//	}
//	
	
	@Test(groups={"regression"})	
	public void validate_OpenAccountLoan() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		ProductsPage myproducts = new ProductsPage();
		myproducts.validate_OpenAccountLoank();
	
	}
	
	@Test(groups={"regression"})	
	public void validate_HomeLoans() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		ProductsPage myproducts = new ProductsPage();
		myproducts.validate_HomeLoans();
	
	}
	
	@Test(groups={"regression"})	
	public void check_ApplicationStatus() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		ProductsPage myproducts = new ProductsPage();
		myproducts.check_ApplicationStatus();
	
	}
	
	@Test(groups={"regression"})	
	public void validate_IRA_HSAS() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		ProductsPage myproducts = new ProductsPage();
		myproducts.validate_IRA_HSAS();
	
	}
	
	@Test(groups={"regression"})	
	public void validate_ViewOffers() throws Exception
	{
		LoginPage login = new LoginPage();
		login.Login();
		ProductsPage myproducts = new ProductsPage();
		myproducts.validate_ViewOffers();
		// page is not available
	
	}
}
