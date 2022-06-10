package api;

import config.EnvConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static config.EnvConfig.*;
import static io.restassured.RestAssured.given;

@Log4j2
public class NonValidRequests {


    // set valid base url and token
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(URL_BASE)
            .addHeader("X-Client", X_CLIENT)
            .addHeader("x-api-user", EnvConfig.getUser_Id())
            .addHeader("x-api-key", EnvConfig.getAPI_key())
            .build();

    // set invalid base url and token
    private static final RequestSpecification invalidRequestSpec = new RequestSpecBuilder()
            .setBaseUri(URL_BASE)
            .addHeader("X-Client", X_CLIENT)
            .addHeader("x-api-user", EnvConfig.getUser_Id())
            .addHeader("x-api-key", WRONG_API_KEY)
            .build();

    // simple valid get request
    public static ValidatableResponse wrongAPIKeyGet(String urlPath) {

        ValidatableResponse response = given()    // response
                .spec(invalidRequestSpec)
                .when()
                .get(urlPath)
                .then()
                ;

        log.info( "GET request to " + urlPath +
                " has code response " + response.extract().statusCode() +
                " and response body " + response.extract().body().asString());
        return response ;
        // response - ValidatableResponse, without .then() - Response

    }
    // simple valid post request
    public static ValidatableResponse wrongRequestPost(String urlPath, String requestBody) {

        ValidatableResponse response = given().spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(urlPath)
                .then();

        log.info( "POST request with body " + requestBody +
                " has code response " + response.extract().statusCode() +
                " and response body " + response.extract().body().asString());

        return response;
    }

    // simple valid delete request
    public static ValidatableResponse wrongIDdelete(String urlPath) {

        ValidatableResponse response = given()
                .spec(requestSpec)
                .when()
                .delete(urlPath)
                .then();

        log.info( "DELETE request to " + urlPath +
                " has code response " + response.extract().statusCode() +
                " has code response " + response.extract().body().asString());

        return response;
    }
}
