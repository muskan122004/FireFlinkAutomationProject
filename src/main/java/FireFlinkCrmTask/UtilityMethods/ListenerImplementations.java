package FireFlinkCrmTask.UtilityMethods;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementation for ITESTListener of testng
 * @author Chaitra M
 *
 */
public class ListenerImplementations implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Execution started------");
	
		//Intimate extent reports for @Test start
		test = report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Execution PASS------");
		
		//Log the status OF @Test as PASS in extent report
		test.log(Status.PASS, methodName+"------Test Execution PASS------");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Execution FAIL------");
		
		//Log the status as Fail in Extent reports
		test.log(Status.FAIL, methodName+"------Test Execution FAIL------");
		
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture the screenshot
		javaUtility j = new javaUtility();
		WebDriverUtility w = new WebDriverUtility();
		
		//Screenshotname - method name + date n time
		String screenshotname = methodName+j.getDate();
		
		try {
			
			String path = w.captureSceenshot(BaseClass.sdriver, screenshotname);
			
			//Attach screenshot to report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Execution SKIP------");
		
		//Log the SKIP status
		test.log(Status.SKIP, methodName+"------Test Execution SKIP------");
		
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		//log the exception
		test.log(Status.WARNING, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("---------Suite Execution Started------------");
		
		//Extent Report Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Extent-Report-"+new javaUtility().getDate()+".html");
		esr.config().setDocumentTitle("Ninza CRM Automation Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Web Automation Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "Test Env");
		report.setSystemInfo("Reporter Name", "Chaitra");
		
		
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("---------Suite execution finished------------");
		
		//Report generation
		report.flush();
		
		
	}
}
