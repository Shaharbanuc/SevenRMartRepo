package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {

	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'admin/Footertext/edit?edit=2')]")
	private WebElement blueicon;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement updatebutton;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement addressfiled;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailfiled;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonefiled;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successalert;

	public ManageFooterTextPage clickOnEditButton() {
		blueicon.click();
		return this;
	}

	public ManageFooterTextPage enetrValueInAddress(String address) {
		addressfiled.clear();
		addressfiled.sendKeys(address);
		return this;
	}

	public ManageFooterTextPage enetrValueInEmail(String email) {
		emailfiled.clear();
		emailfiled.sendKeys(email);
		return this;
	}

	public ManageFooterTextPage enetrValueInPhone(String phone) {
		phonefiled.clear();
		phonefiled.sendKeys(phone);
		/* get the warning message
		String validationMessage = phonefiled.getAttribute("validationMessage");
		//not an html element ,The browser dynamically generates this property at runtime,
		System.out.println("Validation Message: " + validationMessage);*/
		return this;
	}

	public ManageFooterTextPage clickOnUpdateButton() {
		updatebutton.click();
		return this;
	}

	public boolean isSuccessAlertDisplayed() {
		return successalert.isDisplayed();
	}

	public boolean isUpdateButtonDisplayed() {
		return updatebutton.isDisplayed();
	}
}
