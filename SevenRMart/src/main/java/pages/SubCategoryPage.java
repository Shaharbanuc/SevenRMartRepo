package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtilities;
import utilities.PageUtility;

public class SubCategoryPage {
	
	WebDriver driver;
	public SubCategoryPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@type='password']")private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")private WebElement subcategorylink;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(xpath="//select[@id='cat_id']")private WebElement category;
	@FindBy(xpath="//input[@id='subcategory']")private WebElement subcategory;
	@FindBy(xpath="//input[@id='main_img']")private WebElement imagebutton;
	@FindBy(xpath="//button[@type='submit']")private WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement savealert;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement cancelalert;
	@FindBy(xpath="//a[contains(@href,'Subcategory/status?id=1446&st=inactive&page_ad=1')]")private WebElement statusbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement statusactivealert;
	
	//@FindBy(xpath="//a[@class='btn btn-default btn-fix']")private WebElement cancelbutton;
	
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
	public void clickOnSubCategoryButton() {
		subcategorylink.click();
	}
	public void clickOnNewButton() {
		newbutton.click();
	}
	public void selectValueToCategory() {
		PageUtility pageutil=new PageUtility();
		pageutil.selectByIndex(category,3);
	}
	public void sendValueToSubCategory(String subCategoryNamePassing)
	{
		subcategory.sendKeys(subCategoryNamePassing);
	}
	public void uploadImage()
	{
		//import this utility and also constants
		FileUploadUtilities fileuploadutilities=new FileUploadUtilities();
		fileuploadutilities.fileuploadUsingSendkeys(imagebutton,Constants.AIRFRYER_IMAGE);
	}
	public void clickSave()
	{
		savebutton.click();
	}
	public boolean isSaveAlertDisplayed()
	{
		return savealert.isDisplayed();
	}
	public boolean isCancelAlertDisplayed()
	{
		return cancelalert.isDisplayed();
	}
	public void clickOnStatusButton()
	{
		statusbutton.click();
	}
	public boolean isActiveStatusAlertDisplayed()
	{
		return statusactivealert.isDisplayed();
	}
	/*public void clickCancel()
	{
		cancelbutton.click();
	}*/
}