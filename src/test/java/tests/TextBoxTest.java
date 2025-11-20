package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import util.ConfigReader;
import java.io.IOException;

public class TextBoxTest extends BasePage {
    private HomePage homePage;
    private ElementsPage elementsPage;
    @BeforeMethod
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }
    @Test (priority = 3)
    public void validateTextBoxOutput() throws InterruptedException, IOException {
        homePage.openElementsPage();
        elementsPage.fillTextBoxForm();
        Assert.assertTrue(elementsPage.isOutputDisplayed(), "Output block is not displayed");

        String expectedName = "Name:" + elementsPage.full_name;
        String expectedEmail = "Email:" + ConfigReader.get("Email_id");
        String expectedCurrentAddress = "Current Address :" + ConfigReader.get("Current_address");
        String expectedPermanentAddress = "Permananet Address :" + ConfigReader.get("Permanent_address");


        Assert.assertEquals(elementsPage.getOutputName(), expectedName);
        Assert.assertEquals(elementsPage.getOutputEmail(), expectedEmail);
        Assert.assertEquals(elementsPage.getOutputCurrentAddress(), expectedCurrentAddress);
        Assert.assertEquals(elementsPage.getOutputPermanentAddress(), expectedPermanentAddress);
    }
}
