package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Date;


@Data
@ToString
@SuperBuilder
@Log4j2
@AllArgsConstructor
@NoArgsConstructor

public class DailyTask extends Task {
    private String frequency;
    private String repeat;
    private Number everyX;
    private Number streak;
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

}
