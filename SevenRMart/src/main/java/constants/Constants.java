package constants;

public class Constants {
	//right click on excel under src/test/resources->properties->copy path starting from src till end from the appeared window
	//in path \\ is important before src
	public static final String TESTDATAFILE=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	public static final String STRAWBERRY_IMAGE=System.getProperty("user.dir")+"\\src\\test\\resources\\strawberry.jpg";
	public static final String AIRFRYER_IMAGE=System.getProperty("user.dir")+"\\src\\test\\resources\\airfryerimage.jpg";
	public static final String CONFIG_FILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	public static final String MESSAGE="Home page not loaded when user entered valid credentials";
	public static final String MESSAGE_TWO="Home page loaded when user entered invalid credentials";
	public static final String MESSAGE_ASSERTION="Test case failed";
}
