package helper;

import models.Task;
import org.json.JSONObject;

public class TaskToJSON {

    public static String generateJSONForTask(Task task) {

        JSONObject issueData = new JSONObject();

        issueData.put("text", task.getText());
        issueData.put("type", task.getType());

        return issueData.toString();
    }
}
