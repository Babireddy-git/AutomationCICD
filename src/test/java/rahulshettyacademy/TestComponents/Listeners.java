package rahulshettyacademy.TestComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();
	public void onTestStart(String result) {
		extent.createTest(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("All tests finished.");
	}
}
