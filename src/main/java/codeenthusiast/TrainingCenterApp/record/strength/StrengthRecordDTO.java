package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.units.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.units.WeightUnit;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StrengthRecordDTO {

    @NotNull
    private String exerciseName;

    @NotNull
    private WeightUnit weightUnit;

    @NotNull
    @Range(min = -30, max = 500)
    private int weight;

    @NotNull
    private RepetitionUnit repetitionUnit;

    @NotNull
    @Range(min = 0, max = 1000)
    private int repetition;

    @NotNull
    private LocalDate setDate;

    public StrengthRecordDTO() {
    }

    public StrengthRecordDTO(String exerciseName, WeightUnit weightUnit, int weight,
                              RepetitionUnit repetitionUnit, int repetition, LocalDate setDate) {
        this.exerciseName = exerciseName;
        this.weightUnit = weightUnit;
        this.weight = weight;
        this.repetitionUnit = repetitionUnit;
        this.repetition = repetition;
        this.setDate = setDate;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public RepetitionUnit getRepetitionUnit() {
        return repetitionUnit;
    }

    public void setRepetitionUnit(RepetitionUnit repetitionUnit) {
        this.repetitionUnit = repetitionUnit;
    }

    public LocalDate getSetDate() {
        return setDate;
    }

    public void setSetDate(LocalDate setDate) {
        this.setDate = setDate;
    }
}
