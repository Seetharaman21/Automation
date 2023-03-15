package com.profit.qa.ExtentReportListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.profit.qa.Base.Base;

public class ExtentReportNG {

	static ExtentReports extent;
	static Properties prop;


	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("_ddMMyyyy_HHmmss");

		Date date = new Date();
		String actualDate = format.format(date);
		String reportName ="profit" +actualDate+ ".html";

		Base.saveOnProperties("src/main/java/com/profit/qa/Properties/email.properties", "reportName", reportName);
		String reportPath = System.getProperty("user.dir")+"/Reports/"+reportName;

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

		extent = new ExtentReports();
		extent.attachReporter(sparkReport);

		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("ReportName");
		prop=Base.getPropertyAccess("src/main/java/com/profit/qa/Properties/config.properties");
	//	extent.setSystemInfo("Executed on Environment: ", prop.getProperty("loginUrl"));
		extent.setSystemInfo("Executed on Environment: ", prop.getProperty("loginUrl"));

		extent.setSystemInfo("Executed on Browser: ", prop.getProperty("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

		return extent;
	}

}
