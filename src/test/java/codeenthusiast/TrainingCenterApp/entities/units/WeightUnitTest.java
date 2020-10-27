package codeenthusiast.TrainingCenterApp.entities.units;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class WeightUnitTest {
    @DisplayName("Check if enum WeightUnit contains correct values")
    @ParameterizedTest
    @EnumSource(WeightUnit.class)
    void weightUnitsShouldEqualsSpecificValues(WeightUnit weightUnit) {
        assertThat("KILOGRAMS, POUNDS, BARS, BODYWEIGHT").containsSubsequence(weightUnit.toString());
    }
}