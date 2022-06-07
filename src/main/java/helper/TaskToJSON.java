package helper;

import models.Task;
import models.ToDoTask;
import org.json.JSONObject;
import requests.tasks.PostTask;

public class TaskToJSON {



    public static Task postOne(Task task) {

        JSONObject issueData = new JSONObject();
        issueData.put("text", task.getText());
        issueData.put("type", task.getType());

        return PostTask.postTaskRequest(issueData);
    }

    public static String generateJSONForTask(ToDoTask task) {

        JSONObject issueData = new JSONObject();

        issueData.put("text", task.getText());
        issueData.put("type", task.getType());

        return issueData.toString();
    }

}
