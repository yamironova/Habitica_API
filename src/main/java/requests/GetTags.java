package requests;

import api.ValidRequests;
import helper.JSONAllTagsToArray;
import helper.JSONToOneTag;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Tag;

import static config.EnvConfig.PATH_TAG;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetTags {

    // get all tags
    public static Tag[] getAll() {

        ValidatableResponse response = ValidRequests.get(PATH_TAG).
                statusCode(200).
                contentType(ContentType.JSON).
                assertThat().
                body(matchesJsonSchemaInClasspath("all-tags-response.json"));

        return  JSONAllTagsToArray.getTagArray(response.
                extract().
                body().as(JSONAllTagsToArray.class));


    }

    // get one tag
    public static Tag getOne(String tagId) {

        ValidatableResponse response = ValidRequests.get(PATH_TAG + "/" + tagId).
                statusCode(200).
                contentType(ContentType.JSON).
                assertThat().
                body(matchesJsonSchemaInClasspath("one-tag-response.json"));

        return  JSONToOneTag.getTag(response.
                extract().
                body().
                as(JSONToOneTag.class));


    }
}
