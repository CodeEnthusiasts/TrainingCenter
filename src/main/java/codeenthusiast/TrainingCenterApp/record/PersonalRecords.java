package codeenthusiast.TrainingCenterApp.record;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractEntity;
import codeenthusiast.TrainingCenterApp.record.custom.CustomRecord;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecord;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecord;
import codeenthusiast.TrainingCenterApp.user.major.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalRecords extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "personalRecords")
    @JsonIgnore
    private List<StrengthRecord> strengthRecords = new ArrayList<>();

    @OneToMany(mappedBy = "personalRecords")
    @JsonIgnore
    private List<EnduranceRecord> enduranceRecords = new ArrayList<>();

    @OneToMany(mappedBy = "personalRecords")
    @JsonIgnore
    private List<CustomRecord> customRecords = new ArrayList<>();


    private void addStrengthRecord(StrengthRecord strengthRecord) {
        strengthRecords.add(strengthRecord);
    }

    private void removeStrengthRecord(StrengthRecord strengthRecord) {
        strengthRecords.remove(strengthRecord);
    }

    private void addEnduranceRecord(EnduranceRecord enduranceRecord) {
        enduranceRecords.add(enduranceRecord);
    }

    private void removeStrengthRecord(EnduranceRecord enduranceRecord) {
        enduranceRecords.remove(enduranceRecord);
    }

    private void addCustomRecord(CustomRecord customRecord) {
        customRecords.add(customRecord);
    }

    private void removeCustomRecord(CustomRecord customRecord) {
        strengthRecords.remove(customRecord);
    }

}
