package tests.Elements;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import java.io.IOException;

public class TextBoxTest extends BaseTest{
    public ElementsPage elementsPage;
    public HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }
    @Test (groups = {"smoke", "ElementPage"})
    public void TestTextBoxValidation() throws InterruptedException, IOException {
        homePage.openElementsPage();
        elementsPage.fillTextBoxForm();
    }
}
