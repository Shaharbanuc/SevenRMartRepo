package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	//driver quit should be called and the aftermethod annotation should be there
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException { 
		//Indicates a driver or an HTML element that can capture a screenshot and store it in differentways
 		TakesScreenshot scrShot = (TakesScreenshot) driver; 
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); 
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); 
 		//creating folder
 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); 
 		//if we delete the f1 it will create automatically
 		if (!f1.exists()) { 
 			f1.mkdirs(); 
 		} 
 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp + ".png"; 
 		File finalDestination = new File(destination); 
 		FileHandler.copy(screenShot, finalDestination); 
 	}

}
