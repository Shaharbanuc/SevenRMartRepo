package utilities;

import org.openqa.selenium.WebDriver;

public class AlertUtility {
	
	private WebDriver driver;

    public AlertUtility(WebDriver driver) {
        this.driver = driver;
    }
    public String getAlertText()
    {
    	String text=driver.switchTo().alert().getText();
		System.out.println(text);	
		return text;
    }
    public void acceptAlert() {
        /*Alert alert = driver.switchTo().alert();
        alert.accept();*/
    	driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
    	
        driver.switchTo().alert().dismiss();
    }
    

}
