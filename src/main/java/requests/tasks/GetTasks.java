package requests.tasks;

import api.ValidRequests;
import helper.JSONAllTasksToArray;
import helper.JSONToOneTask;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Task;

import java.util.ArrayList;

import static config.EnvConfig.PATH_TASKS;
import static config.EnvConfig.PATH_TASK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetTasks {

    // get all tasks
    public static ArrayList<Task> getAll() {

        ValidatableResponse response = ValidRequests.get(PATH_TASKS)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("all-tasks-response.json"));

        return  JSONAllTasksToArray.getTaskIdNameTypeArray(response
                .extract()
                .body().jsonPath());


    }

    // get one task
    public static Task getOne(String taskId) {

        ValidatableResponse response = ValidRequests.get(PATH_TASK + "/" + taskId)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("one-task-response.json"));

        return  JSONToOneTask.getTask(response
                .extract()
                .body()
                .as(JSONToOneTask.class));


    }

    // get one absent task
    public static Boolean getOneAbsent(String taskId) {

        ValidatableResponse response = ValidRequests.get(PATH_TASK + "/" + taskId)
                .statusCode(404)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("not-found.json"));

        return  response
                .extract()
                .body()
                .path("success");


    }
}
