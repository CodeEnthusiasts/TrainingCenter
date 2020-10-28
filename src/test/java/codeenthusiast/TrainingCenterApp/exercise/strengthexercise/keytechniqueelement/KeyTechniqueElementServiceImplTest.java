package codeenthusiast.TrainingCenterApp.exercise.strengthexercise.keytechniqueelement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class KeyTechniqueElementServiceImplTest {

    KeyTechniqueElement keyTechniqueElement1;
    KeyTechniqueElement keyTechniqueElement2;
    KeyTechniqueElement keyTechniqueElement3;

    @BeforeEach
    void setUp() {
        keyTechniqueElement1 = new KeyTechniqueElement("Stand with the bar on your upper-back, " +
                                                                "and your feet shoulder-width apart.");
        keyTechniqueElement2 = new KeyTechniqueElement("Stand with the bar on your upper-back, " +
                                                                "and your feet shoulder-width apart.");
        keyTechniqueElement3 = new KeyTechniqueElement("Break parallel by Squatting down until " +
                                                                "your hips are lower than your knees");
    }

//    @Test
//    @DisplayName("Checking method existsById when exists")
//
//
//    @Test
//    @DisplayName("Checking method existsById when not exists")
//
//
//    @Test
//    @DisplayName("Checking method existsByName when exists")
//
//
//    @Test
//    @DisplayName("Checking method existsByName when not exists")
}
