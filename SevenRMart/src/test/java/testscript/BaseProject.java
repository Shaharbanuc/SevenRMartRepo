package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenShotUtility;
import utilities.WaitUtilities;

public class BaseProject {
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fileinputstream;
	public ScreenShotUtility scrshot;

	// alwaysrun true is required for grouping
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	// initialize method is different for testngxml and normal run,xml.browser as parameter
	public void initializeBrowser(String browser) throws Exception {
		// testngxml file may contain chrome or CHROME ,so we use ignorecase here
		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constants.CONFIG_FILE);
			properties.load(fileinputstream);

		} catch (Exception e) {
			System.out.println("exception");
		}
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		// if we used equals instead of equalignorecase or if the value of browser is misspelled
		else {
			throw new Exception("browser is incorrect");
		}
		// driver=new ChromeDriver();
		// instead of below line used configuration file for launching the url
		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");//launching url
		// If the element is found before timeout, the remaining time is ignored.
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.ImplicitWait));
		driver.manage().window().maximize();// to maximize window
	}
	 /*public void driverQuitAndClose(){driver.quit();
	 }*/
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
			//checking is testcase failed or not to get screenshot 
			if (iTestResult.getStatus()==ITestResult.FAILURE)
			{ 
			scrshot = new ScreenShotUtility(); 
			//passing driver and testcase name to the method getScreenShot 
			scrshot.getScreenShot(driver,iTestResult.getName());
			} 
		driver.quit();
	 	}
}
