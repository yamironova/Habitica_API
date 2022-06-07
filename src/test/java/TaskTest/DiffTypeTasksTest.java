package TaskTest;

import helper.TaskToJSON;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.*;
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
        ToDoTask myTask = ToDoTask.randomToDoTask();
        // post Task
        Task responseTask = TaskToJSON.postOne(myTask);
        myTask.setId(responseTask.getId());

        //get my task
        Task checkTask = GetTasks.getOne(myTask.getId());
        System.out.println("created task \"" + checkTask.getText() + "\" with id " + checkTask.getId());


        //get all tasks
        Task[] taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);
        assertEquals(myTask.getText(), checkTask.getText());

        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());
        assertTrue(deletingSuccess);

        //check
        taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete Reward task")
    public void rewardTaskTest() {

        //create task
        RewardTask myTask = RewardTask.randomRewardTask();
        // post Task
        Task responseTask = TaskToJSON.postOne(myTask);
        myTask.setId(responseTask.getId());

        //get my task
        Task checkTask = GetTasks.getOne(myTask.getId());
        System.out.println("created task \"" + checkTask.getText() + "\" with id " + checkTask.getId() + "and price=" + checkTask.getValue());

        //get all tasks
        Task[] taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);
        assertEquals(myTask.getText(), checkTask.getText());

        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());
        assertTrue(deletingSuccess);

        //check
        taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete To Do task")
    public void habitTaskTest() {

        //create task
        HabitTask myTask = HabitTask.randomHabitTask();
        // post Task
        Task responseTask = TaskToJSON.postOne(myTask);
        myTask.setId(responseTask.getId());

        //get my task
        Task checkTask = GetTasks.getOne(myTask.getId());
        System.out.println("created task \"" + checkTask.getText() + "\" with id " + checkTask.getId());

        //get all tasks
        Task[] taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);
        assertEquals(myTask.getText(), checkTask.getText());

        // delete task
       Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());
       assertTrue(deletingSuccess);

        //check
        taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete Reward task")
    public void dailyTaskTest() {

        //create task
        DailyTask myTask = DailyTask.randomDailyTask();
        // post Task
        Task responseTask = TaskToJSON.postOne(myTask);
        myTask.setId(responseTask.getId());

        //get my task
        Task checkTask = GetTasks.getOne(myTask.getId());
        System.out.println("created task \"" + checkTask.getText() + "\" with id " + checkTask.getId() + "and frequency=" + checkTask.getFrequency());

        //get all tasks
        Task[] taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);
        assertEquals(myTask.getText(), checkTask.getText());

        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());
        assertTrue(deletingSuccess);

        //check
        taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);

    }
}
