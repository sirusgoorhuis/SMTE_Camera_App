package com.camera.sirusgoorhuis.camera_app.retrospective;

public class FilmRoll {
    private String name;
    private int exposures;

    public FilmRoll(String name, int exposures) {
        this.name = name;
        this.exposures = exposures;
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
}
