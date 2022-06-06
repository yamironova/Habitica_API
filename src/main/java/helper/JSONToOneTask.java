package helper;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import models.Task;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JSONToOneTask {

    private Boolean success;
    private Task data;
    private JsonNode[] notifications;
    private Integer userV;
    private String appVersion;

    public static Task getTask(JSONToOneTask jSONToOneTask) {
        return jSONToOneTask.getData();
    }

    public static Boolean getSuccess(JSONToOneTask jSONToOneTask) {
        return jSONToOneTask.success;
    }


}
