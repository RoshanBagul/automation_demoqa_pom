package tests;

import base.BasePage;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import util.ConfigReader;
import util.Helper;
import java.io.IOException;
import java.lang.reflect.Method;

public class ApiStatusValidationTest extends BasePage {

    public ElementsPage elementsPage;
    public HomePage homePage;

    @BeforeMethod
    public void setup(Method method){
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);
    }

    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }
    public static void logResponse(Response response) {
        if (test.get() != null) {

            test.get().info("Status Code:" + response.getStatusCode());
            test.get().info(response.asPrettyString());
        }
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateCreated() throws IOException {
        homePage.openElementsPage();
        elementsPage.openLinksPage();
        Helper.clickLinks("Created");

        String url = ConfigReader.get("Created");
        String body = "";

        Response response = base.BaseApi.sendPost(url,body);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertEquals(response.getStatusCode(),404);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateNoContent() throws IOException {
        homePage.openElementsPage();
        elementsPage.openLinksPage();
        Helper.clickLinks("No Content");

        String url = ConfigReader.get("No_content");
        Response response = base.BaseApi.sendGet(url);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertTrue(response.getStatusCode() == 204 || response.getStatusCode() == 200);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateUnauthorized() throws IOException {
        homePage.openElementsPage();
        elementsPage.openLinksPage();
        Helper.clickLinks("Unauthorized");

        String url = ConfigReader.get("Unauthorized");
        Response response = base.BaseApi.sendGet(url);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateForbidden() throws IOException {
        homePage.openElementsPage();
        elementsPage.openLinksPage();
        Helper.clickLinks("Forbidden");

        String url = ConfigReader.get("Forbidden");
        Response response = base.BaseApi.sendGet(url);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertEquals(response.getStatusCode(),403);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateNotFound() throws IOException, InterruptedException {
        homePage.openElementsPage();
        elementsPage.openLinksPage();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.linkText("Not Found"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        Helper.clickLinks("Not Found");

        String url = ConfigReader.get("Not_found");
        Response response = base.BaseApi.sendGet(url);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @AfterMethod
    public void tearDown(){
       extent.flush();
       test.remove();
   }
}
