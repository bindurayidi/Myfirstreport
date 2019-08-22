package catalog.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import catalog.Methods.CommonMethods;
import catalog.Pages.SignInPage;
import catalog.Pages.WelcomePage;
import config.ReadProperties;

public class LogInTests {
	private WebDriver driver;
	CommonMethods CM;
	public Logger logger=Logger.getLogger(LogInTests.class);
	
	ReadProperties ReadPropertyFile;
	
	@BeforeMethod
	public void openbrowser() {
		ReadPropertyFile=new ReadProperties();
	    CM=new CommonMethods();
		String getBrowser=ReadPropertyFile.getConfigPropertyVal("sBrowser");
		String getURL=ReadPropertyFile.getConfigPropertyVal("sURL");
		CM.openBrowser(getBrowser);
		CM.getURL(getURL);
	}
	
	@AfterMethod
	public void closebrowser() {
		CM.closeBrowser();
	
	}
	
	@Test
	public void loginTC_1() {
		WelcomePage welcomepage=new WelcomePage(driver);
		welcomepage.verifyHeader();
		welcomepage.clickLoginLink();
		SignInPage signinpage=new SignInPage(driver);
		signinpage.verifySignIn();
		signinpage.logIn("ecalix@test.com", "test123");
		welcomepage.clickLogOff();
		
	}

}
