package requests.tags;

import api.ValidRequests;
import helper.JSONToOneTag;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static config.EnvConfig.PATH_TAG;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class DeleteTag {

    // simple valid deleting one tag
    public static Boolean deleteTag(String tagId) {

        ValidatableResponse response = ValidRequests.delete(PATH_TAG + "/" + tagId).
                statusCode(200).
                contentType(ContentType.JSON).
                assertThat().
                body(matchesJsonSchemaInClasspath("delete-tag.json"));

        return  response.
                extract().
                body().path("success");
    }
}

