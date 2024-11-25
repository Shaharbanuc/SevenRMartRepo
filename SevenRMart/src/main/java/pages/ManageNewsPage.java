package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AlertUtility;

public class ManageNewsPage{
	
	WebDriver driver;
	public ManageNewsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@type='password']")private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-news']")private WebElement managenewslink;
	@FindBy(xpath="//a[contains(@href,'admin/news/add')]")private WebElement newnews;
	@FindBy(xpath="//textarea[@id='news']")private WebElement newstextfield;
	@FindBy(xpath="//button[@type='submit']")private WebElement savebutton;
	//deletion
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	@FindBy(xpath="//a[contains(@href,'admin/news/delete?del=2067&page_ad=1')]")private WebElement deleteicon;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertafterdelete;
	
	
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
	public void clickOnManageNewsButton() {
		managenewslink.click();
	}
	public void clickOnNewButton() {
		newnews.click();
	}
	public void eneterValueInNewsField(String newspassing) {
		newstextfield.sendKeys(newspassing);
	}
	public void clickOnSave() {
		savebutton.click();
	}
	public boolean isAlertdisplayed()
	{
		return alert.isDisplayed();
	}
	//deletion
	public void clickOnDelete() {
		deleteicon.click();
	}
	public void deleteConfirmationAlert()
	{
		AlertUtility alertutility=new AlertUtility(driver);
		alertutility.acceptAlert();
	}
	public boolean isAlertDisplayedAfterDelete()
	{
		return alertafterdelete.isDisplayed();
	}
	
}
