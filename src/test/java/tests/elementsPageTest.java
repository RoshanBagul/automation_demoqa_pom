package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.elementsPage;

import java.io.IOException;

public class elementsPageTest extends BaseTest {

    @Test (priority = 2)
    public void TestElementsPageValidation() throws InterruptedException {
        elementsPage elemental = new elementsPage(driver);
//        test = extent.createTest("Elements Page Test");
        elemental.validateElementsPage();
    }

}
