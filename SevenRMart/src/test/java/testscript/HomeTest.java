package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogInPage;
import utilities.ExcelUtilities;

public class HomeTest extends BaseProject {
	@Test
	public void VerifyTheUserIsAbleToLogOutSuccessfully() throws IOException {
//chaining
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "loginpage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();

		HomePage homepage = new HomePage(driver);
		homepage.clickRightTopImage();
		homepage.clickLogOut();
		String expected = "Login | 7rmart supermarket";
		String actual = homepage.isLogInPageDisplayed();
		// System.out.println(actual);
		Assert.assertEquals(actual, expected, "Log in page not displayed after logout");

	}

}
