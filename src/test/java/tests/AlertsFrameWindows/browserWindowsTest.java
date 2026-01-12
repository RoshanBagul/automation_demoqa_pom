package tests.AlertsFrameWindows;
import base.BaseTest;
import pages.HomePage;
import utils.Helper;
import pages.AlertsFrameWindows;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class browserWindowsTest extends BaseTest {

    public HomePage homePage;
    public AlertsFrameWindows alertsFrameWindows;

    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        alertsFrameWindows = new AlertsFrameWindows(driver);
    }
    
    @Test (groups = {"smoke", "AlertsFrameWindows"})
    public void testValidateAlertsFrameWindowsPage() throws InterruptedException {
        homePage.openAlertsFrameWindowsPage();
        alertsFrameWindows.validateAlertsFrameWindowsPage();
        Helper.allowSingleTabOnly("New Tab", "sampleHeading");
        alertsFrameWindows.validateNewWindowOpened("New Window", "sampleHeading", "This is a sample page");
    }    
}
