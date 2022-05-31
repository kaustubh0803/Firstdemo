package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportsNG {

	static ExtentReports extent;
	
	public static ExtentReports getextentreports() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Frameworkfromscratch");
		reporter.config().setDocumentTitle("FullFramework");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "kaustubh");
		return extent;
		
	}
}
