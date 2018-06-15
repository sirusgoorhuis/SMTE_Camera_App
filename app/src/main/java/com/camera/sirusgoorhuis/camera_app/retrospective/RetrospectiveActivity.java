package com.camera.sirusgoorhuis.camera_app.retrospective;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.camera.sirusgoorhuis.camera_app.R;
import com.camera.sirusgoorhuis.camera_app.retrospective.workerRunnable.ProcessPhotoRunnable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class RetrospectiveActivity extends AppCompatActivity {
    private static List<String> encryptedPhotos;
    private static List<Bitmap> photos;
    public static FilmRoll filmRoll;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        encryptedPhotos = new ArrayList<>();
        photos = new ArrayList<>();
        filmRoll = new FilmRoll("TestFilm", 12);
        setContentView(R.layout.activity_retrospective);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.addFilmRoll);
        editText.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
    }

    public void goToCamera(View view) {
        startActivity(new Intent(RetrospectiveActivity.this, CameraActivity.class));
    }

    public void goToGallery(View view) {

    }

    public void develop(View view) {
        if (filmRoll.getImages().size() != filmRoll.getExposures()) {
            Toast.makeText(RetrospectiveActivity.this, "You still have exposures left!", Toast.LENGTH_SHORT).show();
            return;
        }
        for (Image image : filmRoll.getImages()) {
            developImage(image);
        }
        editText.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
    }

    public void insertFilmRoll(View view) {
        String text = editText.getText().toString();
        if (text.matches("")) {
            Toast.makeText(RetrospectiveActivity.this, "Fill in a name for your filmroll!", Toast.LENGTH_SHORT).show();
        }
        else {
            filmRoll = new FilmRoll(text, 12);
            editText.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
        }
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

    private void developImage (Image image) {
        String filePath = Environment.getExternalStorageDirectory() +
                File.separator + "filmRoll" +
                File.separator + filmRoll.getName();
        File file = new File(filePath);
        OutputStream outputStream;
        try {
            ByteBuffer buffer = image.getPlanes()[0].getBuffer();
            byte[] bytes = new byte[buffer.capacity()];
            buffer.get(bytes);
            if (!file.exists()) file.mkdirs();
            File imageFile = new File(filePath +
                    File.separator +
                    "image " +
                    image.getTimestamp() +
                    ".jpg");
            outputStream = new FileOutputStream(imageFile);
            outputStream.write(bytes);
            outputStream.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
