package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtilities {
	
	private WebDriver driver;
	public JavaScriptExecutorUtilities(WebDriver driver)
	{
		this.driver=driver;
	}
	 public void clickOnWebElement(WebElement element)
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",element);
	 }

}
