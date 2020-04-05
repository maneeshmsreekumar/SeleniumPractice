package Resources;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class email_page extends Browser_Initialization  
{
		public Properties prop=new Properties();
		WebDriver driver;
		public By checkhBox=By.xpath("//*[@id='login-username-form']/div[3]/div[1]/span/label");		// check box
		By SignInButton=By.xpath("//*[@id=\"signin-main\"]/div[1]/a[2]/span");		// mail button*//
		By mailButton=By.id("uh-mail-link");		// mail button*/
	
		@FindBy(id="login-username")
		WebElement usrnme;
	
		@FindBy(id="login-signin")
		WebElement nextButton;
		
		public WebElement mail_sign_in()
		{
			return driver.findElement(SignInButton);
		}
		
		public email_page(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public WebElement maillink()
		{
			return driver.findElement(mailButton);
		}
		
		public WebElement mailSignIn()
		{
			return usrnme;
		}
		
		public WebElement checkbox()
		{
			return driver.findElement(checkhBox);
		}
		
		public WebElement nextbtn()
		{
			return nextButton;
		}
		
}
