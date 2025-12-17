package tests.Elements;

import base.BasePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

import java.io.IOException;

public class RadioButtonPageTest extends BasePage {

    public static ElementsPage elementsPage;
    public static HomePage homePage;
    @BeforeMethod
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }

    @Test
    public void testRadioButtonValidation() throws InterruptedException, IOException {
        homePage.openElementsPage();
        elementsPage.validateRadioButton();
    }
}
