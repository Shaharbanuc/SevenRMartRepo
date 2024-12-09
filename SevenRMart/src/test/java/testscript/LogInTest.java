package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LogInPage;
import utilities.ExcelUtilities;

public class LogInTest extends BaseProject {
	@Test(dataProvider = "LoginProvider")
	public void VerifyTheUserIsAbleToLogInUsingValidCredentials(String usernamevalue, String passwordvalue)
			throws IOException {
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue)
				.clickOnSignInButton();
		boolean homepagedisplayed = loginpage.isHomePageDisplayed();
		// Assert.assertFalse(homepagedisplayed, "MAKING TC FAIL TO CAPTURE SCREENSHOT");
		Assert.assertTrue(homepagedisplayed, "Home page not loaded when user entered valid credentials");

	}

	@Test(description = "Check login for invalid password")
	public void VerifyTheUserIsNotAbleToLogInUsingInValidPassword() throws IOException {
		// String usernamevalue="admin";
		// String passwordvalue="admin12";
		// this tc included in cross browser
		String usernamevalue = ExcelUtilities.readStringData(2, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(2, 1, "loginpage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue)
				.clickOnSignInButton();
		boolean errordisplayed = loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(errordisplayed,
				"Error message is not displayed and user is able to login with invalid password");
	}

	@Test(retryAnalyzer = retry.Retry.class, groups = {
			"regression" }, description = "Check login for invalid user name")
	public void VerifyTheUserIsNotAbleToLogInUsingInValidUserName() throws IOException {
		String usernamevalue = ExcelUtilities.readStringData(3, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(3, 1, "loginpage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue)
				.clickOnSignInButton();
		boolean errordisplayed = loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(errordisplayed,
				"Error message is not displayed and user is able to login with invalid username");
	}

	@Test
	public void VerifyTheUserIsNotAbleToLogInUsingInValidCredentials() throws IOException {

		String usernamevalue = ExcelUtilities.readStringData(4, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(4, 1, "loginpage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue)
				.clickOnSignInButton();
		boolean errordisplayed = loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(errordisplayed,
				"Error message is not displayed and user is able to login with invalid credentials");
		/*
		 * String message=loginpage.getErrorMessage(); System.out.println(message);
		 * String expected="×\nAlert!\nInvalid Username/Password";
		 * Assert.assertEquals(message,expected,"Error message not matching");
		 */
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] { { ExcelUtilities.readStringData(1, 0, "loginpage"),
				ExcelUtilities.readStringData(1, 1, "loginpage") } };
	}
}
