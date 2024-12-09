package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {

	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'admin/news/add')]")
	private WebElement newnews;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newstextfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
	// deletion
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//a[contains(@href,'news/delete?del=2192&page_ad=1')]")
	private WebElement deleteicon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertafterdelete;

	public ManageNewsPage clickOnNewButton() {
		newnews.click();
		return this;
	}

	public ManageNewsPage eneterValueInNewsField(String newspassing) {
		newstextfield.sendKeys(newspassing);
		return this;
	}

	public ManageNewsPage clickOnSave() {
		savebutton.click();
		return this;
	}

	public boolean isAlertdisplayed() {
		return alert.isDisplayed();
	}

	// deletion
	public ManageNewsPage clickOnDelete() {
		deleteicon.click();
		return this;
	}

	public ManageNewsPage deleteConfirmationAlert() {
		PageUtility pageutility = new PageUtility();
		pageutility.acceptAlert(driver);
		return this;
	}

	public boolean isAlertDisplayedAfterDelete() {
		return alertafterdelete.isDisplayed();
	}

}
