package smoke;

import helper.TaskToJSON;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Task;
import models.ToDoTask;
import org.junit.jupiter.api.Test;
import requests.tasks.DeleteTask;
import requests.tasks.GetTasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTasksTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("'post-get all - get one - delete task")
    public void smokeTaskTest() {

        //create task
        Task myTask = Task.defaultTask();
        // post Task
        Task responseTask = TaskToJSON.postOne(myTask);
        myTask.setId(responseTask.getId());
        System.out.println(myTask.getId());

        //get my task
        Task checkTask = GetTasks.getOne(myTask.getId());

        //get all tasks
        Task[] taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);
        System.out.println(taskArrayNew[taskArrayNew.length-1].getId());
        //            ***For short version***
        //ArrayList<Task> taskArrayNew = GetTasks.getAll();
        //int n = taskArrayNew.size();
        //System.out.println(n);
        //System.out.println(taskArrayNew.get(n-1).getId());


        assertEquals(myTask.getText(), checkTask.getText());
        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());

        //check
        taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);

        assertTrue(deletingSuccess);


    }
}
