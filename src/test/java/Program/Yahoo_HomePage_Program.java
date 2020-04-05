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

public class Yahoo_HomePage_Program extends Browser_Initialization{
	
	public static Logger log =LogManager.getLogger(Browser_Initialization.class.getName());
	public Properties prop=new Properties();
	WebDriver driver;
	public Yahoo_Home YH=new Yahoo_Home(driver);
		
	public Yahoo_HomePage_Program() throws IOException
	{
		FileInputStream FIS=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\Variables.properties");
		prop.load(FIS);
	}
	
	@Test
	public void YahooHome() throws IOException, InterruptedException   
	{
		driver=initialize();
		log.info("Success");
		driver.get(prop.getProperty("URL"));
		log.info("URL Opened");
		Yahoo_Home YH=new Yahoo_Home(driver);
		log.info("Object created for Home Page");
		YH.searchbox().sendKeys(prop.getProperty("searchItem"));
		YH.searchbtn().click();
		log.info("Item Searched");
		Thread.sleep(2000);
		driver.navigate().back();
		YH.signin().click();
		System.out.println(driver.getTitle());
		log.info("SignIn page title printed");
		driver.navigate().back();
		YH.email().click();
		System.out.println(driver.getTitle());
		log.info("Email title printed");
		driver.navigate().back();
		driver.quit();
		driver=null;
	}
}