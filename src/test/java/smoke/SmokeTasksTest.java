package smoke;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Task;
import org.junit.jupiter.api.Test;
//import requests.tasks.DeleteTask;
//import requests.tasks.GetTask;
import requests.tasks.DeleteTask;
import requests.tasks.PostTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTasksTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete")
    public void smokeTest () {

        //create task
        Task myTask = new Task("TEXT", "todo" );
        // post Task
        Task responseTask = PostTask.postOne(myTask);
        myTask.setId(responseTask.getId());
        System.out.println(myTask.getId());
        //get all tags
        //Tag[] tagArrayNew = GetTags.getAll();
        //System.out.println(tagArrayNew.length);
        //get my tag
        //Tag checkTag = GetTags.getOne(myTag.getId());

        //assertEquals(myTag, checkTag);
        // delete task
       Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());

        //check
        //tagArrayNew = GetTags.getAll();
        //System.out.println(tagArrayNew.length);

        //assertTrue(deletingSuccess);


    }
}
