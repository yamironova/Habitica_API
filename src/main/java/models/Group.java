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
    private String name;
    private String type;
    private String privacy;
    @NonNull private Approval approval;
    private String[] assignedUsers;
    private String sharedCompletion;



    // compare Tag object for array sorting
    @Override
    public int compareTo(Group other) {

        return this.
                id.
                compareTo(other.id);
    }


    public static Group defaultGroup() {

        return new Group(Approval.defaultApproval());
    }

    @Data
    @ToString
    @AllArgsConstructor
    @RequiredArgsConstructor
    @NoArgsConstructor
    @Log4j2
    @SuperBuilder

    public static class Approval {
        @NonNull private Boolean required;
        @NonNull private Boolean approved;
                 private Boolean requested;

        public static Approval defaultApproval() {

            return new Approval(false,false,false);
        }
    }
}
