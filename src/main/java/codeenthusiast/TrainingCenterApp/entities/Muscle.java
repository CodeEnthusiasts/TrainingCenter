package codeenthusiast.TrainingCenterApp.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "muscles")
public class Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "muscle")
    private List<Image> images = new ArrayList<>();

    private boolean isInjured;

    public Muscle() {
    }

    public Muscle(String name, String description, List<Image> images) {
        this.name = name;
        this.description = description;
        this.images = images;
    }

    public Muscle(Muscle muscle){
        name = muscle.name;
        description = muscle.description;
        images = muscle.images;
        isInjured = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void removeImage(Image image) {
        images.remove(image);
    }

    public void removeAllImages() {
        images.clear();
    }
}
