package codeenthusiast.TrainingCenterApp.record.endurance;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnduranceRecordDTO extends AbstractDTO {

    @NotNull
    private String movementName;

    @NotNull
    private DistanceUnit distanceUnit;

    @NotNull
    private double distance;

    @NotNull
    private TimeUnit timeUnit;

    @NotNull
    private LocalTime duration;

    @NotNull
    private LocalDate date;

}
