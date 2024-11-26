package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	
	public static final ExtentReports extentReports = new ExtentReports();
	//method will return an instance of ExtentReports and it is synchronized means thread-safe.
	public synchronized static ExtentReports createExtentReports() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		//project name
		reporter.config().setReportName("7RMart  Project");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Shaharbanu");
		return extentReports;
	}

}
