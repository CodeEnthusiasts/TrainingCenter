package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDTO extends AbstractDTO {

    private String filePath;
    private String fileUrl;
}
