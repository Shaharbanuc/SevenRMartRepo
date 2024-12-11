package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import utilities.FileUploadUtilities;

import utilities.PageUtility;
import utilities.WaitUtilities;

public class ManageProductPage {

	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']")
	private WebElement newicon;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement image;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement title;
	@FindBy(xpath = "//input[@value='Others']")
	private WebElement producttype;
	@FindBy(xpath = "//select[@id='grp_id']")
	private WebElement group;
	@FindBy(xpath = "//input[@id='purpose1']")
	private WebElement pricetype;

	@FindBy(xpath = "//input[@id='w_price']")
	private WebElement price;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	private WebElement description;
	@FindBy(xpath = "//button[@type='button' and @class='note-btn btn btn-light btn-sm note-btn-underline']")
	private WebElement underlinedescr;
	@FindBy(xpath = "//i[@class=\"note-icon-video\"]")
	private WebElement videoicon;
	@FindBy(xpath = "//input[@class='note-video-url form-control note-form-control note-input']")
	private WebElement insertvideo;
	@FindBy(xpath = "//input[@value='Insert Video']")
	private WebElement insertvideobutton;

	@FindBy(xpath = "//input[@value='no' and @name='stock']")
	private WebElement stcokradiobutton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
	// @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private
	// WebElement alert;

	public ManageProductPage clickOnNewIcon() {
		newicon.click();
		return this;
	}

	public ManageProductPage enterValueOnTitleField(String titlepassing) {
		title.sendKeys(titlepassing);
		return this;
	}

	public ManageProductPage clickProdcutType() {
		producttype.click();// if not working use javascript
		return this;
	}

	public ManageProductPage selectGroup() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(group, 1);
		return this;
	}

	public ManageProductPage clickPriceType() {
		// not using this method ,Clicking the radio button causes change in DOM ,id of price element is changing.
		PageUtility pageutility = new PageUtility();
		pageutility.clickOnWebElement(driver, pricetype);
		return this;
	}

	public ManageProductPage enterValueOnPriceField(String pricepassing) {
		WaitUtilities waitutilities = new WaitUtilities();
		waitutilities.waitForElementToBeClickable(driver, price);
		price.sendKeys(pricepassing);
		return this;
	}

	public ManageProductPage enterValueOnDescription(String descriptionpassing) {
		description.sendKeys(descriptionpassing);
		return this;
	}

	public ManageProductPage selectDescriptionField() {
		PageUtility pageutility = new PageUtility();
		pageutility.moveToElement(driver, description);
		return this;
	}

	public ManageProductPage underLineDescriptionField() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickOnWebElement(driver, underlinedescr);
		// underlinedescr.click();
		return this;
	}

	public ManageProductPage clickVideoIconDescriptionField() {
		// normal click not working
		PageUtility pageutility = new PageUtility();
		pageutility.clickOnWebElement(driver, videoicon);
		return this;
	}

	public ManageProductPage addVideoLinkDescriptionField(String videolinkpassing) {
		insertvideo.sendKeys(videolinkpassing);
		return this;
	}

	public ManageProductPage clickInsertVideoButton() {
		insertvideobutton.click();
		return this;
	}

	public ManageProductPage uploadImage() throws AWTException {
		FileUploadUtilities fileuploadutilities = new FileUploadUtilities();
		// path is given in Constants class
		fileuploadutilities.fileuploadUsingSendkeys(image, Constants.STRAWBERRY_IMAGE);
		// fileuploadutilities.FileuploadUsingRobotclass(image,
		// Constants.STRAWBERRY_IMAGE);
		return this;
	}

	public ManageProductPage clickStockRadio() {
		//stcokradiobutton.click() not wroking so used javascript
		PageUtility pageutility = new PageUtility();
		pageutility.clickOnWebElement(driver, stcokradiobutton);
		return this;
	}

	public ManageProductPage clickOnSave() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickOnWebElement(driver, savebutton);
		return this;
	}

	public String isSimpleAlertDisplayed() {
		PageUtility pageutility = new PageUtility();
		String text = pageutility.getAlertText(driver);
		pageutility.acceptAlert(driver);
		return text;
	}
}
