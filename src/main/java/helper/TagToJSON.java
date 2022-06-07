package helper;

import models.Tag;
import models.Task;
import org.json.JSONObject;
import requests.tasks.PostTask;

public class TagToJSON {

    public static String generateJSONForTag(Tag tag) {

        JSONObject issueData = new JSONObject();

        issueData.put("name", tag.getName());

        return issueData.toString();
    }

}
