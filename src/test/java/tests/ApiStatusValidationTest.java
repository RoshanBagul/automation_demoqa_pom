package tests;

import api.BaseApi;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.ConfigReader;
import util.ExtentManager;

import java.io.IOException;
import java.lang.reflect.Method;

import static listeners.ExtentListener.test;
import static util.ExtentManager.extent;

public class ApiStatusValidationTest {

    protected static ExtentReports extent = ExtentManager.getInstance();
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeMethod
    public void setup(Method method){
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);
    }

    public static void logResponse(Response response) {
        if (test.get() != null) {

            test.get().info("Status Code:" + response.getStatusCode());
            test.get().info(response.asPrettyString());
        }
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateCreated() throws IOException {
        String url = ConfigReader.get("Created");
        String body = "";

        Response response = BaseApi.sendPost(url,body);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertEquals(response.getStatusCode(),404);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateNoContent() throws IOException {
        String url = ConfigReader.get("No_content");
        Response response = BaseApi.sendGet(url);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertTrue(response.getStatusCode() == 204 || response.getStatusCode() == 200);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateUnauthorized() throws IOException {
        String url = ConfigReader.get("Unauthorized");
        Response response = BaseApi.sendGet(url);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateForbidden() throws IOException {
        String url = ConfigReader.get("Forbidden");
        Response response = BaseApi.sendGet(url);

        test.get().info("Request URL:" + url);
        test.get().info("Response Body");
        logResponse(response);

        Assert.assertEquals(response.getStatusCode(),403);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateNotFound() throws IOException {
        String url = ConfigReader.get("Not_found");
        Response response = BaseApi.sendGet(url);

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
