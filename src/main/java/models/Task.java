package models;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

public class Task implements Comparable<Task> {
    private String id;
    @NonNull private String text;
    @NonNull private String type;
    private String[] tags;
    private String alias;
    private checklist[]  String;
    private Boolean collapseChecklist;
    private String notes;
    private Number priority;
    private String[] reminders;

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
