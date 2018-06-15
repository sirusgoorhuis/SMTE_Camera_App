package com.camera.sirusgoorhuis.camera_app;

import android.widget.ImageButton;

/**
 * Created by Ruud on 15-6-2018.
 */

public class Roll {
    private String Name,ImageURL;

    public Roll(String name, String imageURL)
    {
        Name = name;
        ImageURL = imageURL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
