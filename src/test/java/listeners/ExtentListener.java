package listeners;

import base.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.ExtentManager;
import util.ScreenshotUtil;

public class ExtentListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    @Override
    public void onTestStart(ITestResult result){
        // Create Extenttest with class + method name
        System.out.println(">> ExtentListener STARTED");

        String testName = result.getMethod().getMethodName();
        ExtentTest extentTest = extent.createTest(testName);
        // Store it in BaseTest's ThreadLocal
        BasePage.test.set(extentTest);
    }
    @Override
    public void onTestSuccess(ITestResult result){
        ExtentTest test = BasePage.getTest();
        if (test != null) {
            test.pass("Test passed");
        }
    }
    @Override
    public void onTestFailure(ITestResult result){
        ExtentTest test = BasePage.getTest();
        WebDriver driver = BasePage.getDriver();

        if (test != null) {
            test.fail(result.getThrowable());

            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());
            if (screenshotPath != null) {
                try {
                    test.addScreenCaptureFromPath(screenshotPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = BasePage.getTest();
        if (test != null){
            test.skip(result.getThrowable());
        }
    }
    @Override
    public void onFinish(ITestContext context) {

        if (extent != null){
            System.out.println("Flushing extent report...");
            extent.flush();
        }
    }
}
