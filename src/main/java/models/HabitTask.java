package models;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;


@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

public class HabitTask extends Task {
    private Boolean up;
    private Boolean down;

    @Builder
    public HabitTask(String taskName) {
      super(taskName, "habit");
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
