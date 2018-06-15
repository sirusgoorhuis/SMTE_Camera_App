package com.camera.sirusgoorhuis.camera_app;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Ruud on 15-6-2018.
 */

public class RollAdapter extends BaseAdapter{

    private List<Roll> rollList;
    private Context mContext;

    public RollAdapter(List<Roll> rollList, Context mContext) {
        this.rollList = rollList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return rollList.size();
    }

    @Override
    public Object getItem(int i) {
        return rollList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if(rowView == null)
        {
            rowView = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
            TextView name = (TextView)rowView.findViewById(R.id.label);
            ImageView image = (ImageView)rowView.findViewById(R.id.image);

            //set data
            Picasso.with(mContext).load(rollList.get(i).getImageURL()).into(image);
            name.setText(rollList.get(i).getName());
        }
        return rowView;

    }
}
