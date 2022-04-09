package models;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Date;


@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

public class DailyTask extends Task {
    private String frequency;
    private String repeat;
    private Number everyX;
    private Number streak;
    private Integer[] daysOfMonth;
    private Integer[] weeksOfMonth;
    private Date startDate;

    @Builder
    public DailyTask(String taskName) {
      super(taskName, "daily"); }


    public static DailyTask randomDailyTask() {

        return new DailyTask(RandomStringUtils.random(10, true, false));
    }

    public static DailyTask defaultDailyTask() {

        return new DailyTask("DailyTask_name");
    }

}
