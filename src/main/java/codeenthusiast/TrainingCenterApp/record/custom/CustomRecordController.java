package codeenthusiast.TrainingCenterApp.record.custom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController(value = "/api")
public class CustomRecordController {

    private final CustomRecordServiceImpl customRecordService;

    public CustomRecordController(CustomRecordServiceImpl customRecordService) {
        this.customRecordService = customRecordService;
    }

    @GetMapping(value = "/personal-records/{personal_records_id}/custom-records/all")
    public ResponseEntity<List<CustomRecordDTO>> getCustomRecords(@PathVariable("personal_records_id") Long id) {
        return ResponseEntity.ok(customRecordService.getAllCustomRecordsByPersonalRecordsId(id));
    }

    @GetMapping(value = "/personal-records/{personal_records_id}/custom-records/three")
    public ResponseEntity<List<CustomRecordDTO>> getThreeLatestCustomRecords(@PathVariable("personal_records_id")
                                                                                     Long id) {
        return ResponseEntity.ok(customRecordService.getThreeLatestCustomRecordsByPersonalRecordsId(id));
    }


    @PostMapping(value = "/personal-records/{personal_records_id}/custom-records")
    public ResponseEntity<CustomRecordDTO> createCustomRecord(@PathVariable("personal_records_id") Long id,
                                                              @RequestBody CustomRecordDTO customRecordDTO) {
        return ResponseEntity.ok(customRecordService.createCustomRecord(id, customRecordDTO));
    }

    @PatchMapping(value = "/custom-records/{custom_record_id}")
    public ResponseEntity<CustomRecordDTO> updateCustomRecord(@PathVariable("custom_record_id") Long id,
                                                              @RequestBody CustomRecordDTO customRecordDTO) {
        return ResponseEntity.ok(customRecordService.updateCustomRecord(id, customRecordDTO));
    }

    @DeleteMapping(value = "/custom-records/{custom_record_id}")
    public ResponseEntity<String> deleteCustomRecord(@PathVariable("custom_record_id") Long id) {
        return ResponseEntity.ok(customRecordService.deleteCustomRecord(id));
    }

}
