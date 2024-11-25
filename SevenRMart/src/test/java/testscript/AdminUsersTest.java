package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LogInPage;

public class AdminUsersTest extends BaseProject{
	@Test
	public void VerifyTheAdminIsAbleToUpdateAdminUsersUserNameField()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		String usernameupdate="adminshanu123";
		String pwdupdate="123abc6";
		//AdminUsersPage has to be imported
		AdminUsersPage AdminUsersPage=new AdminUsersPage(driver);
		AdminUsersPage.enterUserNameOnUserField(usernamevalue);
		AdminUsersPage.enterPasswordOnPasswordField(passwordvalue);
		AdminUsersPage.clickOnSignInButton();
		AdminUsersPage.clickOnAdminUsersMoreInfo();
		AdminUsersPage.clickOnBlueButton();
		AdminUsersPage.editUserName(usernameupdate);
		AdminUsersPage.editPassword(pwdupdate);
		AdminUsersPage.editUserType();
		boolean updatesuccess=AdminUsersPage.clickOnUpdate();
		Assert.assertTrue(updatesuccess, "Failed to update values");
	}

}
