package com.camera.sirusgoorhuis.camera_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.camera.sirusgoorhuis.camera_app.retrospective.CameraActivity;

public class AndroidMainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_main_menu);
    }

    public void goToCamera(View view) {
        startActivity(new Intent(AndroidMainMenu.this, CameraActivity.class));
    }

    public void goToAndroidInventory(View view) {
        startActivity(new Intent(AndroidMainMenu.this, AndroidInventory.class));
    }

    public void goToAndroidGallery(View view) {
        startActivity(new Intent(AndroidMainMenu.this, AndroidGallery.class));
    }

    public void goToAndroidShop(View view) {
        startActivity(new Intent(AndroidMainMenu.this, AndroidShop.class));
    }
}
