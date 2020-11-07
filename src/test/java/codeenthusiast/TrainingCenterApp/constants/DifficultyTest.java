package codeenthusiast.TrainingCenterApp.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class DifficultyTest {
    @DisplayName("Check if enum Difficulty contains correct values")
    @ParameterizedTest
    @EnumSource(Difficulty.class)
    void difficultyShouldEqualsSpecificValues(Difficulty difficulty) {
        assertThat("EASY, MEDIUM, HARD, INSANE").containsSubsequence(difficulty.toString());
    }
}