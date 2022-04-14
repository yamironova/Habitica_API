package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Log4j2
@SuperBuilder

public class Approval {
    @NonNull private Boolean required;
    @NonNull private Boolean approved;
             private Boolean requested;

    public static Approval defaultApproval() {

        return new Approval(false,false,false);
    }
}
