package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Log4j2

public class Tag implements Comparable<Tag> {
     @NonNull private String id;
     private String name;

    // compare Tag object for array sorting
    @Override
    public int compareTo(Tag other) {

        return this.
                id.
                compareTo(other.id);
    }

    public static Tag randomTag() {

        return new Tag("id", RandomStringUtils.random(10, true, false));
    }

    public static Tag defaultTag() {

        return new Tag("id", "tag_name");
    }

}
