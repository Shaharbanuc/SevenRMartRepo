package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LogInPage;
import utilities.ExcelUtilities;

public class AdminUsersTest extends BaseProject {

	HomePage homepage;
	AdminUsersPage adminuserpage;

	@Test
	public void VerifyTheAdminIsAbleToUpdateAdminUsersUserNameField() throws IOException {
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "loginpage");
		String usernameupdate = ExcelUtilities.readStringData(1, 0, "adminuserpage");
		String pwdupdate = ExcelUtilities.readStringData(1, 1, "adminuserpage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = loginpage.clickOnSignInButton();
		adminuserpage = homepage.clickOnAdminUsersMoreInfo();
		// check the blueicon webelement is present or not before executing
		adminuserpage.clickOnBlueButton().editUserName(usernameupdate).editPassword(pwdupdate).editUserType();
		boolean updatesuccess = adminuserpage.clickOnUpdate();
		Assert.assertTrue(updatesuccess, "Failed to update values");
	}

}
