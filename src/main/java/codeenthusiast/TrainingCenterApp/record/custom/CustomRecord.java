package codeenthusiast.TrainingCenterApp.record.custom;

import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private double value;

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
