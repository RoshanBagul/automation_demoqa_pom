package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import util.ConfigReader;
import java.io.IOException;

public class TextBoxTest extends BaseTest {

    @Test (priority = -1)
    public void validateTextBoxOutput() throws InterruptedException, IOException {
        ElementsPage elementsPage = new ElementsPage(driver);

        elementsPage.fillTextBoxForm();

        Assert.assertTrue(elementsPage.isOutputDisplayed(), "Output block is not displayed");

        String expectedName = "Name:" + elementsPage.full_name;
        String expectedEmail = "Email:" + ConfigReader.get("Email_id");
        String expectedCurrentAddress = "currentAddress:" + ConfigReader.get("Current_address");
        String expectedPermanentAddress = "permanentAddress:" + ConfigReader.get("Permanent_address");


        Assert.assertEquals(elementsPage.getOutputName(), expectedName);
        Assert.assertEquals(elementsPage.getOutputEmail(), expectedEmail);
        Assert.assertEquals(elementsPage.getOutputCurrentAddress(), expectedCurrentAddress);
        Assert.assertEquals(elementsPage.getOutputPermanentAddress(), expectedPermanentAddress);
    }
}
