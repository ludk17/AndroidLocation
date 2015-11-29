package com.lumenagile.mapafinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.lumenagile.mapafinal.adapters.MyLocationAdapter;
import com.lumenagile.mapafinal.adapters.MyPageAdapter;
import com.lumenagile.mapafinal.database.MapSqlHelper;
import com.lumenagile.mapafinal.models.MyLocation;

import java.util.ArrayList;
import java.util.List;

public class MyLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);

        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));

        //setListContent();

    }




}
