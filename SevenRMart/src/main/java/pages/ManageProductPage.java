package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.ActionClassUtilities;
import utilities.AlertUtility;
import utilities.FileUploadUtilities;
import utilities.JavaScriptExecutorUtilities;

public class ManageProductPage {
	
	WebDriver driver;
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@type='password']")private WebElement pwd;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-product']") private WebElement manageproduct;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']") private WebElement newicon;
	@FindBy(xpath="//input[@id='main_img']") private WebElement image;
	@FindBy(xpath="//input[@id='title']") private WebElement title;
	@FindBy(xpath="//input[@id='w_price']") private WebElement price;
	@FindBy(xpath="//div[@class='note-editable card-block']") private WebElement description;
	@FindBy(xpath="//button[@type='button' and @class='note-btn btn btn-light btn-sm note-btn-underline']") private WebElement underlinedescr;
	@FindBy(xpath="//i[@class=\"note-icon-video\"]") private WebElement videoicon;
	@FindBy(xpath="//input[contains(@class,'note-video-url form-control')]") private WebElement insertvideo;
	@FindBy(xpath="//input[@value='Insert Video']") private WebElement insertvideobutton;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement savebutton;
	//@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private WebElement alert;
	
	
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
	public void clickOnManageProductButton() {
		manageproduct.click();
	}
	public void clickOnNewIcon() {
		newicon.click();
	}
	public void enterValueOnTitleField(String titlepassing) {
		title.sendKeys(titlepassing);
	}
	public void enterValueOnPriceField(String pricepassing) {
		price.sendKeys(pricepassing);
	}
	public void enterValueOnDescription(String descriptionpassing) {
		description.sendKeys(descriptionpassing);
	}
	public void selectDescriptionField()
	{
		ActionClassUtilities actionclassutilities=new ActionClassUtilities(driver);
		actionclassutilities.moveToElement(description);
	}
	public void underLineDescriptionField()
	{
		ActionClassUtilities actionclassutilities=new ActionClassUtilities(driver);
		actionclassutilities.moveToElement(underlinedescr);
		underlinedescr.click();
	}
	public void clickVideoIconDescriptionField()
	{
		videoicon.click();
	}
	public void addVideoLinkDescriptionField()
	{
		insertvideo.sendKeys("https://www.shutterstock.com/video/clip-3557755893-retro-projector-style-5-seconds-countdown-ten");;
	}
	public void clickInsertVideoButton()
	{
		insertvideobutton.click();
	}
	
	public void uploadImage() throws AWTException
	{
		FileUploadUtilities fileuploadutilities=new FileUploadUtilities();
		//path is given in Constants class
		fileuploadutilities.fileuploadUsingSendkeys(image, Constants.STRAWBERRY_IMAGE);
		//fileuploadutilities.FileuploadUsingRobotclass(image, Constants.STRAWBERRY_IMAGE);
	}
	//below method is replaced by JavaScriptExecutorUtilities
	/*public void clickOnSave()
	{
		//savebutton.click(); direct click not working
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",savebutton);
	}*/
	/*public boolean alertDisplayed()
	{
		return alert.isDisplayed();
	}*/
	public void clickOnSave()
	{
		JavaScriptExecutorUtilities javascriptexeobj=new JavaScriptExecutorUtilities(driver);
		javascriptexeobj.clickOnWebElement(savebutton);
	}
	public String simpleAlertDisplayed()
	{
		AlertUtility alertutility=new AlertUtility(driver);
		String text=alertutility.getAlertText();
		alertutility.acceptAlert();
		return text;
	}
	//below method is replaced using AlertUtility
	/*public String simpleAlertDisplayed()
	{
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		//alertbox elements are not an html element so we need to switch from html to alert
		driver.switchTo().alert().accept();
		return text;
	}*/
}
