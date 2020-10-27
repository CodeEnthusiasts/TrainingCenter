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
        keyTechniqueElement1 = new KeyTechniqueElement("Rozstaw nogi na szerkości barków");
        keyTechniqueElement2 = new KeyTechniqueElement("Stopy delikatnie na zewnątrz");
        keyTechniqueElement3 = new KeyTechniqueElement("Napnij mięsnie brzucha");
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