package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Home 
{
	public WebDriver driver;
	By signIn=By.id("uh-signin");				// sign in button
	By searchBox=By.id("uh-search-box");		// search box
	By searchButton=By.id("uh-search-button");	// search button
	By mailButton=By.id("uh-mail-link");		// mail button*/
	
	public Yahoo_Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement signin()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement searchbox()
	{
		return driver.findElement(searchBox);
	}

	public WebElement searchbtn()
	{
		return driver.findElement(searchButton);
	}
	
	public WebElement email()
	{
		return driver.findElement(mailButton);
	}
	
	
}
