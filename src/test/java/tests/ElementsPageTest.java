package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ElementsPage;

public class ElementsPageTest extends BaseTest {

    @Test (priority = 2)
    public void TestElementsPageValidation() throws InterruptedException {
        ElementsPage elementsPage = new ElementsPage(driver);
//        test = extent.createTest("Elements Page Test");
//        elemental.validateElementsPage();
        elementsPage.validateHomepage();

    }
}
