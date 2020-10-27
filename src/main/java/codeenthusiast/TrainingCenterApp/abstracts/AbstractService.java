package codeenthusiast.TrainingCenterApp.abstracts;

import java.util.List;

public interface AbstractService <E extends AbstractEntity, D extends AbstractDTO> {

    D findById (Long id);
    List<D> getAll();
    D save (D dto);
    D update (Long id, D dto);
    void delete (Long id);
}
