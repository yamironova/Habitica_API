package api;

import static config.EnvConfig.*;
import static io.restassured.RestAssured.given;
import static lombok.extern.flogger.Flogger.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import lombok.extern.flogger.Flogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.Tag;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidRequests {

    // private static final Logger logger = LogManager.getLogger(ValidRequests.class.getName());

    // set base url and token
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(URL_BASE)
            .addHeader("X-Client", X_CLIENT)
            .addHeader("x-api-user", USER_ID)
            .addHeader("x-api-key", API_KEY)
            .build();

    // simple valid get request
    public static ValidatableResponse get(String urlPath) {

        ValidatableResponse response = given().
                spec(requestSpec).
                when().
                get(urlPath).
                then();

        log.info( "GET request to " + urlPath +
                " has code response " + response.extract().statusCode() +
                " and response body " + response.extract().body().asString());
        return response;

    }
    // simple valid post request
    public static ValidatableResponse post(String urlPath, String requestBody) {

        ValidatableResponse response = given().spec(requestSpec).
                header("Content-Type", ContentType.JSON).
                body(requestBody).
                when().
                post(urlPath).
                then();

        log.info( "POST request with body " + requestBody +
                " has code response " + response.extract().statusCode() +
                " and response body " + response.extract().body().asString());

        return response;
    }

    // simple valid delete request
    public static ValidatableResponse delete(String urlPath) {

        ValidatableResponse response = given().
                spec(requestSpec).
                when().
                delete(urlPath).
                then();

        log.info( "DELETE request to " + urlPath +
                " has code response " + response.extract().statusCode() +
                " has code response " + response.extract().body().asString());


        return response;
    }
}
