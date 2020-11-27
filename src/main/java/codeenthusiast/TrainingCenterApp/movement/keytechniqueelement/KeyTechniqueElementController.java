package codeenthusiast.TrainingCenterApp.movement.keytechniqueelement;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping(value = "/movement/{movement-id}")
    public KeyTechniqueElementDTO create(@PathVariable("movement_id") Long id,
                                         @RequestBody @Valid KeyTechniqueElementDTO dto) {
        return keyTechniqueElementService.create(id, dto);
    }

    @PatchMapping(value = "/{id}")
    public KeyTechniqueElementDTO update(@PathVariable("id") Long id, @RequestBody @Valid KeyTechniqueElementDTO dto) {
        return keyTechniqueElementService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        keyTechniqueElementService.deleteById(id);
    }


}
