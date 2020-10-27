package helper;

import models.Tag;
import org.json.JSONObject;

public class TagToJSON {

    public static String generateJSONForTag(Tag tag) {

        JSONObject issueData = new JSONObject();

        issueData.put("name", tag.getName());

        return issueData.toString();
    }
}
