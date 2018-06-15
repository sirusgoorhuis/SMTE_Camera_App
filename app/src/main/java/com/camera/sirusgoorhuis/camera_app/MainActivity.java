package com.camera.sirusgoorhuis.camera_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.camera.sirusgoorhuis.camera_app.retrospective.RetrospectiveActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToAndroidCameraPrototype(View view) {
        startActivity(new Intent(MainActivity.this, AndroidCameraPrototypeActivity.class));
    }

    public void goToAndroidDataEncryptionPrototype(View view) {
        startActivity(new Intent(MainActivity.this, AndroidDataEncryptionActivity.class));
    }

    public void goToAndroidImageToBase64Prototype(View view)  {
        startActivity(new Intent(MainActivity.this, AndroidImageToBase64Prototype.class));
    }

    public void goToRetrospective(View view) {
        startActivity(new Intent(MainActivity.this, RetrospectiveActivity.class));
    }

    public void goToSliderPrototype(View view)
    {
        startActivity(new Intent(MainActivity.this, sliderPrototype.class));
    }
}
