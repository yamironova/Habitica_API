package models;
import lombok.*;

import static config.EnvConfig.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Tag {
    private String id;
    private String name;

}
