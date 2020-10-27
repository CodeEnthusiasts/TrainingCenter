package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomRecord extends AbstractEntity {

    @NotNull
    private String description;
    @NotNull
    private double value;
    @NotNull
    private LocalDate setDate;

    public CustomRecord(CustomRecordDTO customRecord) {
        this.description = customRecord.getDescription();
        this.value = customRecord.getValue();
        this.setDate = customRecord.getSetDate();
    }

    public CustomRecord(String description, double value, LocalDate setData) {
        this.description = description;
        this.value = value;
        this.setDate = setData;
    }

}
