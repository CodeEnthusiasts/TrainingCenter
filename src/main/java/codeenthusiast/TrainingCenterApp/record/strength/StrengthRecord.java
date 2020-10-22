package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.units.RepetitionUnit;
import codeenthusiast.TrainingCenterApp.units.WeightUnit;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class StrengthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exerciseName;
    // show list of names from Exercise base;

    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    private int weight;

    @Enumerated(EnumType.STRING)
    private RepetitionUnit repetitionUnit;

    private int repetition;

    private LocalDate setDate;

    public StrengthRecord() {
    }

    public StrengthRecord(StrengthRecordDTO strengthRecordDTO) {
        this.exerciseName = strengthRecordDTO.getExerciseName();
        this.weightUnit = strengthRecordDTO.getWeightUnit();
        this.weight = strengthRecordDTO.getWeight();
        this.repetitionUnit = strengthRecordDTO.getRepetitionUnit();
        this.repetition = strengthRecordDTO.getRepetition();
        this.setDate = strengthRecordDTO.getSetDate();
    }

    public StrengthRecord(String exerciseName, WeightUnit weightUnit, int weight,
                          RepetitionUnit repetitionUnit, int repetition, LocalDate setDate) {
        this.exerciseName = exerciseName;
        this.weightUnit = weightUnit;
        this.weight = weight;
        this.repetitionUnit = repetitionUnit;
        this.repetition = repetition;
        this.setDate = setDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public RepetitionUnit getRepetitionUnit() {
        return repetitionUnit;
    }

    public void setRepetitionUnit(RepetitionUnit repetitionUnit) {
        this.repetitionUnit = repetitionUnit;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public LocalDate getSetDate() {
        return setDate;
    }

    public void setSetDate(LocalDate setDate) {
        this.setDate = setDate;
    }
}

