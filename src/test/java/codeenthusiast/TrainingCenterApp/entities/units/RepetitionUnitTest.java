package codeenthusiast.TrainingCenterApp.entities.units;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class RepetitionUnitTest {
    @DisplayName("Check if enum RepetitionUnit contains correct values")
    @ParameterizedTest
    @EnumSource(RepetitionUnit.class)
    void repetitionUnitsShouldEqualsSpecificValues(RepetitionUnit repetitionUnit) {
        assertThat("TIME, MOTION").containsSubsequence(repetitionUnit.toString());
    }
}