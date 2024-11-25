package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	WebDriver driver;
	
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@type='password']")private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboardvalue;
	//@FindBy(className="alert")private WebElement errormessage;
	//or
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement errormessage;
	public void enterUserNameOnUserField(String usernamevaluepassing)
	{
		usernameField.sendKeys(usernamevaluepassing);
	}
	public void enterPasswordOnPasswordField(String pwdpassing)
	{
		pwd.sendKeys(pwdpassing);
	}
	public void clickOnSignInButton()
	{
		signin.click();
	}
	public boolean isHomePageDisplayed()
	{
		return dashboardvalue.isDisplayed();
	}
	public String getErrorMessage()
	{
		String error=errormessage.getText();
		return error;
		
	}
	public boolean isErrorMessageDisplayed()
	{
		return errormessage.isDisplayed();
	}

}
