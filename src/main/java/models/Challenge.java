package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@SuperBuilder

public class Challenge implements Comparable<Challenge> {
    private String id;
    private String name;
    private String group;
    private String shortName;
    private String summary;
    private String description;


    // compare Tag object for array sorting
    @Override
    public int compareTo(Challenge other) {

        return this.
                id.
                compareTo(other.id);
    }


    public static Challenge getDefaultChallenge() {
        Challenge challenge = new Challenge();
        challenge.name = "ChallengeName";
        return challenge;
    }

}
