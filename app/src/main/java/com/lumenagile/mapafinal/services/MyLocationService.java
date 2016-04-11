package com.lumenagile.mapafinal.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lumenagile.mapafinal.database.MapSqlHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ludk on 28/11/15.
 */
public class MyLocationService {

    private Context context;

    public MyLocationService(Context context) {
        this.context = context;
    }


    public void saveLocation(double longitude, double latitude) {


        MapSqlHelper sql = new MapSqlHelper(context, "android", null, 1);

        SQLiteDatabase db = sql.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("longitude", longitude);
        values.put("latitude", latitude);
        values.put("time", getTime());

        db.insert("locations", null, values);

        db.close();

    }



    private String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }



}
