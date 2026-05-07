package reporter;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.Utilities;

public class ExtentReportsListener implements ITestListener {
    ExtentReports report;
    ExtentTest test;
    String testName;

    @Override
    public void onStart(ITestContext context){
        try {
            report = ExtentReporter.extentReporter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        testName = result.getName();
        test = report.createTest(testName);
        test.info("Execution started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass(testName+" execution passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseClass)result.getInstance()).getDriver();
        try {
            String location = Utilities.getScreenshot(driver, testName);
            test.fail(result.getThrowable());
            test.addScreenCaptureFromPath(location);
            test.fail(testName+" execution failed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Execution skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}
