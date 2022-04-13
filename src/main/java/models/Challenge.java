package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Log4j2
@SuperBuilder

public class Challenge implements Comparable<Challenge> {
    @NonNull private String id;
    @NonNull private String name;
    private String group;
    private String shortName;
    private String summary;
    private String description;


    // compare Tag object for array sorting
    @Override
    public int compareTo(Challenge other) {

        return this.
                id.
                compareTo(other.id);
    }


    public static Challenge defaultTask() {

        return new Challenge("text", "New Chall");
    }

}
