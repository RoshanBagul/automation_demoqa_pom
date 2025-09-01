package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;


public class HomePageTest extends BaseTest {
    @Test (priority = 1)
    public void testValidationOfHomePage(){

        HomePage homePage = new HomePage(driver);
//        test = extent.createTest("Home Page Test");
        homePage.validateHomepage();
        System.out.println("Title of the page is: "+ driver.getTitle());
    }

}
