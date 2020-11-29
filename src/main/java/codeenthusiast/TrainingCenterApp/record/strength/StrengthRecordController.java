package codeenthusiast.TrainingCenterApp.record.strength;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StrengthRecordController {

    private final StrengthRecordServiceImpl strengthRecordServiceImpl;

    public StrengthRecordController(StrengthRecordServiceImpl strengthRecordServiceImpl) {
        this.strengthRecordServiceImpl = strengthRecordServiceImpl;
    }

    @GetMapping(value = "/personal_records/{personal_record_id}/strength-records/all")
    public ResponseEntity<List<StrengthRecordDTO>> getStrengthRecords(@PathVariable("personal_record_id") Long id) {
        return ResponseEntity.ok(strengthRecordServiceImpl.getAllStrengthRecordsByPersonalRecordsId(id));
    }

    @GetMapping(value = "/personal_records/{personal_record_id}/strength-records/three")
    public ResponseEntity<List<StrengthRecordDTO>> getThreeLatestStrengthRecords(@PathVariable("personal_record_id")
                                                                                         Long id) {
        return ResponseEntity.ok(strengthRecordServiceImpl.getThreeLatestStrengthRecordsByPersonalRecordsId(id));
    }


    @PostMapping(value = "/personal_records/{personal_record_id}/strength-records")
    public ResponseEntity<StrengthRecordDTO> createStrengthRecord(@PathVariable("personal_record_id") Long id,
                                                                  @RequestBody StrengthRecordDTO strengthRecordDTO) {
        return ResponseEntity.ok(strengthRecordServiceImpl.createStrengthRecord(id, strengthRecordDTO));
    }

    @PatchMapping(value = "/strength-records/{strength_record_id}")
    public ResponseEntity<StrengthRecordDTO> updateStrengthRecord(@PathVariable("strength_record_id") Long id,
                                                                  @RequestBody StrengthRecordDTO strengthRecordDTO) {
        return ResponseEntity.ok(strengthRecordServiceImpl.updateStrengthRecord(id, strengthRecordDTO));
    }

    @DeleteMapping(value = "/strength-records/{strength_record_id}")
    public ResponseEntity<String> deleteStrengthRecord(@PathVariable("strength_record_id") Long id) {
        return ResponseEntity.ok(strengthRecordServiceImpl.deleteStrengthRecord(id));
    }
}
