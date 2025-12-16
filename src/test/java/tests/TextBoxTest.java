package tests;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

import java.io.IOException;

public class TextBoxTest extends BasePage{
    public static ElementsPage elementsPage;
    public static HomePage homePage;

    @BeforeMethod
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }
    @Test
    public void TestTextBoxValidation() throws InterruptedException, IOException {
        homePage.openElementsPage();
        elementsPage.fillTextBoxForm();
    }
}
