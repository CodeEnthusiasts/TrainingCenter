package codeenthusiast.TrainingCenterApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityAlreadyFoundException extends RuntimeException {
    public EntityAlreadyFoundException(String entityName){
        super(entityName + " already exists");
    }
}
