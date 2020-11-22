package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.record.PersonalRecords;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomRecord extends AbstractEntity {

    private String description;

    private double value;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "personal_records_id")
    private PersonalRecords personalRecords;

    public CustomRecord(CustomRecordDTO customRecord) {
        this.description = customRecord.getDescription();
        this.value = customRecord.getValue();
        this.date = customRecord.getDate();
    }


}
