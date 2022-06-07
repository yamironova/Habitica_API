package TaskTest;

import helper.TaskToJSON;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.RewardTask;
import models.Task;
import models.ToDoTask;
import org.junit.jupiter.api.Test;
import requests.tasks.DeleteTask;
import requests.tasks.GetTasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiffTypeTasksTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete To Do task")
    public void toDoTaskTest() {

        //create task
        Task myTask = new ToDoTask("ToDoJavaTask" );
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
        assertEquals(myTask.getText(), checkTask.getText());
        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());

        //check
        taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);

        assertTrue(deletingSuccess);


    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete Reward task")
    public void rewardTaskTest() {

        //create task
        RewardTask myTask = new RewardTask("JavaReward",10 );
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
        assertEquals(myTask.getText(), checkTask.getText());
        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());

        //check
        taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);

        assertTrue(deletingSuccess);


    }
}
