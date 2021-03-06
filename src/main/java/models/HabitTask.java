package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.Timestamp;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Log4j2
@SuperBuilder

public class HabitTask extends Task {

    private Boolean up;
    private Boolean down;
    private Integer counterUp;
    private Integer counterDown;
    private HistoryItem[] history;


    public HabitTask(String taskName) {
      super("iD",taskName, "habit");
      this.down = true;
      this.up = true;
    }


    public static HabitTask randomHabitTask() {

        return new HabitTask(RandomStringUtils.random(10, true, false));
    }

    public static HabitTask defaultHabitTask() {

        return new HabitTask("HabitTask_name");
    }

}
