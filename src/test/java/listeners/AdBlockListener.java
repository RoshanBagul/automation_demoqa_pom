package listeners;

import org.testng.*;
import util.AdHandler;
import base.BasePage;

public class AdBlockListener implements IInvokedMethodListener {
    
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()){
            if (BasePage.getDriver() != null) {
                AdHandler.handleAds(BasePage.driver);
            }
        }

    }
}
