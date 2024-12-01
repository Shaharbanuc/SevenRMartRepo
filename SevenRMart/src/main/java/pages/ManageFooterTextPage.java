package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	
WebDriver driver;
	
	public ManageFooterTextPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@type='password']")private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//a[contains(@href,'admin/list-footertext')]")private WebElement footertextlink;
	@FindBy(xpath="//a[contains(@href,'admin/Footertext/edit?edit=2')]")private WebElement blueicon;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")private WebElement updatebutton;
	@FindBy(xpath="//textarea[@id='content']")private WebElement addressfiled;
	@FindBy(xpath="//input[@id='email']")private WebElement emailfiled;
	@FindBy(xpath="//input[@id='phone']")private WebElement phonefiled;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement successalert;
	
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
	public void clickOnFooterLink()
	{
		footertextlink.click();
	}
	public void clickOnEditButton()
	{
		blueicon.click();
	}
	public void enetrValueInAddress(String address)
	{
		addressfiled.clear();
		addressfiled.sendKeys(address);
	}
	public void enetrValueInEmail(String email)
	{
		emailfiled.clear();
		emailfiled.sendKeys(email);
	}
	public void enetrValueInPhone(String phone)
	{
		phonefiled.clear();;
		phonefiled.sendKeys(phone);
		//belw code will get the warning message
		//String validationMessage = phonefiled.getAttribute("validationMessage"); // not an html element ,The browser dynamically generates this property at runtime,
		//System.out.println("Validation Message: " + validationMessage);
	}
	public void clickOnUpdateButton()
	{
		updatebutton.click();
	}
	public boolean isSuccessAlertDisplayed()
	{
		return successalert.isDisplayed();
	}
	public boolean isUpdateButtonDisplayed()
	{
		return updatebutton.isDisplayed();
	}
}
