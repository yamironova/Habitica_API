package models;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import static config.EnvConfig.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

public class Tag implements Comparable<Tag> {
    private String id;
    private String name;

    // compare Tag object for array sorting
    @Override
    public int compareTo(Tag other) {

        return this.
                id.
                compareTo(other.id);
    }

}
