package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

import java.sql.Timestamp;


@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Log4j2
@SuperBuilder

public class Task implements Comparable<Task> {
    private String id;
    @NonNull private String text;
    @NonNull private String type;
    private Tag[] tags;
    private String alias;
    private Checklist[] checklist;
    private Boolean collapseChecklist;
    private String notes;
    private Number priority;
    private String[] reminders;
    // for responce
    private Challenge challenge;
    private Group group;
    private Boolean completed;
    private Number value;
    private String attribute;
    private Boolean byHabitica;
    private String _id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String userId;


    // compare Tag object for array sorting
    @Override
    public int compareTo(Task other) {

        return this.
                id.
                compareTo(other.id);
    }


    public static Task defaultTask() {

        return new Task("text", "todo");
    }

}
