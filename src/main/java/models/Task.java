package models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Log4j2
@SuperBuilder

public class Task implements Comparable<Task> {
    @NonNull private String id;
    @NonNull private String text;
    @NonNull private String type;
    private Tag[] tags;
    private String alias;
    private Checklist[] checklist;
    private Boolean collapseChecklist;
    private String notes;
    private Number priority;
    private String[] reminders;
    private Boolean isDue;
    // for response
    private Challenge challenge;
    private Group group;
    private Boolean completed;
    private String attribute;
    private Boolean byHabitica;
    private String _id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String userId;
    // from Todo task
    private Date date;
    // from Daily task
    private String frequency;
    private DailyTask.DayOfWeekMark repeat;
    private Number everyX;
    private Number streak;
    //private JsonNode[] nextDue;
    private Boolean yesterDaily;
 //   @JsonProperty("history")
  //  private DailyTask.HistoryMark[] history1;
    private Number[] daysOfMonth;
    private Number[] weeksOfMonth;
    private Date startDate;
    // from Habit task
    private Boolean up;
    private Boolean down;
    private Integer counterUp;
    private Integer counterDown;
    @JsonProperty("history")
    private HistoryItem[] history;
    // from Reward task
    private Number value;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE MMM dd yyyy HH:mm:ss 'GMT'ZZZ", locale = "en_GB", timezone = "Moscow")
    private String[] nextDue;



    // compare Tag object for array sorting
    @Override
    public int compareTo(Task other) {

        return this.
                id.
                compareTo(other.id);
    }


    public static Task defaultTask() {

        return new Task("id","text", "todo");
    }


}
