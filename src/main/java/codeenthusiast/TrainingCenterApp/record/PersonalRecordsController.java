package codeenthusiast.TrainingCenterApp.record;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PersonalRecordsController {

    private final PersonalRecordsServiceImpl service;

    public PersonalRecordsController(PersonalRecordsServiceImpl service) {
        this.service = service;
    }

    @PreAuthorize("authentication.principal.id == #userId")
    @GetMapping(value = "/users/{user_id}/personal-records")
    public ResponseEntity<PersonalRecords> getPersonalRecordsByUserId(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(service.getPersonalRecordsByUserId(userId));
    }
}
