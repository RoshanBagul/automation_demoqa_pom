package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ConfigReader;
import pages.HomePage;


public class HomePageTest extends BaseTest {
    @Test (priority = 1)
    public void testValidationOfHomePage(){

        HomePage homePage = new HomePage(driver);
//        test = extent.createTest("Home Page Test");
        homePage.validateHomepage();
        System.out.println("Title of the page is: "+ driver.getTitle());
    }
}
