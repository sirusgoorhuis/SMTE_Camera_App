package com.camera.sirusgoorhuis.camera_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.marcinmoskala.arcseekbar.ProgressListener;

public class sliderPrototype extends AppCompatActivity {

    ArcSeekBar defaultSeekBar,seekBarBackground,gradientSeekBar;
    TextView seekBarMeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_slider_prototype);
        seekBarMeter = findViewById(R.id.sliderLeft);

        defaultSeekBar = (ArcSeekBar)findViewById(R.id.defaultSeekBar);
        //seekBarBackground = (ArcSeekBar)findViewById(R.id.seekBarBackground);
        //gradientSeekBar = (ArcSeekBar)findViewById(R.id.gradientSeekBar);

        //set gradient
        //int[] colorArrays = getResources().getIntArray(R.array.gradient);
        //gradientSeekBar.setProgressGradient(colorArrays);

        //set event
        defaultSeekBar.setOnProgressChangedListener(new ProgressListener() {
            @Override
            public void invoke(int i) {
                //Log.d("VALUE",""+i);
                seekBarMeter.setText(""+i);

            }
        });
    }
}
