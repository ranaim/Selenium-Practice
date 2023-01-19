package Selenium_Practice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Get_Title {

	public static void main(String[] args) 
	{
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String Url= ("http://www.google.com");
		driver.get(Url);
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);

	}

}
