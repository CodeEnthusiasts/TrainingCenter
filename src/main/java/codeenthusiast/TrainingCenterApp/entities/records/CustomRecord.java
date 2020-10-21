package codeenthusiast.TrainingCenterApp.entities.records;

import codeenthusiast.TrainingCenterApp.dto.CustomRecordDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class CustomRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private double value;

    private LocalDate setDate;

    public CustomRecord() {
    }

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getSetDate() {
        return setDate;
    }

    public void setSetDate(LocalDate setDate) {
        this.setDate = setDate;
    }
}
