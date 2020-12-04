package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import org.springframework.stereotype.Service;

@Service
public interface KeyTechniqueElementService {

    KeyTechniqueElement findEntityById(Long id);

    KeyTechniqueElementDTO findById(Long id);

    KeyTechniqueElementDTO update(Long id, KeyTechniqueElementDTO dto);

    KeyTechniqueElementDTO create(Long id, KeyTechniqueElementDTO dto);

    KeyTechniqueElementDTO save(KeyTechniqueElement kte);

    void deleteById(Long id);

}
