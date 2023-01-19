package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;


public class SeleniumUtils {

	
	public WebDriverWait Wait(int time) throws Exception{		
		WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(),time);
		wait.ignoring(Exception.class);
		//wait.pollingEvery(100);
		return wait;
	}
	
	public void waitForElementClickable(By by,int time) throws Exception{
		WebElement element = WebDriverFactory.getDriver().findElement(by);
		Wait(time).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementDisplayed(By by,int time) throws Exception{
		WebElement element = WebDriverFactory.getDriver().findElement(by);
		Wait(time).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(By by,String name) throws Exception {		
		try{
			WebDriverFactory.getDriver().findElement(by).click();
			log("'"+name+"' clicked successfully");
		}catch(Exception e){
			logFail("While clicking on "+name);
			throw new Exception("Falied : '"+name+"'"+e.getMessage());
		}
	}
	
	public void hoverAndClick(By by) throws Exception{
		getAction().moveToElement(getElement(by)).click().build().perform();
		log("'"+by+"' Hover ANd Click successfully");
	}
	
	public WebElement getElement(By by) throws Exception{
		//Wait(10).until(ExpectedConditions.)
		return WebDriverFactory.getDriver().findElement(by);
	}
	
	public void clickByIndex(By by,int i,String name) throws Exception{
		WebElement element = WebDriverFactory.getDriver().findElements(by).get(i);		
		element.click();
		log("'"+name+"' clicked successfully");
	}
	
	
	public void enterText(By by,String value) throws Exception{
		try{
			WebDriverFactory.getDriver().findElement(by).clear();
			WebDriverFactory.getDriver().findElement(by).sendKeys(value);
			log("'"+value+"' Entered successfully");
		}catch(Exception e){
			logFail("Unable to send text "+value);
			throw new Exception("Falied : '"+value+"'"+e.getMessage());
		}
	}
	
	public void defaultWait(int i){
		try{
			Thread.sleep(i*1000);
		}catch(Exception e){}
	}
	
	public void displayed(By by,String name) throws Exception{
		highlightElement(by);
		Assert.assertTrue(WebDriverFactory.getDriver().findElement(by).isDisplayed(),"'"+name+"' is not Dispalyed");
		log("'"+name+"' is  Dispalyed");
		
	}
	
	public void assertText(String actual,String expected){
		Assert.assertTrue(actual.trim().equals(expected.trim()));
		log("'"+actual+"' and '"+expected+"' are equal");
	}
	
	public boolean isDisplayed(By by){		
		try{
			return WebDriverFactory.getDriver().findElement(by).isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
	
	
	public void highlightElement(By by) throws Exception{
			WebElement element = WebDriverFactory.getDriver().findElement(by);
			if(true) {
				for (int i = 0; i < 5; i++) {
					WebDriver driver = WebDriverFactory.getDriver();
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].style.border='5px solid blue'", element);			
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
				}
			}
	}
	public void log(String msg){
		ExtentReport.getTest().pass(msg);	
		System.out.println(msg);
	}
	public void logFail(String msg){
		ExtentReport.getTest().fail(msg);	
		System.out.println("[Fail] "+msg);
	}
	
	public void switchToFrame(By by) throws Exception{		
		WebElement element = WebDriverFactory.getDriver().findElement(by);
		WebDriverFactory.getDriver().switchTo().frame(element);
	}
	
	public String switchWindowUsingWindowCount(int waitTimer, int windowNum) throws Exception {
		waitUntillGivenWindowPresent(waitTimer, windowNum);
		ArrayList<String> windowHandles = new ArrayList<String>(WebDriverFactory.getDriver().getWindowHandles());		
		WebDriverFactory.getDriver().switchTo().window(windowHandles.get(windowNum - 1).toString());
		log("Switch Window : "+WebDriverFactory.getDriver().getTitle());
		return WebDriverFactory.getDriver().getTitle();
	
	}
	
	public void SwitchToNewPage() throws Exception{
		try {
			switchWindowUsingWindowCount(0, 2);
		}catch(Exception e) {}		
	}
	 
	
	public void SwitchToMainPage() throws Exception{
		closePage();
		switchWindowUsingWindowCount(0, 1);
		//WebDriverFactory.getDriver().switchTo().defaultContent();
	}
	 
	public void closePage() throws Exception {
		String title = WebDriverFactory.getDriver().getTitle();
		WebDriverFactory.getDriver().close();
		log("Page Closed : "+title);
	}
	
	public void waitUntillGivenWindowPresent(int Time, int NoofWindows) throws Exception {	
		Set<String> windows = WebDriverFactory.getDriver().getWindowHandles();
		int windowCount = windows.size();			
		for (int i = 0; i < Time; i++) {	
			if (windowCount > NoofWindows) {
				break;
			} else {
				try {						
					defaultWait(2);
				} catch (Exception e1) {
					System.out.println("Waiting for webelement in DOM");
				}	
			}
		}	
	}
	
	public Actions getAction() throws Exception{
		Actions act = new Actions(WebDriverFactory.getDriver());
		return act;
	}
	
	String options_Xpath = "//button/following-sibling::ul[not(@hidden)]/li/a";
	
	public void select_DropdownByText(By by,String option,String elementName){ 
		try{
			WebElement element = WebDriverFactory.getDriver().findElement(by);
			//Wait(20).until(ExpectedConditions.elementToBeClickable(by));
			clickJS(element);
			defaultWait(1);
			Select select = new Select(element);
			List<WebElement> ele = select.getOptions();
			select.selectByValue(option);
			log("["+elementName+"] : Selected Option ["+option+"] successfully");
		}
		catch(Exception e ){
			Assert.assertTrue(false,"[DropDown]: Not Selected Cause => "+e.getMessage());
		}
		
	}
	
	public String select_Bootstrap(By by,String option,String elementName){
		String selectedOption = null;
		try {
			WebElement element = WebDriverFactory.getDriver().findElement(by);
			element.click();			
			if(!isDisplayed(By.xpath(options_Xpath))){
				getAction().moveToElement(element).click().sendKeys(Keys.ENTER).build().perform();
			}
			if(!isDisplayed(By.xpath(options_Xpath)))	
				clickJS(element);
			Thread.sleep(100);
			List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.xpath(options_Xpath));			
			String[] list = new String[elements.size()];
			for(int i=0;i<elements.size();i++){
				String text = elements.get(i).getText();
				list[i] = text;
				if(text.trim().equals(option.trim())){
					scrollToElement(elements.get(i));
					elements.get(i).click();
					selectedOption = text;
					log("["+elementName+"] : Selected Option ["+option+"] successfully");
					break;
				}
			}
			
		}catch(Exception e ){
			Assert.assertTrue(false,"[DropDown]: Not Selected Cause => "+e.getMessage());
		}
		return selectedOption;	
	}
	
	public void scrollToElement(By by) throws Exception{		
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", WebDriverFactory.getDriver().findElement(by));	
	}
	
	public void scrollToElement(WebElement element) throws Exception{		
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);",element);	
	}
	
	public void clickJS(WebElement element) throws Exception{		
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
		js.executeScript("arguments[0].click();",element);	
	}
	
	public void clickJS(By by,String elementName) throws Exception{	
		WebElement element = WebDriverFactory.getDriver().findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
		js.executeScript("arguments[0].click();",element);
		log(elementName+" : Clicked Successfully");
	}
	
	public String[] get_All_Text(By by) throws Exception {
		List<WebElement> elements = WebDriverFactory.getDriver().findElements(by);
		String[] text = new String[elements.size()];
		for(int i =0;i<elements.size();i++) {
			text[i] = elements.get(i).getText().toString();
			System.out.println(text[i]);
		}
		return text;
	}

	public static String getDate(String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);  
		Calendar cal = Calendar.getInstance();    
		String convertedDate=dateFormat.format(cal.getTime());
		return convertedDate;
	}
	
	public static String takeScreenshot(String fileName) throws Exception{
		File f = new File(System.getProperty("user.dir")+"\\evidence\\"+getDate("MM_dd_yyyy"));
		if(!f.exists()){
			f.mkdir();
		}
		String fullpath = f.getAbsolutePath()+"\\"+getDate("MM_dd_yyyy_hh_mm_ss")+fileName+".jpg";
		File file = ((TakesScreenshot)WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);			
		FileUtils.copyFile(file, new File(fullpath));
		return fullpath;
	}

}
