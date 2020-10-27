package codeenthusiast.TrainingCenterApp.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class HeightUnitTest {
    @DisplayName("Check if enum HeightUnit contains correct values")
    @ParameterizedTest
    @EnumSource(HeightUnit.class)
    void heightUnitsShouldEqualsSpecificValues(HeightUnit heightUnit) {
        assertThat("METER, INCH").containsSubsequence(heightUnit.toString());
    }
}