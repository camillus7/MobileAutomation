package commonUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commonUtil.PropertiesUtil;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		init(outputDirectory);
		// extent = new ExtentReports(outputDirectory + File.separator +
		// "ExtentReportTestNG.html", true);
		String reportFolder = outputDirectory + "/Extent_Execution_Reports/";
		File resourcesFolder = new File(reportFolder + "screenshots/");

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), Status.PASS, resourcesFolder);
				buildTestNodes(context.getFailedTests(), Status.FAIL, resourcesFolder);
				buildTestNodes(context.getSkippedTests(), Status.SKIP, resourcesFolder);

			}
		}

		for (String s : Reporter.getOutput()) {
			extent.setTestRunnerOutput(s);
		}

		extent.flush();

	}

	private void init(String outputDirectory) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String reportFolder = outputDirectory + "/Extent_Execution_Reports/";
		String reportType = "Po3_Auto_Regression_";
		if (PropertiesUtil.getValue(PropertiesUtil.URL_PROPERTY).contains("we")) {
			reportType = "WE_Enterprise_";
		} else if (PropertiesUtil.getValue(PropertiesUtil.URL_PROPERTY).contains("my")) {
			reportType = "MyWin_Consumer_";
		}
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				reportFolder + reportType + PropertiesUtil.getValue(PropertiesUtil.BROWSER_PROPERTY) + "_"
						+ dateFormat.format(date).replace("-", "") + ".html");
		htmlReporter.config().setDocumentTitle("Web Automation - Execution Report");
		htmlReporter.config().setReportName("Web Automation Results");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);
	}

	private void buildTestNodes(IResultMap tests, Status status, File imageFolder) {
		ExtentTest test;
		if (!imageFolder.exists()) {
			imageFolder.mkdirs();
		}

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getMethod().getMethodName());
				test.getModel().setStartTime(getTime(result.getStartMillis()));
				test.getModel().setEndTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				String message = "Test " + status.toString().toLowerCase() + "ed";
				test.log(Status.INFO, result.getName());
				List<String> msgs = Reporter.getOutput(result);
				// test.log(LogStatus.INFO,"Execution Log : = "+msgs.toString());
				for (String msg : msgs) {
					if (msg.toString().contains(".png")) {
						try {
							File imgFile = new File(msg.toString());
							imgFile.renameTo(
									new File(imageFolder.getAbsolutePath() + File.separator + imgFile.getName()));
							String relativePath = "." + File.separator + imageFolder.getName() + File.separator
									+ imgFile.getName();
							test.warning("***********  Test Case Failed *************")
									.addScreenCaptureFromPath(relativePath);
						} catch (Exception e) {
							test.log(Status.WARNING, "Failed to Load Image");
						}
					} else {
						if (msg.toString().contains("true")) {
							test.log(Status.PASS, msg.toString());
						} else {
							test.log(Status.INFO, msg.toString());
						}

					}
				}
				if (result.getThrowable() != null)
					message = message + " # Error message :=" + result.getThrowable().getMessage()
							+ System.getProperty("line.separator") + "and Stack trace:= " + result.getThrowable();

				test.log(status, message);
				// extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
