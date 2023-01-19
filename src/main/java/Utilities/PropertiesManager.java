package Utilities;

import java.io.InputStream;
import java.util.Properties;



public class PropertiesManager {

	static String environment;
	
	
	public static  String getEnvironment() throws Exception{		
		if(environment==null)
			environment = sharedConfig("environment");
		return environment;
	}
	
	public static String sharedConfig(String key) throws Exception {
		try{
			InputStream accountsConfigIs;
	        Properties config = new Properties();
	        accountsConfigIs = PropertiesManager.class.getClassLoader().getResourceAsStream("shared.properties");
	        config.load(accountsConfigIs);
	        return config.getProperty(key);
		}catch(Exception e){
			return null;
		}        
    }
	
	public static String testConfig(String key) throws Exception {
        InputStream accountsConfigIs;
        Properties config = new Properties();
        accountsConfigIs = PropertiesManager.class.getClassLoader().getResourceAsStream("testcase.properties");
        config.load(accountsConfigIs);
        return config.getProperty(key);
    }
}
