package models;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Log4j2
@SuperBuilder

public class HistoryItem {
    @NonNull private Timestamp date;
    private Number value;
    private Integer scoredUp;
    private Integer scoredDown;
}
