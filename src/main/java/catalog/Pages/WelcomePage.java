package catalog.Pages;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import catalog.Methods.CommonMethods;

public class WelcomePage {
	private WebDriver driver;
	CommonMethods CM;
	public Logger logger=Logger.getLogger(WelcomePage.class);
	
	@FindBy(how=How.XPATH,using="//*[@id=\'bodyContent\']/h1")
	WebElement Header;
	
	@FindBy(how=How.XPATH,using="//*[@id=\'bodyContent\']/div/div[1]/a[1]/u")
	WebElement LOGYOURSELFINLINK;
	
	@FindBy(how=How.XPATH,using="//*[@id=\'bodyContent\']/div/div[1]/a[1]/u")
	WebElement LOGOFFLINK;
	
	
     public WelcomePage(WebDriver driver) {
    	 this.driver=driver;
    	 CM=new CommonMethods();
    	 PageFactory.initElements(driver,this);
    	
    }
	
	public void clickLoginLink() {
		CM.click(LOGYOURSELFINLINK);
		logger.info("clicking on logyourselfin");
		 logger.info("opening welcomepage");
	    	
		
	}
	
	public void clickLogOff() {
		CM.click(LOGOFFLINK);
		
		
		
	}
	
	public void verifyHeader() {
		String ExpectedText ="Welcome to iBusiness";
		CM.verifytext(Header, ExpectedText);
	}
	
	
	 
     

}
