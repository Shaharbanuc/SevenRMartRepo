package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn extends BaseProject{
	@Test
	public void logInTest()
	{
		//this java file is not required coz it has no pom and page factory
		String usernamevalue="admin";
		String passwordvalue="admin";
		WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys(usernamevalue);
		WebElement pwd=driver.findElement(By.xpath("//input[@type='password']"));
		pwd.sendKeys(passwordvalue);
		WebElement remember=driver.findElement(By.xpath("//label[@for='remember']"));
		remember.click();
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		
		WebElement dashboardvalue=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		//assertTrue returns boolean value
		boolean ishomepageavailable=dashboardvalue.isDisplayed();
		Assert.assertTrue(ishomepageavailable,"Login Failed");
	}
	@Test
	public void logInWithInvalidPwd()
	{
		String usernamevalue="admin";
		String passwordvalue="admin12";
		WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys(usernamevalue);
		WebElement pwd=driver.findElement(By.xpath("//input[@type='password']"));
		pwd.sendKeys(passwordvalue);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		//String s=driver.switchTo().alert().getText();
		
		
	}

}
