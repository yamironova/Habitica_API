package helper;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import models.Tag;

import static config.EnvConfig.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JSONToOneTag {

    private Boolean success;
    private Tag data;
    private JsonNode[] notifications;
    private Integer userV;
    private String appVersion;

    public static Tag getTag(JSONToOneTag jSONToOneTag) {
        return jSONToOneTag.getData();
    }

    public static Boolean getSuccess(JSONToOneTag jSONToOneTag) {
        return jSONToOneTag.success;
    }


}
