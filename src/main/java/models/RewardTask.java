package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Log4j2
@SuperBuilder

public class RewardTask extends Task {
    private Number value;


    public RewardTask(String taskName, Number value) {
      super("iD",taskName, "reward");
        this.value = value;
    }


    public static RewardTask randomRewardTask() {

        return new RewardTask(RandomStringUtils.random(10, true, false), (int) (Math.random()*100));
    }

    public static RewardTask defaultRewardTask() {

        return new RewardTask("RewardTask_name", 10);
    }

}
