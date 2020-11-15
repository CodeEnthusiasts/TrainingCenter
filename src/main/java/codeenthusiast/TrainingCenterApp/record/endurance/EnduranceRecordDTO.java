package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnduranceRecordDTO extends AbstractDTO {

    private String exerciseName;
    private DistanceUnit distanceUnit;
    private int distance;
    private TimeUnit timeUnit;
    private int time;
    private LocalTime duration;
    private LocalDate setDate;
}
