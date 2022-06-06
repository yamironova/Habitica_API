package helper;
import lombok.*;
import models.Tag;
import models.Task;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JSONAllTasksToArray {

    private Boolean success;
    private Task[] data;
    private String[] notifications;
    private Integer userV;
    private String appVersion;

    public static Task[] getTaskArray(JSONAllTasksToArray jSONAllTasksToArray) {
        return jSONAllTasksToArray.getData();
    }
}
