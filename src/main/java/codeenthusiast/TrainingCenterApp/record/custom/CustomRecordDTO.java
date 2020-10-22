package codeenthusiast.TrainingCenterApp.record.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomRecordDTO {

    @NotNull
    private String description;

    @NotNull
    private double value;

    @NotNull
    private LocalDate setDate;
}
