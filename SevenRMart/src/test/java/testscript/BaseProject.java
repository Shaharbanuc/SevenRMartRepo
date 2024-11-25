package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.WaitUtilities;

public class BaseProject {
	public WebDriver driver;
	@BeforeMethod
	public void initializeBrowser()
	{
		driver=new ChromeDriver();
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
