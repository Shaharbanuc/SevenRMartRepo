package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassUtilities {
	private WebDriver driver;

    public ActionClassUtilities(WebDriver driver) {
        this.driver = driver;
    }
	
	public void moveToElement(WebElement element)
	{
		Actions actions=new Actions(driver);
		//actions.moveToElement(element).build().perform();
		//import Keys
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
	}
}
