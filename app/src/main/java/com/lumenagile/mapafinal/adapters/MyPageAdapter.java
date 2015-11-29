package com.lumenagile.mapafinal.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.google.android.gms.maps.SupportMapFragment;
import com.lumenagile.mapafinal.MyLocationFragment;
import com.lumenagile.mapafinal.MyMapFragment;

/**
 * Created by ludk on 28/11/15.
 */
public class MyPageAdapter extends FragmentPagerAdapter {
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            return new MyLocationFragment();
        }
        else{
            return new MyMapFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
