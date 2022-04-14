package helper;
import io.restassured.response.ResponseBodyExtractionOptions;
import lombok.*;
import models.Tag;
import models.Task;
import api.ValidRequests;
import helper.JSONAllTasksToArray;
import helper.JSONToOneTask;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Task;

import java.util.ArrayList;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JSONAllTasksToArray {

   // private Boolean success;
 private ArrayList<Task> data;
   // private String[] notifications;
   // private Integer userV;
   // private String appVersion;

    public static ArrayList<Task> getTaskIdNameTypeArray(ResponseBodyExtractionOptions responseBody) {
        ArrayList<Task> tasks = new ArrayList<Task>();
       // tasks.stream().map(x -> addName(x)).forEach(x -> System.out.println(x.getName()));
      //  responseBody.jsonPath().getString("data[i].id");
        int size = responseBody.jsonPath().getList("data").size();
        for (int i = 0; i< size; i++) {
            tasks.add(addShortTask(responseBody.jsonPath().getString("data[i].id"),
                    responseBody.jsonPath().getString("data[i].text"),
                    responseBody.jsonPath().getString("data[i].type")));
            System.out.println(tasks.get(i).getText());
        }

        return tasks;
    }
    public static Task addShortTask(String id, String text, String type) {
       // possible option
        // Task task = new Task(id,text,type);
      //  task.setId(id);

        return new Task(id,text,type);
    }
}
