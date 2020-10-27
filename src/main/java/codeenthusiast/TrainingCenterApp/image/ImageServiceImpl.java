package codeenthusiast.TrainingCenterApp.image;

import codeenthusiast.TrainingCenterApp.abstracts.AbstractReposiotory;
import codeenthusiast.TrainingCenterApp.abstracts.AbstractServiceImpl;
import codeenthusiast.TrainingCenterApp.mappers.AbstractMapper;
import codeenthusiast.TrainingCenterApp.mappers.ImageMapper;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl extends AbstractServiceImpl<Image, ImageDTO> implements ImageService {

    private final ImageRepository repository;
    private final ImageMapper mapper;

    public ImageServiceImpl(AbstractReposiotory<Image> reposiotory, AbstractMapper<Image, ImageDTO> mapper, ImageRepository repository, ImageMapper mapper1) {
        super(reposiotory, mapper);
        this.repository = repository;
        this.mapper = mapper1;
    }

    //todo add Cloudinary api here and adding img methods.

    @Override
    public Image createNewImage(String filePath) {
        return new Image();
    }

    @Override
    public Image findByFileUrl(String fileUrl) {
        return new Image();

    }


}
