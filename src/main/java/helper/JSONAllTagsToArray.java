package helper;
import lombok.*;
import models.Tag;

import static config.EnvConfig.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JSONAllTagsToArray {

    private Boolean success;
    private Tag[] data;
    private String[] notifications;
    private Integer userV;
    private String appVersion;

    public static Tag[] getTagArray(JSONAllTagsToArray jSONAllTagsToArray) {
        return jSONAllTagsToArray.getData();
    }
}
