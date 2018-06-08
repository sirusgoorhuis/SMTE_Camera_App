package com.camera.sirusgoorhuis.camera_app.retrospective;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.camera.sirusgoorhuis.camera_app.R;

import java.util.ArrayList;
import java.util.List;

public class RetrospectiveActivity extends AppCompatActivity {
    private static List<String> encryptedPhotos;
    private static List<Bitmap> photos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        encryptedPhotos = new ArrayList<>();
        photos = new ArrayList<>();
        setContentView(R.layout.activity_retrospective);
    }

    public void goToCamera(View view) {
    }

    public void goToGallery(View view) {

    }

    public boolean develop() {
        for (String photo : encryptedPhotos) {
            addDecryptedPhoto(Security.decrypt(photo));
        }
        return true;
    }

    public static void addEncryptedPhoto(String photo) {
        encryptedPhotos.add(photo);
    }

    private static void addDecryptedPhoto(Bitmap image) {
        photos.add(image);
    }

    public static List<Bitmap> getPhotos() {
        return photos;
    }
}
