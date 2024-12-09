package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//inorder to help page class
public class PageUtility {

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public String getAlertText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		return text;
	}

	public void acceptAlert(WebDriver driver) {
		/*
		 * Alert alert = driver.switchTo().alert(); alert.accept();
		 */
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		// actions.moveToElement(element).build().perform();
		// import Keys
		// cursor is there inside field so not using moveToElement
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement dragableItem, WebElement dropItem) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragableItem, dropItem).build().perform();
		;
	}

	public void singleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

	public void rightClick(WebDriver driver, WebElement dragableItem) {
		Actions actions = new Actions(driver);
		actions.contextClick(dragableItem).build().perform();
	}

	public void clickOnWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
}
