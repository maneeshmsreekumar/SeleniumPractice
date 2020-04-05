package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser_Initialization 
{
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initialize() throws IOException
	{
	prop= new Properties();
	FileInputStream FIS=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\Variables.properties");
	prop.load(FIS);
		if(System.getProperty("browser").contains("chrome"))
				{
				System.setProperty("webdriver.chrome.driver", "M:\\Downloads\\chromedriver.exe");
				ChromeOptions options=new ChromeOptions();		// to run headless
				options.addArguments("--headless","--disable-gpu");				// to run headless
				driver=new ChromeDriver(options);				// to run in headmode, remove options.
				}
				else if(System.getProperty("browser").contains("firefox"))
				{
				System.setProperty("webdriver.gecko.driver", "M:\\Downloads\\geckodriver.exe");
				driver=new FirefoxDriver();
				}
				else
				{
				System.setProperty("webdriver.ie.driver", "M:\\Downloads\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public void screenshot(String result) throws IOException
	{
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("M://"+result+"_screenshot.jpg"));		// adds the failed test name with screen shot
	}	
}

