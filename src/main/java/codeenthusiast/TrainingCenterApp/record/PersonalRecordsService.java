package codeenthusiast.TrainingCenterApp.record;

public interface PersonalRecordsService {

    PersonalRecords getPersonalRecordsById(Long id);

    PersonalRecords savePersonalRecords(PersonalRecords personalRecords);

}
