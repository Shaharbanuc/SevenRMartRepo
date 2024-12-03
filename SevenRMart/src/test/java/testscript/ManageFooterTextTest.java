package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogInPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends BaseProject{
	@Test
	public void CheckTheUpdateButtonIsDisplayedOnFooterTextPage() throws IOException
	{
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		ManageFooterTextPage manageFootertextpage=new ManageFooterTextPage(driver);
		manageFootertextpage.enterUserNameOnUserField(usernamevalue);
		manageFootertextpage.enterPasswordOnPasswordField(passwordvalue);
		manageFootertextpage.clickOnSignInButton();
		manageFootertextpage.clickOnFooterLink();
		manageFootertextpage.clickOnEditButton();
		boolean isupdatepresent=manageFootertextpage.isUpdateButtonDisplayed();
		Assert.assertTrue(isupdatepresent,"The update button is not displayed");
		//the below line will execute only if the assert is passed
		//System.out.println("end statement");
	}
	@Test
	public void ToCheckTheUserIsAbleToUpdateAFooterTextWithInvalidEmailAndPhone() throws IOException
	{
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		String fulladdress=ExcelUtilities.readStringData(1,0,"footertext");
		String emailfield=ExcelUtilities.readStringData(1,1,"footertext");
		String phonefield=ExcelUtilities.readStringData(1,2,"footertext");
		ManageFooterTextPage manageFootertextpage=new ManageFooterTextPage(driver);
		manageFootertextpage.enterUserNameOnUserField(usernamevalue);
		manageFootertextpage.enterPasswordOnPasswordField(passwordvalue);
		manageFootertextpage.clickOnSignInButton();
		manageFootertextpage.clickOnFooterLink();
		manageFootertextpage.clickOnEditButton();
		manageFootertextpage.enetrValueInAddress(fulladdress);
		manageFootertextpage.enetrValueInEmail(emailfield);
		manageFootertextpage.enetrValueInPhone(phonefield);
		manageFootertextpage.clickOnUpdateButton();
		boolean isalertpresent=manageFootertextpage.isSuccessAlertDisplayed();
		//entering invalid data,alert shouldnt come,if it came it returns true,it should be false then only tc pass. 
		Assert.assertFalse(isalertpresent,"The email field and phone filed accept invalid data");
	}
}