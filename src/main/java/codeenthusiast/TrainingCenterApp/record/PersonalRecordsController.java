package codeenthusiast.TrainingCenterApp.record;

import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/users/{user_id}/personal-records")
    public ResponseEntity<PersonalRecords> getPersonalRecords(@PathVariable("user_id") Long id) {
        return ResponseEntity.ok(service.getPersonalRecordsById(id));
    }
}
