package tests;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

public class ElementsPageTest extends BasePage {
    private HomePage homePage;
    private ElementsPage elementsPage;
    @BeforeMethod
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }

//    @Test (priority = -1)
//    public void TestElementsPageValidation() throws InterruptedException {
//        ElementsPage elementsPage = new ElementsPage(driver);
//    }

    @Test (priority = 4)
    public void  testCheckBoxValidation(){
        homePage.openElementsPage();
        elementsPage.validateCheckBox();
    }
}
