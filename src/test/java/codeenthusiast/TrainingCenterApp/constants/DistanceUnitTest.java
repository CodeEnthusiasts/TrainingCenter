package codeenthusiast.TrainingCenterApp.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceUnitTest {
    @DisplayName("Check if enum DistanceUnit contains correct values")
    @ParameterizedTest
    @EnumSource(DistanceUnit.class)
    void distanceUnitsShouldEqualsSpecificValues(DistanceUnit distanceUnit) {
        assertThat("METER, KILOMETER, MILE, FEET").containsSubsequence(distanceUnit.toString());
    }
}