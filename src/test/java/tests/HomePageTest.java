package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;


public class HomePageTest extends BasePage {
    private HomePage homePage;
    @BeforeMethod
    public void initPages(){
        homePage = new HomePage(driver);
    }
    @Test
    public void testValidationOfHomePage() throws InterruptedException {

//        ElementsPage elementsPage = homePage.validateHomepage();
//        Assert.assertTrue(homePage.validateHomepage(), "Home Page not displayed");
        homePage.validateHomepage();
        System.out.println("Title of the page is: "+ driver.getTitle());

        homePage.openElementsPage();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        homePage.openFormsPage();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        homePage.openAlertsFrameWindowsPage();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        homePage.openInteractionsPage();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        homePage.openWidgetsPage();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        homePage.openBookCardPage();
        Thread.sleep(2000);
    }
}
