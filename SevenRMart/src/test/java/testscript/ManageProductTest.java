package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends BaseProject{
	@Test
	public void ToCheckUserIsAbleToCreateNewProductWithMandatoryFiledsEmpty() throws IOException, AWTException
	{
		String usernamevalue=ExcelUtilities.readStringData(1,0,"manage_product");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"manage_product");
		String title=ExcelUtilities.readStringData(1,2,"manage_product");
		String price=ExcelUtilities.readIntigerData(1,3,"manage_product");
		String description=ExcelUtilities.readStringData(1,4,"manage_product");		System.out.println(title);
		ManageProductPage manageproductpage=new ManageProductPage(driver);
		manageproductpage.enterUserNameOnUserField(usernamevalue);
		manageproductpage.enterPasswordOnPasswordField(passwordvalue);
		manageproductpage.clickOnSignInButton();
		manageproductpage.clickOnManageProductButton();
		
		manageproductpage.clickOnNewIcon();
		manageproductpage.enterValueOnTitleField(title);
		manageproductpage.enterValueOnPriceField(price);
		manageproductpage.enterValueOnDescription(description);
		manageproductpage.uploadImage();
		manageproductpage.clickOnSave();
		//boolean isalert=manageproductpage.alertDisplayed();
		//Assert.assertTrue(isalert, "New product created with empty mandatory fields");
		String alertexpected="Please enter weight price";
		String alertmessage=manageproductpage.simpleAlertDisplayed();
		Assert.assertEquals(alertmessage, alertexpected, "new product created with empty mandatory fields");
		
	}
}
