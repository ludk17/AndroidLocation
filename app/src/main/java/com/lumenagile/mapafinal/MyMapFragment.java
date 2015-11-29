package com.lumenagile.mapafinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lumenagile.mapafinal.adapters.MyLocationAdapter;
import com.lumenagile.mapafinal.database.MapSqlHelper;
import com.lumenagile.mapafinal.models.MyLocation;

import java.util.List;

/**
 * Created by ludk on 28/11/15.
 */
public class MyMapFragment extends SupportMapFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GoogleMap map = getMap();

        MapSqlHelper sql = new MapSqlHelper(getContext(), "android", null, 1);

        SQLiteDatabase db = sql.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from locations", null);

        while (cursor.moveToNext()) {

            MarkerOptions marker = new MarkerOptions();

            marker.position(new LatLng(cursor.getDouble(2), cursor.getDouble(1)));

            map.addMarker(marker);
        }




    }
}
