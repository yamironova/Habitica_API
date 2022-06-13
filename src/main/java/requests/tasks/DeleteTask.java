package requests.tasks;

import api.ValidRequests;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static config.EnvConfig.PATH_TAG;
import static config.EnvConfig.PATH_TASK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class DeleteTask {

    // simple valid deleting one task
    public static Boolean deleteTask(String taskId) {

        ValidatableResponse response = ValidRequests.delete(PATH_TASK + "/" + taskId)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("delete-task.json"));

        return  response.
                extract().
                body().path("success");
    }

    // delete one absent task
    public static Boolean deleteOneAbsent(String taskId) {

        ValidatableResponse response = ValidRequests.delete(PATH_TASK + "/" + taskId)
                .statusCode(404)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("not-found.json"));

        return response
                .extract()
                .body()
                .path("success");
    }
}

