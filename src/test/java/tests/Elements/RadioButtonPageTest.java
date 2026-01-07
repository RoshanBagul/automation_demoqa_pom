package tests.Elements;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

public class RadioButtonPageTest extends BaseTest {

    public ElementsPage elementsPage;
    public HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }

    @Test(groups = {"smoke", "ElementPage"})
    public void testRadioButtonValidation() {
        homePage.openElementsPage();
        elementsPage.validateRadioButton("Yes","Impressive");
    }
}
