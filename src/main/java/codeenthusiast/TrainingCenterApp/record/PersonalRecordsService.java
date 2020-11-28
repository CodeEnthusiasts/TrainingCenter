package codeenthusiast.TrainingCenterApp.record;

public interface PersonalRecordsService {

    PersonalRecords getPersonalRecordsByUserId(Long userId);

    PersonalRecords savePersonalRecords(PersonalRecords personalRecords);

}
