package codeenthusiast.TrainingCenterApp.entities.records;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Embeddable
public class PersonalRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<StrengthRecord> strengthRecords = new ArrayList<>();

    @OneToMany
    private List<EnduranceRecord> enduranceRecords = new ArrayList<>();


    @OneToMany
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
