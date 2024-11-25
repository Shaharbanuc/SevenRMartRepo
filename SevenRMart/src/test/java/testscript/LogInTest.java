package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogInPage;
import utilities.ExcelUtilities;

public class LogInTest extends BaseProject{
	@Test
	public void VerifyTheUserIsAbleToLogInUsingValidCredentials() throws IOException
	{
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		//instead of loginpage we should give LoginPage
		String usernamevalue=ExcelUtilities.readStringData(1,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(1,1,"loginpage");
		LogInPage loginpage=new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean homepagedisplayed=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepagedisplayed,"Home page not loaded when user entered valid credentials");
		
	}
	@Test
	public void VerifyTheUserIsNotAbleToLogInUsingInValidPassword() throws IOException
	{
		//String usernamevalue="admin";
		//String passwordvalue="admin12";
		String usernamevalue=ExcelUtilities.readStringData(2,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(2,1,"loginpage");
		LogInPage loginpage=new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		/*String message=loginpage.getErrorMessage();
		System.out.println(message);
		String expected="×\nAlert!\nInvalid Username/Password";
		Assert.assertEquals(message,expected,"Log in failed and error message not as per requirement");*/
		
		boolean errordisplayed=loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(errordisplayed,"Error message is not displayed and user is able to login with invalid password");
	}
    @Test(retryAnalyzer=retry.Retry.class)
	public void VerifyTheUserIsNotAbleToLogInUsingInValidUserName() throws IOException
	{
		//String usernamevalue="admin90";
		//String passwordvalue="admin";	
    	String usernamevalue=ExcelUtilities.readStringData(3,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(3,1,"loginpage");
		LogInPage loginpage=new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean errordisplayed=loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(errordisplayed,"Error message is not displayed and user is able to login with invalid username");
	}
    @Test
    public void VerifyTheUserIsNotAbleToLogInUsingInValidCredentials() throws IOException
	{
		//String usernamevalue="admin90";
		//String passwordvalue="admin12";	
    	String usernamevalue=ExcelUtilities.readStringData(4,0,"loginpage");
		String passwordvalue=ExcelUtilities.readStringData(4,1,"loginpage");
		LogInPage loginpage=new LogInPage(driver);
		loginpage.enterUserNameOnUserField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean errordisplayed=loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(errordisplayed,"Error message is not displayed and user is able to login with invalid credentials");
	}
}
