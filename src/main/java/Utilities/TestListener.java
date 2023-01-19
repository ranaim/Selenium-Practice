package Utilities;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReport.getTest().fail(result.getThrowable());
		try {	
			//System.out.println("[Failed] : "+GlobalParams.getTestName());
			String fileName = SeleniumUtils.takeScreenshot(result.getTestName());
			ExtentReport.getTest().addScreenCaptureFromPath(fileName);
			ExtentReport.getTest().log(Status.FAIL, result.getThrowable().getMessage());			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		try {
			ExtentReport.startTest(result.getTestClass().getRealClass().getSimpleName() + " : " + GlobalParams.getTestName()
					, result.getMethod().getDescription())
			.assignCategory(GlobalParams.getTestName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sName = "^^^^^^^^^^^^^^^^ Test Name : "+ GlobalParams.getTestName()+"  ^^^^^^^^^^^^^^^^ ";
		getString(sName);
		System.out.println(sName);
		getString(sName);
	}
	private void getString(String str){
		char[] ch = str.toCharArray();
		for(int i=0;i<ch.length;i++)
			System.out.print("=");
		System.out.println();
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test Passed");
		System.out.println("[Pass] : "+GlobalParams.getTestName());
		System.out.println("======================================================================");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
		System.out.println("======================================================================");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		try {
			ExtentReport.getReporter().flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/*public static void LogMessage(String message){
		ExtentTest a = ExtentReport.getTest();
		a.log(Status.INFO, message);
	}*/
}