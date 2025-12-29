package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v135.fetch.model.AuthChallengeResponse;

public class BaseApi {

    public static Response sendGet(String url) {
        return RestAssured
                .given()
                .relaxedHTTPSValidation()
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    public static Response sendPost(String url, String body){
        return RestAssured
                .given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .extract().response();
    }
}
