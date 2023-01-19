package KpcuTestcases;


import java.lang.reflect.Method;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import KpcuPage_Objects.LoginPage;
import Utilities.ExtentReport;
import Utilities.GlobalParams;
import Utilities.SeleniumUtils;
import Utilities.WebDriverFactory;

public class BaseTest 
{	
	/*@Test(groups={"regression"})*/
	
	@BeforeSuite(alwaysRun = true)
	public void BeforeSuit() throws Exception{
		ExtentReport.getReporter();
	}
	
	@AfterSuite(alwaysRun = true)
	public void AfterSuite() throws Exception{
		ExtentReport.getReporter().flush();	
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method result) throws Exception
	{
		String className = this.getClass().getSimpleName();
		String name = result.getName();
		//String name = result.getTestClass().getRealClass().getSimpleName()  ;
		
		/*Method method = result.getMethod().getConstructorOrMethod().getMethod();
		Test test = method.getAnnotation(Test.class);
		String testname = test.testName();
		
		String name = result.getMethod().getMethodName();*/		
		GlobalParams.setTestName(name);
		ExtentReport.startTest(className+" - "+name,name);
		/*ExtentReport.startTest(result.getTestClass().getRealClass().getSimpleName() + " : " + GlobalParams.getTestName()
		, result.getMethod().getDescription())
		.assignCategory();*/
		WebDriverFactory.LaunchDriver();
		
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws Exception {		
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("[Failed] : "+GlobalParams.getTestName());
			ExtentReport.getTest().fail(result.getThrowable());
			try {					
				String fileName = SeleniumUtils.takeScreenshot(result.getTestName());
				ExtentReport.getTest().addScreenCaptureFromPath(fileName);
				ExtentReport.getTest().log(Status.FAIL, result.getThrowable().getMessage());			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ExtentReport.getReporter().flush();	
		ExtentReport.test = null;
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception
	{
		WebDriverFactory.getDriver().quit();
	}
	
	@AfterSuite
	public void open() throws Exception{
		//Runtime.getRuntime().exec(new String[]{"cmd","/c","start chrome "+ExtentReport.fileFullPath});

		//ExtentReport.getReporter().flush();	
	}
	

}
