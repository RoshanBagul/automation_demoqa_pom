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
    @Test (priority = 1)
    public void testValidationOfHomePage() throws InterruptedException {
        homePage.validateHomepage();
        System.out.println("Title of the page is: "+ driver.getTitle());

        homePage.openElementsPage();
        driver.navigate().back();

        homePage.openFormsPage();
        driver.navigate().back();

        homePage.openAlertsFrameWindowsPage();
        driver.navigate().back();

        homePage.openInteractionsPage();
        driver.navigate().back();

        homePage.openWidgetsPage();
        driver.navigate().back();

        homePage.openBookCardPage();
    }
}
