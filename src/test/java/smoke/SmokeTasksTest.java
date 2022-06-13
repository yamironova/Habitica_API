package smoke;

import helper.TaskToJSON;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Task;
import models.ToDoTask;
import org.junit.jupiter.api.Test;
import requests.tags.GetTags;
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

        //get my task
        Task checkTask = GetTasks.getOne(myTask.getId());
        System.out.println("created task \"" + checkTask.getText() + "\" with id " + checkTask.getId());

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
        assertTrue(deletingSuccess);

        //check left tag list
        taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);

        //check task were deleted
        Boolean result = GetTasks.getOneAbsent(myTask.getId());
        assertTrue(!result);


    }
}
