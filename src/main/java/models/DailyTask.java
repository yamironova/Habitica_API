package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.sl.In;
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
    @NonNull private String frequency;
    private DayOfWeekMark repeat;
    @NonNull private Number everyX;
    private Number streak;
    //@JsonFormat(pattern = "EEE MMM dd yyyy HH:mm:ss ZZZZ")

    //private JsonNode[] nextDue;
    private Boolean yesterDaily;
    private Number[] daysOfMonth;
    private Number[] weeksOfMonth;
    private Timestamp startDate;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE MMM dd yyyy HH:mm:ss 'GMT'ZZZ")
    private String[] nextDue;


    public DailyTask(String taskName, Integer frequency,  Number everyX) {
      super("iD",taskName, "daily");
      this.everyX = everyX;
      this.frequency = getFrequency(frequency);
    }


    public static DailyTask randomDailyTask() {

        return new DailyTask(RandomStringUtils.random(10, true, false), 3,  (int) (Math.random()*6)+1);
    }

    public static DailyTask defaultDailyTask() {

        return new DailyTask("DailyTask_name", 1,1);
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

    public static String getFrequency(Integer i) {
        switch (i) {
            case 2: return "weekly";
            case 3: return "monthly";
            case 4: return "yearly";
            default: return "daily";


        }
    }

}
