package com.lumenagile.mapafinal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lumenagile.mapafinal.R;
import com.lumenagile.mapafinal.models.MyLocation;

import java.util.List;

/**
 * Created by ludk on 28/11/15.
 */
public class MyLocationAdapter extends ArrayAdapter<MyLocation> {

    private int resource;

    public MyLocationAdapter(Context context, int resource, List<MyLocation> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)

            convertView = inflater.inflate(resource, parent, false);


        MyLocation myLocation = getItem(position);

        ((TextView)(convertView.findViewById(R.id.txtTime))).setText(myLocation.time);
        ((TextView)(convertView.findViewById(R.id.txtLatitude))).setText(myLocation.latitude);
        ((TextView)(convertView.findViewById(R.id.txtLongitude))).setText(myLocation.longitude);



        return convertView;
    }
}
