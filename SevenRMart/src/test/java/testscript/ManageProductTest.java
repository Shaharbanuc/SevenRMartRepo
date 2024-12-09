package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogInPage;
import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends BaseProject {
	ManageProductPage manageproductpage;
	HomePage homepage;

	@Test
	public void ToCheckUserIsAbleToCreateNewProductWithMandatoryFiledsEmpty() throws IOException, AWTException {
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "manage_product");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "manage_product");
		String title = ExcelUtilities.readStringData(1, 2, "manage_product");
		String price = ExcelUtilities.readIntigerData(1, 3, "manage_product");
		String description = ExcelUtilities.readStringData(1, 4, "manage_product");
		System.out.println(title);
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = loginpage.clickOnSignInButton();
		manageproductpage = homepage.clickOnManageProductButton();
		manageproductpage.clickOnNewIcon().enterValueOnTitleField(title).clickProdcutType().selectGroup()
				.enterValueOnPriceField(price).enterValueOnDescription(description).clickStockRadio().uploadImage()
				.clickOnSave();
		// boolean isalert=manageproductpage.alertDisplayed();
		// Assert.assertTrue(isalert, "New product created with empty mandatory
		// fields");
		String alertexpected = "Please enter stock count";
		String alertmessage = manageproductpage.simpleAlertDisplayed();
		Assert.assertEquals(alertmessage, alertexpected, "new product created with mandatory field weight blank");
	}

	@Test
	public void ToVerifyTheProductDescriptionfiledCanAcceptVideo() throws IOException {
		String usernamevalue = ExcelUtilities.readStringData(1, 0, "manage_product");
		String passwordvalue = ExcelUtilities.readStringData(1, 1, "manage_product");
		String description = ExcelUtilities.readStringData(1, 4, "manage_product");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = loginpage.clickOnSignInButton();
		manageproductpage = homepage.clickOnManageProductButton();
		manageproductpage.clickOnNewIcon().enterValueOnDescription(description).selectDescriptionField()
				.underLineDescriptionField().clickVideoIconDescriptionField().addVideoLinkDescriptionField()
				.clickInsertVideoButton().clickOnSave();
	}
}
