package framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import framework.utils.ExtentManager;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getExtentReports();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        String desc = result.getMethod().getDescription();
        // Use the test description if available
        String displayName = (desc != null && !desc.isEmpty())
                ? desc + " [" + result.getMethod().getMethodName() + "]"
                : result.getMethod().getMethodName();

        ExtentTest extentTest = extent.createTest(displayName);
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        // This runs before <test> tag starts to initialize the test
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}