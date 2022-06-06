package Temp;

import api.ValidRequests;
import com.fasterxml.jackson.annotation.JsonFormat;
import helper.MyDate;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import models.Tag;
import models.Task;
import org.junit.jupiter.api.Test;
import requests.tags.GetTags;
import requests.tasks.DeleteTask;
import requests.tasks.GetTasks;
import requests.tasks.PostTask;

import java.text.ParseException;
import java.util.*;

import static config.EnvConfig.PATH_TASK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetAllTasksTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete task")
    public void GetAllTest () throws ParseException {


        //get all tasks
        //ArrayList<Task> taskArrayNew = GetTasks.getAll();
        //System.out.println(n);
        //System.out.println(taskArrayNew.get(n-1).getId());

        //get my task
        String taskId = "31692448-8c4c-4283-b54d-dfb532aac155";
        Task checkTask = GetTasks.getOne(taskId);
        Date s = checkTask.getNextDue()[0];
        System.out.println(s);
        //System.out.println(MyDate.changeNextDueToDate(s));

        //get all tags
        //Task[] taskArrayNew = GetTasks.getAll();
        //System.out.println(taskArrayNew.length);

/*        ValidatableResponse response = ValidRequests.get(PATH_TASK + "/" + taskId)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("one-task-response.json"))
                //           .body("data.id", equalTo(4))     // possible quick check
                .body("data.id", notNullValue());
        JsonPath jsonPath = response.extract().body().jsonPath();
        //Map<String, String> data = jsonPath.getMap("data");
        List<Date> data = jsonPath.getList("data.nextDue");
        System.out.println(data.get(0));*/



    }
}
