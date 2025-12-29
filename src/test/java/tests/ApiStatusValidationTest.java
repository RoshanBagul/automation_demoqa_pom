package tests;

import api.BaseApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ConfigReader;

import java.io.IOException;

public class ApiStatusValidationTest {

    @Test (groups = {"api", "ElementPage"})
    public void validateCreated() throws IOException {
        String url = ConfigReader.get("Created");
        String body = "";

        Response response = BaseApi.sendPost(url,body);
        Assert.assertEquals(response.getStatusCode(),404);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateNoContent() throws IOException {
        String url = ConfigReader.get("No_content");
        Response response = BaseApi.sendGet(url);

        Assert.assertTrue(response.getStatusCode() == 204 || response.getStatusCode() == 200);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateUnauthorized() throws IOException {
        String url = ConfigReader.get("Unauthorized");
        Response response = BaseApi.sendGet(url);

        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateForbidden() throws IOException {
        String url = ConfigReader.get("Forbidden");
        Response response = BaseApi.sendGet(url);

        Assert.assertEquals(response.getStatusCode(),403);
    }

    @Test (groups = {"api", "ElementPage"})
    public void validateNotFound() throws IOException {
        String url = ConfigReader.get("Not_found");
        Response response = BaseApi.sendGet(url);

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
