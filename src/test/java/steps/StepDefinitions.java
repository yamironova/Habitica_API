package steps;

import api.ValidRequests;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import models.Tag;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requests.DeleteTag;
import requests.GetTags;
import requests.PostTag;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static requests.GetTags.getOneAbsent;

public class StepDefinitions {

    private static final Logger logger = LogManager.getLogger(ValidRequests.class.getName());
    File consoleLog = new File("log", "myApp.log");
    String startMessage, finishMessage;
    String logTest;
    Boolean fromTest = false;
    Tag responseTag, myTag;

    @Before
    public void beforeTestExecution(Scenario scenario) {
        startMessage = "'" + scenario.getName() + "'" +  " start";
        logger.info(startMessage);

    }

    @After
    public void afterTestExecution(Scenario scenario) throws IOException {
        finishMessage = "'" + scenario.getName() + "'" + " finish ";
        logger.info(finishMessage);
        logTest = "<html> <body> ";
        FileUtils.readLines(consoleLog, StandardCharsets.UTF_8).forEach(s -> {
            if (s.contains(startMessage)) { fromTest = true; }
            if (s.contains(finishMessage)) { fromTest = false; }
            if (fromTest) {logTest = logTest + s + "  <br />";}
        });
        logTest = logTest + finishMessage + "  </body> </html>";
        attachment(logTest);

    }

    @Attachment(value = "Test log.html", type = "text/html")
    public String attachment(String logTest) {
        return logTest;
    }


    @Given("User has some tags")
    public void userHasSomeTags() {
        Tag[] tagArrayNew = GetTags.getAll();
        System.out.println(tagArrayNew.length);
    }

    @Given("I have account at site")
    public void iHaveAccountAtSite() {
    }

    @When("I create a new tag with {string}")
    public void iCreateANewTagWith(String tagName) {
        System.out.println(tagName);
        //create tag
        myTag = new Tag("TEXT", tagName );
        responseTag = PostTag.postOne(myTag);
        myTag.setId(responseTag.getId());

    }

    @Then("I have created tag successfully")
    public void iHaveCreatedTagSuccessfully() {
        Tag checkTag = GetTags.getOne(responseTag.getId());
        assertEquals(myTag, checkTag);
    }

    @And("I (see|not see) tag with this id$")
    public void iKnowThisTagId(String present) {
        if (present.equals("see")) {
            Tag checkTag = GetTags.getOne(responseTag.getId());
        }
        else {}

    }

    @And("I delete tag with this id")
    public void iDeleteTagWithThisId() {
        Boolean deletingSuccess = DeleteTag.deleteTag(myTag.getId());
        assertTrue(deletingSuccess);

    }

    @Then("I have deleted tag successfully")
    public void iHaveDeletedTagSuccessfully() {
    }

    @And("I try to see tag with some {string}")
    public void iTryToDeleteTagWithSomeWrongId(String id) {
        Boolean viewSuccess = getOneAbsent(id);
        assertFalse(viewSuccess);
    }

}
