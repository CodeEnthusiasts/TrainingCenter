package codeenthusiast.TrainingCenterApp.record;

import codeenthusiast.TrainingCenterApp.record.custom.CustomRecordService;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecordService;
import codeenthusiast.TrainingCenterApp.record.strength.StrengthRecordService;
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

}
