package requests.tags;

import api.ValidRequests;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.User;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetAllUserInfoRequest {

        public static User getAll() {


            ValidatableResponse response = ValidRequests.get("/all").
                    statusCode(200).
                    contentType(ContentType.JSON).
                    assertThat().
                    body(matchesJsonSchemaInClasspath("one-triangle-schema.json"));

            return response.
                    extract().
                    body().
                    as(User.class);


        }

}
