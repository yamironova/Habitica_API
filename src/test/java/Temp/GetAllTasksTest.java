package Temp;

import helper.TaskToJSON;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Task;
import models.ToDoTask;
import org.junit.jupiter.api.Test;
import requests.tasks.DeleteTask;
import requests.tasks.GetTasks;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetAllTasksTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete task")
    public void GetAllTest () {


        //create task
        ToDoTask myTask = new ToDoTask("ToDoJava Task");
        // post Task
        Task responseTask = TaskToJSON.postOne(myTask);
        myTask.setId(responseTask.getId());
        String taskId = myTask.getId();
        System.out.println(taskId );
        System.out.println(myTask.getText());


        //get all tasks
        Task[] taskArrayNew = GetTasks.getAll();
        System.out.println(taskArrayNew.length);
        System.out.println(taskArrayNew[taskArrayNew.length-1].getId());

        //get my task
        Task checkTask = GetTasks.getOne(taskId);
        System.out.println(checkTask);

        // delete task
        Boolean deletingSuccess = DeleteTask.deleteTask(myTask.getId());
        assertTrue(deletingSuccess);




        //Date s = checkTask.getNextDue()[0];
       // String s = checkTask.getNextDue()[0];
        //System.out.println(s);
       // System.out.println(MyDate.changeNextDueToDate(s));

        //get all tags
        //Task[] taskArrayNew = GetTasks.getAll();
        //System.out.println(taskArrayNew.length);

/*        ValidatableResponse response = ValidRequests.get(PATH_TASK + "/" + taskId)
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("one-task-response.json"))
                //           .body("data.id", equalTo(4))     // possible quick check
                .body("data.id", notNullValue());
        JsonPath jsonPath = response.extract().body().jsonPath();
        //Map<String, String> data = jsonPath.getMap("data");
        List<Date> data = jsonPath.getList("data.nextDue");
        System.out.println(data.get(0));*/

    }
}
