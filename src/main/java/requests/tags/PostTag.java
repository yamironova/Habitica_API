package requests.tags;

import api.ValidRequests;
import helper.JSONToOneTag;
import helper.TagToJSON;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Tag;

import static config.EnvConfig.PATH_TAG;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostTag {

    // valid post one tag
    public static Tag postOne(Tag tag) {

        String requestBody = TagToJSON.generateJSONForTag(tag);

        ValidatableResponse response = ValidRequests.post(PATH_TAG, requestBody)
                .statusCode(201)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("one-tag-response.json"));

        return JSONToOneTag.getTag(response
                .extract()
                .body()
                .as(JSONToOneTag.class));
    }

    // invalid post request
    public static String postWrongRequest(String requestBody) {

        ValidatableResponse response = ValidRequests.post(PATH_TAG, requestBody)
                .statusCode(400)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("wrong-request-format.json"));

        return response.
                extract().
                jsonPath().
                getString("errors[0].message");

    }
}
