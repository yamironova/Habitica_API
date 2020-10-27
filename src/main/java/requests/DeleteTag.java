package requests;

import api.ValidRequests;
import io.restassured.response.ValidatableResponse;

public class DeleteTag {

    // simple valid deleting one tag
    public static ValidatableResponse deleteTag(String tagId) {

        ValidatableResponse response = ValidRequests.delete("/api/v3/tags/" + tagId).
                statusCode(200);
        return response;
    }
}

