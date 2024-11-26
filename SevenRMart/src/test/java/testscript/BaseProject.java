package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.WaitUtilities;

public class BaseProject {
	public WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		//driver=new ChromeDriver();
		//if(parameter!=null) .... else driver= new ChromeDriver
		//testngxml file might contain chrome or CHROME ,so we use ignorecase here
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		//if we used equals instead of equalignorecase or if the value of browser is misspelled
		else {
			throw new Exception("browser is incorrect");
		}
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");//launching the url
		//If the element is found before timeout, the remaining time is ignored.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.ImplicitWait));
		driver.manage().window().maximize();//to maximize window
	}
	//@AfterMethod
	/*public void driverQuitAndClose()
	{
		driver.quit();
	}*/
}
