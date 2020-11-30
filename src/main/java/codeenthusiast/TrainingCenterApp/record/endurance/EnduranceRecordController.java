package codeenthusiast.TrainingCenterApp.record.endurance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EnduranceRecordController {

    private final EnduranceRecordServiceImpl enduranceRecordService;

    public EnduranceRecordController(EnduranceRecordServiceImpl enduranceRecordService) {
        this.enduranceRecordService = enduranceRecordService;
    }

    @GetMapping(value = "/personal-records/{personal_records_id}/endurance-records/all")
    public ResponseEntity<List<EnduranceRecordDTO>> getEnduranceRecords(@PathVariable("personal_records_id") Long id) {
        return ResponseEntity.ok(enduranceRecordService.getAllEnduranceRecordsByPersonalRecordsId(id));
    }

    @GetMapping(value = "/personal-records/{personal_records_id}/endurance-records/three")
    public ResponseEntity<List<EnduranceRecordDTO>> getThreeLatestEnduranceRecords(@PathVariable("personal_records_id")
                                                                                         Long id) {
        return ResponseEntity.ok(enduranceRecordService.getThreeLatestEnduranceRecordsByPersonalRecordsId(id));
    }


    @PostMapping(value = "/personal-records/{personal_records_id}/endurance-records")
    public ResponseEntity<EnduranceRecordDTO> createEnduranceRecord(@PathVariable("personal_records_id") Long id,
                                                                    @RequestBody EnduranceRecordDTO enduranceRecordDTO) {
        return ResponseEntity.ok(enduranceRecordService.createEnduranceRecord(id, enduranceRecordDTO));
    }

    @PatchMapping(value = "/endurance-records/{endurance_record_id}")
    public ResponseEntity<EnduranceRecordDTO> updateEnduranceRecord(@PathVariable("endurance_record_id") Long id,
                                                                    @RequestBody EnduranceRecordDTO enduranceRecordDTO) {
        return ResponseEntity.ok(enduranceRecordService.updateEnduranceRecord(id, enduranceRecordDTO));
    }

    @DeleteMapping(value = "/endurance-records/{endurance_record_id}")
    public ResponseEntity<String> deleteEnduranceRecord(@PathVariable("endurance_record_id") Long id) {
        return ResponseEntity.ok(enduranceRecordService.deleteEnduranceRecord(id));
    }

}
