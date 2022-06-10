package Negative;

import api.NonValidRequests;
import helper.TaskToJSON;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import models.*;
import org.junit.jupiter.api.Test;
import requests.tags.DeleteTag;
import requests.tags.GetTags;
import requests.tags.PostTag;
import requests.tasks.DeleteTask;
import requests.tasks.GetTasks;

import static config.EnvConfig.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BadRequestTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("request with invalid API key")
    public void invalidAPITest() {

        //get all tags with invalid API key
        String wrongAPIError =
                NonValidRequests.wrongAPIKeyGet(PATH_TAG)
                        .statusCode(401)
                        .contentType(ContentType.JSON)
                        .assertThat()
                        .body(matchesJsonSchemaInClasspath("wrong-API-key-response.json"))
                        .extract()
                        .jsonPath()
                        .getString("error");

        assertEquals(WRONG_TOKEN_ERROR, wrongAPIError);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post tag with wrong request")
    public void postWrongTagTest() {

        String requestBody = "";
        // post Tag with empty body
        String messageError = PostTag.postWrongRequest(requestBody);
        assertEquals(EMPTY_REQUEST_TAG_ERROR, messageError);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("get tag with wrong id")
    public void getTagWithWrongIDTest() {

        //get tag with wrong id
        Boolean result = GetTags.getOneAbsent(WRONG_ITEM_ID);
        assertTrue(!result);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("delete tag with wrong id")
    public void deleteTagWithWrongIDTest() {

        // delete tag
        Boolean deletingSuccess = DeleteTag.deleteOneAbsent(WRONG_ITEM_ID);
        assertTrue(!deletingSuccess);

    }
}
