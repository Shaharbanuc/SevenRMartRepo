package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LogInPage;
import utilities.ExcelUtilities;

public class HomeTest extends BaseProject {
	HomePage homepage;
	@Test
	public void VerifyTheUserIsAbleToLogOutSuccessfully() throws IOException {
		
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "loginpage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=loginpage.clickOnSignInButton();
		homepage.clickRightTopImage().clickLogOut();
		String expected = "Login | 7rmart supermarket";
		String actual = homepage.isLogInPageDisplayed();
		// System.out.println(actual);
		Assert.assertEquals(actual, expected,Constants.MESSAGE_ASSERTION);
	}
}
