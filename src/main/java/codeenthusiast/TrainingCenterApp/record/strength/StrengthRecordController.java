package codeenthusiast.TrainingCenterApp.record.strength;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractController;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal-records")
public class StrengthRecordController extends AbstractController<StrengthRecord, StrengthRecordDTO> {

    private final StrengthRecordServiceImpl strengthRecordServiceImpl;

    public StrengthRecordController(StrengthRecordServiceImpl strengthRecordServiceImpl) {
        this.strengthRecordServiceImpl = strengthRecordServiceImpl;
    }

    @Override
    public AbstractService<StrengthRecord, StrengthRecordDTO> getService() {
        return strengthRecordServiceImpl;
    }

    @GetMapping(value = "/{personal_record_id}/strength-records/all")
    public ResponseEntity<List<StrengthRecordDTO>> getStrengthRecords(@PathVariable("personal_records_id") Long id) {
        return ResponseEntity.ok(strengthRecordServiceImpl.getAllStrengthRecordsByPersonalRecordsId(id));
    }

    @GetMapping(value = "/{personal_record_id}/strength-records/three")
    public ResponseEntity<List<StrengthRecordDTO>> getThreeLatestStrengthRecords(@PathVariable("personal_records_id")
                                                                                         Long id) {
        return ResponseEntity.ok(strengthRecordServiceImpl.getThreeLatestStrengthRecordsByPersonalRecordsId(id));
    }

    //create
    @PostMapping(value = "/{personal_record_id}/strength-records")
    public ResponseEntity<StrengthRecordDTO> createStrengthRecord(@PathVariable("personal_records_id") Long id,
                                                                  @RequestBody StrengthRecordDTO strengthRecordDTO) {
        return ResponseEntity.ok(strengthRecordServiceImpl.save(strengthRecordDTO));
    }
    //update
    @PatchMapping(value = "/strength-records/{strength_record_id}")
    public ResponseEntity<StrengthRecordDTO> updateStrengthRecord(@PathVariable("strength_record_id") Long id,
                                                                  @RequestBody StrengthRecordDTO strengthRecordDTO) {
        return ResponseEntity.ok(strengthRecordServiceImpl.update(id, strengthRecordDTO));
    }
    //delete
    @DeleteMapping(value = "/strength-records/{strength_record_id}")
    public ResponseEntity<String> deleteStrengthRecord(@PathVariable("strength_record_id") Long id) {
        return ResponseEntity.ok(strengthRecordServiceImpl.deleteById(id));
    }
}
