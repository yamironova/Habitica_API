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

import static config.EnvConfig.PATH_TAG;
import static config.EnvConfig.WRONG_TOKEN_ERROR;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BadRequestTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("request with invalid API key")
    public void invalidAPITest() {

        //get all tags
        String wrongAPIError =
                NonValidRequests.wrongAPIKeyGet(PATH_TAG)
                        .statusCode(401)
                        .contentType(ContentType.JSON)
                        .assertThat()
                        .body(matchesJsonSchemaInClasspath("no-token-schema.json"))
                        .extract()
                        .jsonPath()
                        .getString("error");

        assertEquals(WRONG_TOKEN_ERROR, wrongAPIError);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post tag with wrong request")
    public void rewardTaskTest() {

        //create tag
        Tag myTag = new Tag("TEXT", "JavaTag" );
        // post Tag
        Tag responseTag = PostTag.postOne(myTag);
        myTag.setId(responseTag.getId());

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("get tag with wrong id")
    public void habitTaskTest() {

        //create tag
        Tag myTag = new Tag("TEXT", "JavaTag" );
        //get tag
        Tag checkTag = GetTags.getOne(myTag.getId());

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("delete tag with wrong id")
    public void dailyTaskTest() {

        //create tag
        Tag myTag = new Tag("TEXT", "JavaTag" );
        // delete tag
        Boolean deletingSuccess = DeleteTag.deleteTag(myTag.getId());
        assertTrue(deletingSuccess);


    }
}
