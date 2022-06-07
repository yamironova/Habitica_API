package smoke;

import helper.TaskToJSON;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Tag;
import models.Task;
import org.junit.jupiter.api.Test;
import requests.tags.GetTags;
import requests.tasks.DeleteTask;
import requests.tasks.GetTasks;
import requests.tasks.PostTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTaskWithTagTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete")
    public void smokeTest () {

        //create task
        Task myTask = new Task("Id","task for tag", "todo" );
        // post Task
        Task responseTask = TaskToJSON.postOne(myTask);
        myTask.setId(responseTask.getId());
        System.out.println(myTask.getId());

        //get all tags
        Tag[] tagArrayNew = GetTags.getAll();

        // add tag to reference task
        String tagName = tagArrayNew[0].getName();
        System.out.println(tagName);
        Tag myTag = new Tag(tagArrayNew[0].getId(), tagArrayNew[0].getName() );
        Tag[] myTagsArray = new Tag[1];
        myTagsArray[0] = myTag;
        myTask.setTags(myTagsArray);

        //add tag to system task
        responseTask = PostTask.postTagToOne(myTask.getId(), myTag.getId());
        System.out.println(responseTask);

        //get my task and tags
        Task checkTask = GetTasks.getOne(myTask.getId());

        //check
        assertEquals(myTask.getTags()[0].getId(), checkTask.getTags()[0].getId());
        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());

        assertTrue(deletingSuccess);


    }
}
