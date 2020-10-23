package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnduranceRecordDTO {

    @NotNull
    private String exerciseName;

    @NotNull
    private DistanceUnit distanceUnit;

    @NotNull
    @Range(min = 0, max = 10000)
    private int distance;

    @NotNull
    private TimeUnit timeUnit;

    @NotNull
    @Range(min = 0, max = 1000)
    private int time;

    private LocalDate setDate;
}
