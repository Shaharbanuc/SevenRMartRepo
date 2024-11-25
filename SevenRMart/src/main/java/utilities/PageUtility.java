package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	//WebDriver driver;
	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
	}
	public void selectByIndex(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);	
	}
	public void selectByVisibleText(WebElement element,String visibleText) {
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);
	}
	//you can add as much as known methods here for e asiness, and just call using object in whereever needed by creating this PageUtility class's object.
   /*public void javaScriptExecutor(WebDriver drvier,WebElement element)
   {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   
   }*/
}
