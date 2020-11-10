package codeenthusiast.TrainingCenterApp.services;

import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecordDTO;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecord;
import codeenthusiast.TrainingCenterApp.constants.DistanceUnit;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecordService;
import codeenthusiast.TrainingCenterApp.record.endurance.EnduranceRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@MockitoSettings(strictness = Strictness.STRICT_STUBS)
//@ExtendWith(SpringExtension.class)
//class EnduranceRecordServiceTest {
//
//    ModelMapper modelMapper;
//
//    LocalDate currentDate = LocalDate.now();
//
//    EnduranceRecord sprint100m;
//    EnduranceRecord secondSprint100m;
//    EnduranceRecord kilometerRun;
//    EnduranceRecord marathon;
//    List<EnduranceRecord> sprint100mRecords;
//
//    EnduranceRecord fiveKilometersRun;
//    EnduranceRecordDTO threeKilometersRun;
//    List<EnduranceRecord> enduranceRecords;
//
//    @Mock
//    EnduranceRecordRepository enduranceRecordRepository;
//
//    EnduranceRecordService enduranceRecordService;
//
//    @BeforeEach
//    void setUp() {
//
//        modelMapper = new ModelMapper();
//        currentDate = LocalDate.now();
//
//        sprint100m = new EnduranceRecord("Sprint - 100m", DistanceUnit.METER,
//                100, TimeUnit.SECONDS, 15, currentDate);
//        secondSprint100m = new EnduranceRecord("Sprint - 100m", DistanceUnit.METER,
//                100, TimeUnit.SECONDS, 14, currentDate);
//
//        kilometerRun = new EnduranceRecord("Run - 1 KM", DistanceUnit.KILOMETER,
//                1, TimeUnit.MINUTES, 5, currentDate.minusDays(3));
//        marathon = new EnduranceRecord("Marathon", DistanceUnit.KILOMETER,
//                43, TimeUnit.HOURS, 3, currentDate.minusDays(5));
//        threeKilometersRun = new EnduranceRecordDTO("Run - 3 kilometers", DistanceUnit.KILOMETER, 3,
//                TimeUnit.MINUTES, 15, currentDate.minusDays(2));
//        fiveKilometersRun = new EnduranceRecord("Run - 5 kilometers", DistanceUnit.KILOMETER, 5,
//                TimeUnit.MINUTES, 25, currentDate.minusDays(2));
//
//        sprint100mRecords = Arrays.asList(sprint100m, secondSprint100m);
//        enduranceRecords = Arrays.asList(kilometerRun, marathon);
//
//        enduranceRecordService = new EnduranceRecordService(enduranceRecordRepository);
//    }
//
//    @Test
//    @DisplayName("Check if mapping is correctly done")
//    void shouldMapToRecordDTO() {
//        //given + when
//        EnduranceRecordDTO result = enduranceRecordService.mapToEnduranceRecordDTO(sprint100m);
//
//        //then
//        assertAll(
//                () -> assertThat(result.getExerciseName(), equalTo(sprint100m.getExerciseName())),
//                () -> assertThat(result.getSetDate(), equalTo(sprint100m.getSetDate())));
//    }
//
//    @Test
//    @DisplayName("Check if list of records is correctly mapped")
//    void mapToListOfStrengthDTOs() {
//        //given + when
//        List<EnduranceRecordDTO> result = enduranceRecordService.mapToListOfEnduranceDTOs(enduranceRecords);
//
//        //then
//        assertAll(
//                () -> assertThat(result.size(), equalTo(enduranceRecords.size())),
//                () -> assertThat(result.get(0).getExerciseName(), equalTo(enduranceRecords.get(0).getExerciseName())));
//    }
//
//
//    @Test
//    @DisplayName("Check if all records is returned and mapped to DTO")
//    void shouldReturnAllRecords() {
//        //given
//
//        given(enduranceRecordRepository.findAll()).willReturn(enduranceRecords);
//
//        //when
//        List<EnduranceRecordDTO> result = enduranceRecordService.getAllStrengthRecords();
//
//        //then
//        assertAll(
//                () -> assertThat(result.size(), equalTo(enduranceRecords.size())),
//                () -> assertThat(result.get(1).getExerciseName(), equalTo("Marathon")));
//    }
//
//    @Test
//    @DisplayName("Check if all records is for given exercise returned and mapped to DTO")
//    void shouldReturnAllRecordsForGivenExercise() {
//        //given
//        given(enduranceRecordRepository.findByExerciseName("Sprint - 100m")).willReturn(sprint100mRecords);
//
//        //when
//        List<EnduranceRecordDTO> result = enduranceRecordService.getEnduranceRecordsForExercise("Sprint - 100m");
//
//        //then
//        assertAll(
//                () -> assertThat(result.size(), equalTo(sprint100mRecords.size())),
//                () -> assertThat(result.get(1).getExerciseName(), equalTo("Sprint - 100m")));
//    }
//
//
//    @Test
//    @DisplayName("Check if new record is created")
//    void shouldCreateNewEnduranceRecord() {
//        //given
//        EnduranceRecordDTO sprint = new EnduranceRecordDTO("Sprint - 100m",
//                DistanceUnit.METER, 100, TimeUnit.SECONDS, 14, currentDate);
//
//        given(enduranceRecordService.getRecordsWithSameNameAndTime(sprint)).willReturn(sprint100mRecords);
//
//        //when
//        EnduranceRecordDTO result = enduranceRecordService.createNewRecord(new EnduranceRecordDTO("Sprint - 100m", DistanceUnit.METER, 100,
//                TimeUnit.SECONDS, 14, currentDate));
//
//        //then
//        assertAll(
//                () -> verify(enduranceRecordRepository, times(1)).save(ArgumentMatchers.any()),
//                () -> assertThat(result.getExerciseName(), equalTo("Sprint - 100m")),
//                () -> assertThat(result.getTime(), equalTo(14)));
//
//    }
//
//    @Test
//    @DisplayName("Check if entities with correct name and repetition are returned")
//    void shouldReturnRecordsWithTheSameNameAndRepetition() {
//        //given
//        EnduranceRecordDTO sprint = new EnduranceRecordDTO("Sprint - 100m",
//                DistanceUnit.METER, 100, TimeUnit.SECONDS, 15, currentDate);
//
//        given(enduranceRecordRepository.findByExerciseNameAndTime("Sprint - 100m", 15)).willReturn(sprint100mRecords);
//
//        //when
//        List<EnduranceRecord> result = enduranceRecordService.getRecordsWithSameNameAndTime(sprint);
//
//        //then
//        assertThat(result, equalTo(result));
//    }
//
//    @Test
//    @DisplayName("Check if highest record value is returned")
//    void shouldReturnHighestValue() {
//        //given + when
//        int result = enduranceRecordService.findHighestPreviousRecordValue(sprint100mRecords);
//
//        //then
//        assertThat(result, equalTo(sprint100m.getTime()));
//    }
//
//    @Test
//    @DisplayName("Check if exception is thrown when new record value is less than previous")
//    void shouldThrowExceptionWHenNewRecordValueIsHigherThanPrevious() {
//        //given + when
//        int highestPreviousRecord = 5;
//        EnduranceRecordDTO newRecord = modelMapper.map(sprint100m, EnduranceRecordDTO.class);
//
//        //then
//        assertThrows(IllegalArgumentException.class, () ->
//                enduranceRecordService.checkNewRecordSuperiority(newRecord, highestPreviousRecord));
//
//    }
//
//    @Test
//    @DisplayName("Check if given record is deleted")
//    void shouldDeleteRecord() {
//        //given + when
//        enduranceRecordService.deleteRecord("Squat", 150, 1);
//
//        //then
//        verify(enduranceRecordRepository, times(1)).deleteByExerciseNameAndDistanceAndTime("Squat", 150, 1);
//    }

//}
