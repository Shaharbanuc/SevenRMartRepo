package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LogInPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class SubCategoryTest extends BaseProject{
	HomePage homepage;
	SubCategoryPage subcategorypage;
	@Test
	public void VerifyTheUserIsAbleToCreateASubCategory() throws IOException
	{
		//status -passed(category name-phone,sub category name-android2,image-airfryers) if run again it will fail and subcategory already exists alert will be displayed,
		//the alert we are inspecting can not be inspected here again
		String subCategoryName=ExcelUtilities.readStringData(2,0,"subcategory");
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		LogInPage loginpage=new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=loginpage.clickOnSignInButton();
		subcategorypage=homepage.clickOnSubCategoryMoreinfo();
		subcategorypage.clickOnNewButton().selectValueToCategory().sendValueToSubCategory(subCategoryName).uploadImage().clickSave();
		boolean alert=subcategorypage.isSaveAlertDisplayed();
		System.out.println("alert");
		Assert.assertTrue(alert,Constants.MESSAGE_ASSERTION);
	}
	@Test
	public void VerifyTheUserIsAbleToCreateAExistingSubCategoryAgain() throws IOException
	{
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		String subCategoryName=ExcelUtilities.readStringData(2,0,"subcategory");
		
		/*SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		subcategorypage.enterUserNameOnUserField(usernamevalue);
		subcategorypage.enterPasswordOnPasswordField(passwordvalue);
		subcategorypage.clickOnSignInButton();*/
		LogInPage loginpage=new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=loginpage.clickOnSignInButton();
		//subcategorypage.clickOnSubCategoryMoreinfo();
		subcategorypage=homepage.clickOnSubCategoryMoreinfo();
		/*subcategorypage.clickOnNewButton();
		subcategorypage.selectValueToCategory();
		subcategorypage.sendValueToSubCategory(subCategoryName);	
		subcategorypage.uploadImage();
		subcategorypage.clickSave();*/
		subcategorypage.clickOnNewButton().selectValueToCategory().sendValueToSubCategory(subCategoryName).uploadImage().clickSave();
		boolean alertmessage=subcategorypage.isCancelAlertDisplayed();
		//System.out.println(alertmessage);
		Assert.assertTrue(alertmessage,Constants.MESSAGE_ASSERTION);
		//the below line will execute only if the assert is passed
		//System.out.println("end statement");
	}
	@Test
	public void VerifyTheUserIsAbleToChangeStatusOfSubCategory() throws IOException
	{
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		LogInPage loginpage=new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		//clickOnSignInButton shoud be a single line
		homepage=loginpage.clickOnSignInButton();
		subcategorypage=homepage.clickOnSubCategoryMoreinfo();
		//clicking status button is important,if we creating a news subcategory and changing its status we need to inspect the status button again
		subcategorypage.clickOnStatusButton();
		boolean statusalert=subcategorypage.isActiveStatusAlertDisplayed();
		System.out.println(statusalert);
		Assert.assertTrue(statusalert,Constants.MESSAGE_ASSERTION);
	}


}
