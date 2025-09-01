package listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.ExtentManager;

public class ExtentListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    @Override
    public void onTestStart(ITestResult result){
        System.out.println(">> ExtentListener STARTED");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }
    @Override
    public void onTestSuccess(ITestResult result){
        test.get().log(Status.PASS, "Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result){
        test.get().log(Status.FAIL, "Test Failed");
        test.get().log(Status.FAIL, result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped");
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Flushing extent report...");
        extent.flush();
    }
}
