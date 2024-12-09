package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminusersmoreinfo;
	@FindBy(xpath = "//a[contains(@href,'admin/list-footertext')]")
	private WebElement footertextlink;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement managenewslink;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	private WebElement manageproduct;
	@FindBy(css = "a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subcategorylink;
	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement profilepic;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logouticon;

	public AdminUsersPage clickOnAdminUsersMoreInfo() {
		adminusersmoreinfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageFooterTextPage clickOnFooterLink() {
		footertextlink.click();
		return new ManageFooterTextPage(driver);
	}

	public ManageNewsPage clickOnManageNewsButton() {
		managenewslink.click();
		return new ManageNewsPage(driver);
	}

	public ManageProductPage clickOnManageProductButton() {
		manageproduct.click();
		return new ManageProductPage(driver);
	}

	public SubCategoryPage clickOnSubCategoryMoreinfo() {
		subcategorylink.click();
		return new SubCategoryPage(driver);
	}

	public void clickRightTopImage() {
		profilepic.click();
	}

	public void clickLogOut() {
		logouticon.click();
	}

	public String isLogInPageDisplayed() {
		String title = driver.getTitle();
		return title;
	}
}
