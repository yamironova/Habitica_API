package smoke;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Challenge;
import models.Task;
import org.junit.jupiter.api.Test;
import requests.tasks.DeleteTask;
import requests.tasks.GetTasks;
import requests.tasks.PostTask;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTasksTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete task")
    public void smokeTaskTest() {

        //create task
        Task myTask = new Task("Id","TEXT", "todo" );
        // post Task
        Task responseTask = PostTask.postOne(myTask);
        myTask.setId(responseTask.getId());
        System.out.println(myTask.getId());

        //get my task
        Task checkTask = GetTasks.getOne(myTask.getId());

        //get all tasks
        //ArrayList<Task> taskArrayNew = GetTasks.getAll();
        //int n = taskArrayNew.size();
        //System.out.println(n);
        //System.out.println(taskArrayNew.get(n-1).getId());


        assertEquals(myTask.getText(), checkTask.getText());
        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());

        //check
        //taskArrayNew = GetTasks.getAll();
        //System.out.println(taskArrayNew.size());

        assertTrue(deletingSuccess);


    }
}
