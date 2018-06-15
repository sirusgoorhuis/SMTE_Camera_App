package com.camera.sirusgoorhuis.camera_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class AndroidInventory extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private RollAdapter rollAdapter;
    private List<Roll> rollList = new ArrayList<>();
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_inventory);

        initData();
        mTitle = (TextSwitcher)findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(AndroidInventory.this);
                TextView txt = (TextView)inflater.inflate(R.layout.layout_title, null);
                return txt;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        //
        rollAdapter = new RollAdapter(rollList,this);
        coverFlow = (FeatureCoverFlow)findViewById(R.id.coverFlow);
        coverFlow.setAdapter(rollAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(rollList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });


    }

    private void initData() {
        rollList.add(new Roll("Portra", "http://i3.kym-cdn.com/photos/images/newsfeed/000/839/199/8a9.jpg"));
        rollList.add(new Roll("Ektar", "https://static.downtowncamera.com/2015/12/7787-500x-1-film-view.jpg"));
        rollList.add(new Roll("Ilford", "https://static.bhphoto.com/images/images500x500/1249917577000_25310.jpg"));

    }
}
