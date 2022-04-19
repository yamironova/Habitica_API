package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

@Data
@ToString
@RequiredArgsConstructor
@Log4j2
@SuperBuilder

public class Checklist {
    @NonNull private String text;
    @NonNull private Boolean completed;
}
