package com.lumenagile.mapafinal.listener;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.lumenagile.mapafinal.database.MapSqlHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ludk on 28/11/15.
 */
public class MyLocationListener implements LocationListener {

    private Context context;

    public MyLocationListener(Context context) {
        this.context = context;
    }

    @Override
    public void onLocationChanged(Location location) {


        MapSqlHelper sql = new MapSqlHelper(context, "android", null, 1);

        SQLiteDatabase db = sql.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("longitude", location.getLongitude());
        values.put("latitude", location.getLatitude());
        values.put("time", getTime());

        db.insert("locations", null, values);



        db.close();


    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }



    private String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }



}
