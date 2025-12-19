package tests.Elements;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

public class ElementsPageTest extends BasePage {
    public HomePage homePage;
    public ElementsPage elementsPage;
    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }

    @Test (groups = {"smoke", "ElementPage"})
    public void  testCheckBoxValidation(){
        homePage.openElementsPage();
        elementsPage.validateCheckBox();
    }
}
