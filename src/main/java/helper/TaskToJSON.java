package helper;

import models.*;
import org.json.JSONObject;
import requests.tasks.PostTask;

public class TaskToJSON {



    public static Task postOne(Task task) {

        JSONObject issueData = new JSONObject();
        issueData.put("text", task.getText());
        issueData.put("type", task.getType());

        return PostTask.postTaskRequest(issueData);
    }

    public static Task postOne(ToDoTask task) {

        JSONObject issueData = new JSONObject();

        issueData.put("text", task.getText());
        issueData.put("type", task.getType());

        return PostTask.postTaskRequest(issueData);
    }

    public static Task postOne(RewardTask task) {

        JSONObject issueData = new JSONObject();

        issueData.put("text", task.getText());
        issueData.put("type", task.getType());
        issueData.put("value", task.getValue());

        return PostTask.postTaskRequest(issueData);
    }

    public static Task postOne(HabitTask task) {

        JSONObject issueData = new JSONObject();

        issueData.put("text", task.getText());
        issueData.put("type", task.getType());
        issueData.put("up", task.getUp());
        issueData.put("down", task.getDown());

        return PostTask.postTaskRequest(issueData);
    }

    public static Task postOne(DailyTask task) {

        JSONObject issueData = new JSONObject();

        issueData.put("text", task.getText());
        issueData.put("type", task.getType());

        return PostTask.postTaskRequest(issueData);
    }

}
