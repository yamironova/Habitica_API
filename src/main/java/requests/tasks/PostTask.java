package requests.tasks;

import api.ValidRequests;
import helper.JSONToOneTask;
import helper.TaskToJSON;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Tag;
import models.Task;
import org.json.JSONObject;

import static config.EnvConfig.PATH_TASK;
import static config.EnvConfig.PATH_TASKS;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostTask {


    public static Task postTaskRequest(JSONObject issueData) {
        ValidatableResponse response = ValidRequests.post(PATH_TASKS, issueData.toString())
                .statusCode(201)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("one-task-response.json"))
                ;

        return JSONToOneTask.getTask(response
                .extract()
                .body()
                .as(JSONToOneTask.class));
    };

    public static Task postTagToOne(String taskId, String tagId) {

        String requestBody = "";

        ValidatableResponse response =
                ValidRequests.post(PATH_TASK + "/" + taskId + "/tags/" + tagId, requestBody)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("one-task-response.json"))
                ;

        return JSONToOneTask.getTask(response
                .extract()
                .body()
                .as(JSONToOneTask.class));
    }

}
