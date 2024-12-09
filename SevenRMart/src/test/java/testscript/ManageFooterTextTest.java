package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogInPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends BaseProject {
	HomePage homepage;
	ManageFooterTextPage managefootertextpage;

	@Test
	public void CheckTheUpdateButtonIsDisplayedOnFooterTextPage() throws IOException {
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "loginpage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = loginpage.clickOnSignInButton();
		managefootertextpage = homepage.clickOnFooterLink();
		managefootertextpage.clickOnEditButton();
		boolean isupdatepresent = managefootertextpage.isUpdateButtonDisplayed();
		Assert.assertTrue(isupdatepresent, "The update button is not displayed");
	}

	@Test
	public void ToCheckTheUserIsAbleToUpdateAFooterTextWithInvalidEmailAndPhone() throws IOException {
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "loginpage");
		String fulladdress = ExcelUtilities.readStringData(1, 0, "footertext");
		String emailfield = ExcelUtilities.readStringData(1, 1, "footertext");
		String phonefield = ExcelUtilities.readStringData(1, 2, "footertext");

		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = loginpage.clickOnSignInButton();
		managefootertextpage = homepage.clickOnFooterLink();
		managefootertextpage.clickOnEditButton().enetrValueInAddress(fulladdress).enetrValueInEmail(emailfield)
				.enetrValueInPhone(phonefield).clickOnUpdateButton();
		boolean isalertpresent = managefootertextpage.isSuccessAlertDisplayed();
		// giving invalid data so expected no update,but isalertpresent value is true
		// means success alert,so tc fails.
		Assert.assertFalse(isalertpresent, "The email field and phone filed accept invalid data");
	}
}