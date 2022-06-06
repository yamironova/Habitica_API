package requests.tasks;

import api.ValidRequests;
import helper.JSONAllTagsToArray;
import helper.JSONAllTasksToArray;
import helper.JSONAllTasksToArrayShort;
import helper.JSONToOneTask;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Task;

import java.util.ArrayList;

import static org.hamcrest.Matchers.notNullValue;

import static config.EnvConfig.PATH_TASKS;
import static config.EnvConfig.PATH_TASK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetTasks {

    // get all tasks

    public static Task[] getAll() {
    //public static ArrayList<Task> getAll() {

        ValidatableResponse response = ValidRequests.get(PATH_TASKS)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("all-tasks-response.json"));

        //return  JSONAllTasksToArrayShort.getTaskIdNameTypeArray(response
        //        .extract()
        //        .body().jsonPath());

        return  JSONAllTasksToArray.getTaskArray(response
                .extract()
                .body()
                .as(JSONAllTasksToArray.class));


    }

    // get one task
    public static Task getOne(String taskId) {

        ValidatableResponse response = ValidRequests.get(PATH_TASK + "/" + taskId)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("one-task-response.json"))
     //           .body("data.id", equalTo(4))     // possible quick check
                .body("data.id", notNullValue())
                ;

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
