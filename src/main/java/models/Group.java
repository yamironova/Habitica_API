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

public class Group implements Comparable<Group> {

    private String id;
    @NonNull private String name;
    @NonNull private String type;
    private String privacy;
    private Approval approval;
    private String[] assignedUsers;
    private String sharedCompletion;



    // compare Tag object for array sorting
    @Override
    public int compareTo(Group other) {

        return this.
                id.
                compareTo(other.id);
    }


    public static Group defaultTask() {

        return new Group("New Group", "guild");
    }

}
