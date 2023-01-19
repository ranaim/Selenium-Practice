package Utilities;

public class GlobalParams {
	
	private static final ThreadLocal<String> testName = new ThreadLocal<>();
	
	public static String getTestName() {
        return testName.get();
    }
    
    public static void setTestName(String testName1){
    	testName.set(testName1);
    }

}
