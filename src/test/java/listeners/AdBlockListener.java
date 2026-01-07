package listeners;

import org.testng.*;
import utils.AdHandler;
import base.BaseTest;

public class AdBlockListener implements ITestListener {

    static {
        System.out.println(">> AdBlockListener INITIALIZED");
    }


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">> AdBlockListener STARTED for test: " + result.getMethod().getMethodName());
    }


    // @Override
    // public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    //     if (method.isTestMethod()){
    //         if (BaseTest.getDriver() != null) {
    //             AdHandler.handleAds(BaseTest.getDriver());
    //         }
    //     }

    }
