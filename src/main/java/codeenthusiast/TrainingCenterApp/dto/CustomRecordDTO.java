package codeenthusiast.TrainingCenterApp.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CustomRecordDTO {

    @NotNull
    private String description;

    @NotNull
    private double value;

    @NotNull
    private LocalDate setDate;

    public CustomRecordDTO() {
    }

    public CustomRecordDTO(String description, double value, @NotNull LocalDate setDate) {
        this.description = description;
        this.value = value;
        this.setDate = setDate;
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
