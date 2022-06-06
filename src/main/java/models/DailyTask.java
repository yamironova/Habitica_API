package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@SuperBuilder

public class DailyTask extends Task {
    private String frequency;
    private DayOfWeekMark repeat;
    private Number everyX;
    private Number streak;
    //@JsonFormat(pattern = "EEE MMM dd yyyy HH:mm:ss ZZZZ")
 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE MMM dd yyyy HH:mm:ss ZZZZ")
    private String[] nextDue;
    //private JsonNode[] nextDue;
    private Boolean yesterDaily;
    private Number[] daysOfMonth;
    private Number[] weeksOfMonth;
    private Date startDate;


    public DailyTask(String taskName) {
      super("iD",taskName, "daily"); }


    public static DailyTask randomDailyTask() {

        return new DailyTask(RandomStringUtils.random(10, true, false));
    }

    public static DailyTask defaultDailyTask() {

        return new DailyTask("DailyTask_name");
    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Log4j2
    @SuperBuilder

    public static class DayOfWeekMark {
        private Boolean m;
        private Boolean t;
        private Boolean w;
        private Boolean th;
        private Boolean f;
        private Boolean s;
        private Boolean su;
    }

}
