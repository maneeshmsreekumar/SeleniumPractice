package Program;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import Resources.Browser_Initialization;
import Resources.Yahoo_Home;
import Resources.email_page;

public class YahooEmailPage extends Browser_Initialization{
	public static Logger log =LogManager.getLogger(Browser_Initialization.class.getName());
	public Properties prop=new Properties();
	WebDriver driver;
	public Yahoo_Home YH=new Yahoo_Home(driver);
		
	public YahooEmailPage() throws IOException
	{
		FileInputStream FIS=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\Variables.properties");
		prop.load(FIS);
		
	}
	
	@Test
	public void EmailPage() throws IOException, InterruptedException   
	{
		driver=initialize();
		log.info("Driver Intialized");
		driver.get(prop.getProperty("URL"));
		email_page EP=new email_page(driver);
		EP.maillink().click();
		EP.mail_sign_in().click();
		EP.mailSignIn().sendKeys(prop.getProperty("username"));
		log.info("Entered username");
		EP.checkbox().click();
		EP.nextbtn().click();
		driver.navigate().back();
		driver.navigate().back();
		driver.quit();
		driver=null;
	}
}
