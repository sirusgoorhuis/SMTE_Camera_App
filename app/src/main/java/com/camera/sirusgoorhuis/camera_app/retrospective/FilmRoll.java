package com.camera.sirusgoorhuis.camera_app.retrospective;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class FilmRoll {
    private String name;
    private int exposures;
    private List<Image> images;


    public FilmRoll(String name, int exposures) {
        this.name = name;
        this.exposures = exposures;
        this.images = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExposures() {
        return exposures;
    }

    public void setExposures(int exposures) {
        this.exposures = exposures;
    }

    public List<Image> getImages() {
        return images;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }
}
