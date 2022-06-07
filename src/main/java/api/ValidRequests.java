package api;

import config.EnvConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static config.EnvConfig.URL_BASE;
import static config.EnvConfig.X_CLIENT;
import static io.restassured.RestAssured.given;

@Log4j2
public class ValidRequests {

    // private static final Logger logger = LogManager.getLogger(ValidRequests.class.getName());

    // set base url and token
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(URL_BASE)
            .addHeader("X-Client", X_CLIENT)
            .addHeader("x-api-user", EnvConfig.getUser_Id())
            .addHeader("x-api-key", EnvConfig.getAPI_key())
            .build();

    // simple valid get request
    public static ValidatableResponse get(String urlPath) {

        Response response = given()    // response
                .spec(requestSpec)
                .when()
                .get(urlPath)
                ;

        // lets check cookies and session ID
        //System.out.println(response.getCookies());   // show Cookies
        String getSessionIdFromCookie = response.getCookies().get("connect:sess.sig") ;
        String getSessionFromCookie = response.getCookies().get("connect:sess") ;
        //System.out.println(getSessionFromCookie + "  " + getSessionIdFromCookie);   // show Cookies

        // how we can use this session ID
        //Response responseNew = given()
        //        .cookies("connect:sess.sig", getSessionIdFromCookie, "connect:sess", getSessionFromCookie)
        //        .when()
        //        .get(urlPath);


        log.info( "GET request to " + urlPath +
                " has code response " + response.then().extract().statusCode() +
                " and response body " + response.then().extract().body().asString());
        return response.then() ;   // response.then() - ValidatableResponse

    }
    // simple valid post request
    public static ValidatableResponse post(String urlPath, String requestBody) {

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
    public static ValidatableResponse delete(String urlPath) {

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
