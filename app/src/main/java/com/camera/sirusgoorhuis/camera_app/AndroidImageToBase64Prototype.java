package com.camera.sirusgoorhuis.camera_app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class AndroidImageToBase64Prototype extends AppCompatActivity {

    Button toBase64, toImage;
    TextView outputText;
    String outputString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_image_to_base64_prototype);

        outputText = (TextView) findViewById(R.id.outputBase64);

        toBase64 = (Button) findViewById(R.id.toBase64);
        toImage = (Button) findViewById(R.id.toImage);

        toBase64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              todo: can't find the image path, gets a nullpointer exception when the button "IMAGE TO BASE64" is pressed
                outputString = imageToBase64("drawable://" + R.drawable.harold);
                outputText.setText(outputString);
            }
        });

    }

    // IMAGE TO BASE64
    private String imageToBase64(String imagePath) {
        Bitmap bm = BitmapFactory.decodeFile(imagePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArrayImage = baos.toByteArray();
        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
        return encodedImage;
    }

    // BASE64 TO IMAGE
    private Bitmap Base64ToImage(String encodedImage) {
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

}
