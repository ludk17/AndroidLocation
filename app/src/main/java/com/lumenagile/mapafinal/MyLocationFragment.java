package com.lumenagile.mapafinal;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lumenagile.mapafinal.adapters.MyLocationAdapter;
import com.lumenagile.mapafinal.database.MapSqlHelper;
import com.lumenagile.mapafinal.models.MyLocation;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyLocationFragment extends Fragment {


    public MyLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_location, container, false);

        List<MyLocation> myLocations = getLocations();
        MyLocationAdapter adapter = new MyLocationAdapter(getContext(), R.layout.item_my_location, myLocations);

        ((ListView)view.findViewById(R.id.listView)).setAdapter(adapter);

        return view;

    }

    public List<MyLocation> getLocations() {

        List<MyLocation> myLocations = new ArrayList<>();

        MapSqlHelper sql = new MapSqlHelper(getContext(), "android", null, 1);
        SQLiteDatabase db = sql.getWritableDatabase();

       Cursor cursor = db.rawQuery("select * from locations", null);

        while (cursor.moveToNext())
        {
            MyLocation myLocation = new MyLocation();

            myLocation.longitude = cursor.getString(1);
            myLocation.latitude = cursor.getString(2);
            myLocation.time = cursor.getString(3);

            myLocations.add(myLocation);
        }

        return myLocations;
    }

}
