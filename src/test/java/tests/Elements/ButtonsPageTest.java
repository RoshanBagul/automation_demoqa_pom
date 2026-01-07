package tests.Elements;

import base.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

public class ButtonsPageTest extends BaseTest {
    public ElementsPage elementsPage;
    public HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }

    @Test (groups = {"smoke", "ElementPage"})
    public void TestButtonsPage() throws InterruptedException{
        homePage.openElementsPage();
        elementsPage.validateButtonsPage();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(), "You have done a double click");
        Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).getText(),"You have done a right click");
        Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).getText(),"You have done a dynamic click");
    }
}
