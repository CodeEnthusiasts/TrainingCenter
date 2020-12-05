package codeenthusiast.TrainingCenterApp.record;

public interface PersonalRecordsService {

    PersonalRecords getPersonalRecordsByUserId(Long userId);

    PersonalRecords getPersonalRecordsEntityById(Long personalRecordsId);

}
