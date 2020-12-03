package codeenthusiast.TrainingCenterApp.record;

public interface PersonalRecordsService {

    PersonalRecords getPersonalRecordsByUserId(Long userId);

    PersonalRecords getPersonalRecordsById(Long personalRecordsId);

    boolean hasAccess(PersonalRecords personalRecords);
}
