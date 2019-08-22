package catalog.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import catalog.Methods.CommonMethods;

public class SignInPage {
	private WebDriver driver;
    CommonMethods CM;
    public Logger logger=Logger.getLogger(SignInPage.class);
      
   
    @FindBy(how=How.NAME,using="email_address")
    WebElement EMAILTEXTBOX;
    
    @FindBy(how=How.NAME,using="password")
    WebElement PASSWORDTEXTBOX;
    
    @FindBy(how=How.XPATH,using="//*[@id=\'tdb5\']/span[2]")
    WebElement CLICKSIGNIN;
    
    @FindBy(how=How.XPATH,using="//*[@id=\'bodyContent\']/h1")
    WebElement VERIFYSIGNINPAGE;
    
    public SignInPage(WebDriver driver) {
    	this.driver=driver;
    	 CM=new CommonMethods();
    	PageFactory.initElements(driver,this);
    }
    
    public void verifySignIn() {
    	 String ExpectedText="Welcome, Please Sign In";
    	CM.verifytext(VERIFYSIGNINPAGE, ExpectedText);
    }
     
    public void enterEmailId(String sEmail) {
    	CM.setValue(EMAILTEXTBOX, sEmail);
    }
    
    public void enterPSW(String sPsw) {
    	CM.setValue(PASSWORDTEXTBOX, sPsw);
    }
    
    public void clickSignIn() {
    	CM.click(CLICKSIGNIN);
    }
	
    public void logIn(String sEmail,String sPsw) {
    	
    	enterEmailId(sEmail);
    	enterPSW(sPsw);
    	clickSignIn();
    	
    	
    	
    }

}
