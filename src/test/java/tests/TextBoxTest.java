package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TextBoxTest extends BaseTest {
    @Test (priority = -1)
    public void TestTextBoxValidation() throws InterruptedException, IOException {
        elementsPage elemental = new elementsPage(driver);
//        test = extent.createTest("Text Box Test");
        elemental.ValidateTextBox();
    }
}
