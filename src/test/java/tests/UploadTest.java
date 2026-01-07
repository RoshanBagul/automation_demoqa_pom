package tests;

import base.BasePage;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

public class UploadTest extends BasePage {

    public HomePage homePage;
    public ElementsPage elementsPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }

    @Test
    public void testFileUpload(){
        homePage.openElementsPage();
        elementsPage.openUploadAndDownloadPage();
        String filePath = System.getProperty("user.dir") + "/src/test/resources/upload/pomimage.png";

        System.out.println("Uploading file from: " + filePath);

        elementsPage.uploadFile(filePath);

        driver.findElement(By.xpath("//p[@id='uploadedFilePath']")).isDisplayed();
    }
}
