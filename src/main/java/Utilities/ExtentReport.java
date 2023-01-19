package Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
    public static ExtentReports extent;
    public  static ExtentTest test;
    final static String filePath = "Extent.html";
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    public static String fileFullPath ;
    
    public synchronized static ExtentReports getReporter() throws Exception {  
    	if (extent == null){
    		String env = PropertiesManager.sharedConfig("environment");
    		String brType = PropertiesManager.sharedConfig("browser");
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_hh_mm");  
		Calendar cal = Calendar.getInstance();    
		String convertedDate=dateFormat.format(cal.getTime());
		String reportName = "Extent\\Extent_"+env+"_"+brType+"_"+convertedDate+".html";
		fileFullPath = System.getProperty("user.dir")+"\\"+reportName;
		System.out.println(fileFullPath);        
        	ExtentSparkReporter html = new ExtentSparkReporter(reportName);        	
        	html.config().setDocumentTitle("KPCU Web Automation");
        	html.config().setReportName("KPCU");
        	html.config().setTheme(Theme.DARK);        	
            extent = new ExtentReports();
            extent.attachReporter(html);
            extent.setSystemInfo("Environment",env );
            extent.setSystemInfo("Browser",brType);
        }
        return extent;
    }
    
        
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String desc) throws Exception {
    	if (test == null) {
    		test = getReporter().createTest(testName, desc);
            extentTestMap.put((int) Thread.currentThread().getId(), test);
    	}
        return test;
    }
   
}
