package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogInPage;
import pages.ManageNewsPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends BaseProject {
	HomePage homepage;
	ManageNewsPage managenewspage;

	@Test(description = "Check user is able to create a new news")
	public void VerifyTheUserIsAbleToCreateANews() throws IOException {
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "loginpage");
		String News = ExcelUtilities.readStringData(1, 0, "managenews");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = loginpage.clickOnSignInButton();
		managenewspage = homepage.clickOnManageNewsButton();
		managenewspage.clickOnNewButton().eneterValueInNewsField(News).clickOnSave();
		boolean isalert = managenewspage.isAlertdisplayed();
		Assert.assertTrue(isalert, "no alert displayed");
	}

	@Test(description = "Check user is able to delete the news from the list of news")
	public void VerifyTheUserIsAbleToDeleteNews() throws IOException {
		// before running this tc inspect the xpath of deleteicon of the news,it will
		// keep on changing
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "loginpage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = loginpage.clickOnSignInButton();
		managenewspage = homepage.clickOnManageNewsButton();
		managenewspage.clickOnDelete().deleteConfirmationAlert();
		boolean isalert = managenewspage.isAlertDisplayedAfterDelete();
		Assert.assertTrue(isalert, "no alert displayed");
	}

}
