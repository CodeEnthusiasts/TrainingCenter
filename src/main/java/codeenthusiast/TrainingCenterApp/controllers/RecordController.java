package codeenthusiast.TrainingCenterApp.controllers;

import codeenthusiast.TrainingCenterApp.entities.records.PersonalRecords;
import codeenthusiast.TrainingCenterApp.services.CustomRecordService;
import codeenthusiast.TrainingCenterApp.services.EnduranceRecordService;
import codeenthusiast.TrainingCenterApp.services.StrengthRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {

    private StrengthRecordService strengthRecordService;

    private EnduranceRecordService enduranceRecordService;

    private CustomRecordService customRecordService;

    public RecordController(StrengthRecordService strengthRecordService,
                            EnduranceRecordService enduranceRecordService, CustomRecordService customRecordService) {
        this.strengthRecordService = strengthRecordService;
        this.enduranceRecordService = enduranceRecordService;
        this.customRecordService = customRecordService;
    }

    @GetMapping()

}
