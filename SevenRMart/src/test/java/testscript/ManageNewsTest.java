package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageNewsPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends BaseProject{
	@Test
	public void VerifyTheUserIsAbleToCreateANews() throws IOException
	{
		//status -passed if run again it will fail and subcategory already exists alert will be displayed,
		//the alert we are inspecting can not be inspected for same subcategory name
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		String News=ExcelUtilities.readStringData(1,0,"managenews");
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.enterUserNameOnUserField(usernamevalue);
		managenewspage.enterPasswordOnPasswordField(passwordvalue);
		managenewspage.clickOnSignInButton();
		
		managenewspage.clickOnManageNewsButton();
		managenewspage.clickOnNewButton();
		managenewspage.eneterValueInNewsField(News);
		managenewspage.clickOnSave();
		boolean isalert=managenewspage.isAlertdisplayed();
		Assert.assertTrue(isalert, "no alert displayed");
	}
	@Test
	public void VerifyTheUserIsAbleToDeleteNews() throws IOException
	{
		//deleting the above created news 
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.enterUserNameOnUserField(usernamevalue);
		managenewspage.enterPasswordOnPasswordField(passwordvalue);
		managenewspage.clickOnSignInButton();
		
		managenewspage.clickOnManageNewsButton();
		
		managenewspage.clickOnDelete();
		managenewspage.deleteConfirmationAlert();
		boolean isalert=managenewspage.isAlertDisplayedAfterDelete();
		Assert.assertTrue(isalert, "no alert displayed");
	}
	

}
