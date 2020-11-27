package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import org.springframework.stereotype.Service;

@Service
public interface KeyTechniqueElementService {

    void deleteById(Long id);

    KeyTechniqueElementDTO findById(Long id);

    KeyTechniqueElementDTO update(Long id, KeyTechniqueElementDTO dto);

    KeyTechniqueElementDTO create(Long id, KeyTechniqueElementDTO dto);

    KeyTechniqueElementDTO save(KeyTechniqueElementDTO dto);

}
