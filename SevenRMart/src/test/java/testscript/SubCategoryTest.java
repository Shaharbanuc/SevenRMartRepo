package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class SubCategoryTest extends BaseProject{
	@Test
	public void VerifyTheUserIsAbleToCreateASubCategory() throws IOException
	{
		//status -passed if run again it will fail and subcategory already exists alert will be displayed,
		//the alert we are inspecting can not be inspected for same subcategory name
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		String subCategoryName=ExcelUtilities.readStringData(1,0,"subcategory");
		
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		
		subcategorypage.enterUserNameOnUserField(usernamevalue);
		subcategorypage.enterPasswordOnPasswordField(passwordvalue);
		subcategorypage.clickOnSignInButton();
		subcategorypage.clickOnSubCategoryButton();
		subcategorypage.clickOnNewButton();
		subcategorypage.selectValueToCategory();
		subcategorypage.sendValueToSubCategory(subCategoryName);	
		subcategorypage.uploadImage();
		subcategorypage.clickSave();
		boolean alert=subcategorypage.isSaveAlertDisplayed();
		System.out.println("alert");
		Assert.assertTrue(alert, "Alert is not dispalyed.");
	}
	@Test
	public void VerifyTheUserIsAbleToCreateAExistingSubCategoryAgain() throws IOException
	{
		//status -passed if run again it will fail and subcategory already exists alert will be displayed,
		//the alert we are inspecting can not be inspected for same subcategory name
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		String subCategoryName=ExcelUtilities.readStringData(1,0,"subcategory");
		
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		
		subcategorypage.enterUserNameOnUserField(usernamevalue);
		subcategorypage.enterPasswordOnPasswordField(passwordvalue);
		subcategorypage.clickOnSignInButton();
		subcategorypage.clickOnSubCategoryButton();
		subcategorypage.clickOnNewButton();
		subcategorypage.selectValueToCategory();
		subcategorypage.sendValueToSubCategory(subCategoryName);	
		subcategorypage.uploadImage();
		subcategorypage.clickSave();
		boolean alertmessage=subcategorypage.isCancelAlertDisplayed();
		//System.out.println(alertmessage);
		Assert.assertTrue(alertmessage, "Alert is not dispalyed");
	}
	@Test
	public void VerifyTheUserIsAbleToChangeStatusOfSubCategory() throws IOException
	{
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		
		subcategorypage.enterUserNameOnUserField(usernamevalue);
		subcategorypage.enterPasswordOnPasswordField(passwordvalue);
		subcategorypage.clickOnSignInButton();
		subcategorypage.clickOnSubCategoryButton();
		//clicking status button is important
		subcategorypage.clickOnStatusButton();
		boolean statusalert=subcategorypage.isActiveStatusAlertDisplayed();
		System.out.println(statusalert);
		Assert.assertTrue(statusalert, "Alert is not dispalyed");
	}


}
