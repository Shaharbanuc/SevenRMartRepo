package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtilities {

	public void fileuploadUsingSendkeys(WebElement element, String path) {
		// path we get when this method get invoked from ManageProductPage
		element.sendKeys(path);
	}

	public void FileuploadUsingRobotclass(WebElement element, String path) throws AWTException {
		element.click();
		StringSelection stringselection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		Robot robot = new Robot();
		robot.delay(2500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
