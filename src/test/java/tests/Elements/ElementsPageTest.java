package tests.Elements;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

public class ElementsPageTest extends BaseTest {

    public HomePage homePage;
    public ElementsPage elementsPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }

    @Test (groups = {"smoke", "ElementPage"})
    public void  TestCheckBoxValidation(){
        homePage.openElementsPage();
        elementsPage.validateCheckBox();
    }
}
