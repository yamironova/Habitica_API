package helper;
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
    private String[] notifications;
    private Integer userV;
    private String appVersion;

    public static Tag getTag(JSONToOneTag jSONToOneTag) {
        return jSONToOneTag.getData();
    }

}
