package catalog.Methods;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CommonMethods {
	private WebDriver driver;
	public Logger logger=Logger.getLogger(CommonMethods.class);
	
	public WebDriver openBrowser(String sBrowser) {
		if(sBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			logger.info("opening chrome browser");
		}else {
			Assert.fail("please select a browser");
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 return driver;
	}
	
	public void getURL(String sURL) {
		driver.get(sURL);
		logger.info("opening URL="+sURL);
			
	}
	
	public void closeBrowser() {
		driver.quit();
		logger.info("closing the browser");
		
	}
	
	public void setValue(WebElement slocator,String sValue) {
	   String Element=slocator.getText();
	   try {
		   logger.info(Element+"trying to set value");
		   slocator.clear();
		   slocator.sendKeys(sValue); 
	   }catch(Exception ex) {
		   ex.printStackTrace();
		   logger.info(Element+"field not found");
		   
	   }
	}
	   
	   public void click(WebElement slocator) {
			
			
			  try {
		    	 
		    	 String element=slocator.getText();
		    	 if((element.isEmpty())||(element==null)) {
		    		 element=slocator.getAttribute("value");
		    	 }
		    	 logger.info(element+"trying to click");
		    	 slocator.click();
		    	 logger.info(element+"clicked");
		    	 
		     }catch(Exception ex) {
		    	 
		    	 ex.printStackTrace();
		    	 logger.info(slocator+"not clicked");
		     }
		}
	

	public  void verifytext(WebElement slocator,String ExpectedText) {
		String ActualText=slocator.getText().trim();
		ExpectedText=ExpectedText.trim();
		if(ExpectedText.equalsIgnoreCase(ActualText)) {
			logger.info("on page Expected Text"+ExpectedText+"verified");
		}else {
			logger.info("On page " + ". Expected Text="+ ExpectedText +"Not Found, instead found="+ActualText);
		Assert.fail("On page " + ". Expected Text="+ ExpectedText +"Not Found, instead found="+ActualText);}
        }	
		

	
	
}
	
	
	
	
	
	
	
	



