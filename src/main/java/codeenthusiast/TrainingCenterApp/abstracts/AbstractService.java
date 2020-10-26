package codeenthusiast.TrainingCenterApp.abstracts;

import java.util.List;

public interface AbstractService <E extends AbstractEntity, D extends AbstractDTO> {

    D update (Long id, D dto);
    D findById (Long id);
    D save (D dto);
    void delete (Long id);
    List<D> getAll();


}
