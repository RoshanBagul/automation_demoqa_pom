package tests.Elements;

import base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import util.ConfigReader;

import java.io.IOException;

public class WebTablePageTest extends BasePage {

    public ElementsPage elementsPage;
    public HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }


    @Test(groups = {"smoke", "ElementPage"})
    public void TestRegistrationForm() throws IOException, InterruptedException {
        homePage.openElementsPage();
        elementsPage.validateWebTables();
        elementsPage.fillRegistrationForm();
        elementsPage.validateInputTextlength("10", "salary");
        elementsPage.validateInputTextlength("2", "age");
        elementsPage.validateInputTextlength("25","department");
        elementsPage.validateInputTextlength("25", "firstName");
        elementsPage.validateInputTextlength("25", "lastName");
        elementsPage.clickSubmitButton();
        elementsPage.validateSearchBox("Test");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[1]")).getText(),ConfigReader.get("First_Name"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[2]")).getText(),ConfigReader.get("Last_Name"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[3]")).getText(),ConfigReader.get("Age"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[4]")).getText(),ConfigReader.get("Email_id"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[5]")).getText(),ConfigReader.get("Salary"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[6]")).getText(),ConfigReader.get("Department"));
    }
}
