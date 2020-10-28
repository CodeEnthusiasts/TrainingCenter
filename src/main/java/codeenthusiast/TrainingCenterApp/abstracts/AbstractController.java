package codeenthusiast.TrainingCenterApp.abstracts;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<E extends AbstractEntity, D extends AbstractDTO> {

    public abstract AbstractService<E, D> getService();

    @GetMapping(value = "/{id}")
    public D getById(@PathVariable("id") Long id) {
        return getService().findById(id);
    }

    @GetMapping(value = "/all")
    public List<D> getAll(){
        return getService().getAll();
    }
    @PostMapping
    public D create(@RequestBody @Valid D dto){
        return getService().save(dto);
    }
    @PutMapping(value = "/{id}")
    public D update(@PathVariable("id") Long id, @RequestBody @Valid D dto){
        return getService().update(id, dto);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id)throws Exception {
        getService().delete(id);
    }
}
