package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/key-technique-elements")
public class KeyTechniqueElementController {

    private final KeyTechniqueElementServiceImpl keyTechniqueElementService;

    public KeyTechniqueElementController(KeyTechniqueElementServiceImpl keyTechniqueElementService) {
        this.keyTechniqueElementService = keyTechniqueElementService;
    }

    @GetMapping(value = "/{id}")
    public KeyTechniqueElementDTO getById(@PathVariable("id") Long id) {
        return keyTechniqueElementService.findById(id);
    }

    @GetMapping(value = "/movement/{movement-id}/all")
    public List<KeyTechniqueElementDTO> getAllByMovementId(@PathVariable("movement-id") Long id){
        return keyTechniqueElementService.findAllByMovementId(id);
    }

    @PostMapping(value = "/movement/{movement-id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public KeyTechniqueElementDTO create(@PathVariable("movement-id") Long id,
                                         @RequestBody @Valid KeyTechniqueElementDTO dto) {
        return keyTechniqueElementService.create(id, dto);
    }

    @PatchMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public KeyTechniqueElementDTO update(@PathVariable("id") Long id, @RequestBody @Valid KeyTechniqueElementDTO dto) {
        return keyTechniqueElementService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public void delete(@PathVariable("id") Long id) throws Exception {
        keyTechniqueElementService.deleteById(id);
    }


}
