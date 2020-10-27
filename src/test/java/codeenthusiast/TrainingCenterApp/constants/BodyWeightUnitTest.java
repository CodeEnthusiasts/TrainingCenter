package codeenthusiast.TrainingCenterApp.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class BodyWeightUnitTest {
    @DisplayName("Check if enum BodyWeightUnit contains correct values")
    @ParameterizedTest
    @EnumSource(BodyWeightUnit.class)
    void bodyWeightUnitsShouldEqualsSpecificValues(BodyWeightUnit bodyWeightUnit) {
        assertThat("KILOGRAMS, POUNDS").containsSubsequence(bodyWeightUnit.toString());
    }
}