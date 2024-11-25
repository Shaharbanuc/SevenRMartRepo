package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	
WebDriver driver;

	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@type='password']")private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement adminusersmoreinfo;
	//@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/[td1]")private List<WebElement>elements;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=10729&page_ad=1']")private WebElement bluebutton;
	@FindBy(xpath="//input[@id='username']")private WebElement usernameedit;
	@FindBy(xpath="//button[@name='Update']")private WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement updatealert;
	@FindBy(xpath="//input[@id='password']")private WebElement pwdedit;
	@FindBy(xpath="//select[@id='user_type']")private WebElement dropdown;
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
	public void clickOnAdminUsersMoreInfo()
	{
		adminusersmoreinfo.click();
	}
	public void clickOnBlueButton()
	{
		bluebutton.click();
	}
	public void editUserName(String usernamepassing)
	{
		usernameedit.clear();
		usernameedit.sendKeys(usernamepassing);
	}
	public void editPassword(String passwordpassing)
	{
		pwdedit.clear();
		pwdedit.sendKeys(passwordpassing);
	}
	public void editUserType()
	{
		Select select=new Select(dropdown);
		select.selectByIndex(4);
	}
	public boolean clickOnUpdate()
	{
		updatebutton.click();
		return updatealert.isDisplayed();
	}
	

}
