package tests;

import base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;


public class HomePageTest extends BasePage {
    public HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
    }

    @Test (priority = 1, groups = {"smoke", "ElementPage"})
    public void testLogo(){
        driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")); //Validating existence of logo image.
    }

    @Test (priority = 2, groups = {"smoke", "ElementPage"})
    public void testHeaderFooter(){
        driver.findElement(By.xpath("//header/a"));
        // Validation for Header
        driver.findElement(By.xpath("//footer/span[contains(text(),'2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]"));
        // Validation for Footer

    }
    @Test (priority = 3, groups = {"smoke", "ElementPage"})
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
