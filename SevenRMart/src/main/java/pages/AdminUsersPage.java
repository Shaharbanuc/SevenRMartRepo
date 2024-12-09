package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(@href,'user/edit?edit=11007&page_ad=1')]")
	private WebElement bluebutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameedit;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement updatealert;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pwdedit;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement dropdown;
	
	public AdminUsersPage clickOnBlueButton() {
		bluebutton.click();
		return this;
	}
	public AdminUsersPage editUserName(String usernamepassing) {
		usernameedit.clear();
		usernameedit.sendKeys(usernamepassing);
		return this;
	}

	public AdminUsersPage editPassword(String passwordpassing) {
		pwdedit.clear();
		pwdedit.sendKeys(passwordpassing);
		return this;
	}

	public AdminUsersPage editUserType() {
		Select select = new Select(dropdown);
		select.selectByIndex(4);
		return this;
	}

	public boolean clickOnUpdate() {
		updatebutton.click();
		return updatealert.isDisplayed();
	}

}
