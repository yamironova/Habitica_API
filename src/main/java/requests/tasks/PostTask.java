package requests.tasks;

import api.ValidRequests;
import helper.JSONToOneTask;
import helper.TaskToJSON;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Task;

import static config.EnvConfig.PATH_TASK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostTask {

    public static Task postOne(Task task) {

        String requestBody = TaskToJSON.generateJSONForTask(task);

        ValidatableResponse response = ValidRequests.post(PATH_TASK, requestBody)
                .statusCode(201)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("one-task-response.json"))
                ;

        return JSONToOneTask.getTask(response.
                extract().
                body().
                as(JSONToOneTask.class));
    }
}
