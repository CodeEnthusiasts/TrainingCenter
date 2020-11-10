package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomRecordDTO extends AbstractDTO {

    private String description;
    private double value;
    private LocalDate date;
}
