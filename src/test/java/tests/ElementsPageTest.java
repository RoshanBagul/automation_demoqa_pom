package tests;

import base.BasePage;
import org.testng.annotations.Test;
import pages.ElementsPage;

public class ElementsPageTest extends BasePage {

    @Test (priority = 2)
    public void TestElementsPageValidation() throws InterruptedException {
        ElementsPage elementsPage = new ElementsPage(driver);
    }
}
