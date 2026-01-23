package tests.Widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.ElementsPage;
import pages.HomePage;
import pages.Widgets;

public class ProgressBarTest extends BaseTest {


   public Widgets widgets;
   public HomePage homePage;
   public ElementsPage elementsPage;

   @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        widgets = new Widgets(driver);
    }

    @Test(groups = {"smoke","WidgetPage"})
    public void testProgressBar() throws InterruptedException {
        homePage.openWidgetsPage();
        widgets.openProgressBar();
        widgets.clickStartStopButton();
        Thread.sleep(6000);
        widgets.clickStartStopButton();
    }
    
}
