package models;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;
import java.util.Date;


@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

public class ToDoTask extends Task {
    private Date date ;

    @Builder
    public ToDoTask(String taskName) {
      super(taskName, "todo");
    }


    public static ToDoTask randomToDoTask() {

        return new ToDoTask(RandomStringUtils.random(10, true, false));
    }

    public static ToDoTask defaultToDoTask() {

        return new ToDoTask("ToDoTask_name");
    }

}
