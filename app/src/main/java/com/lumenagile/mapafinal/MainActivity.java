package com.lumenagile.mapafinal;

import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lumenagile.mapafinal.listener.MyLocationListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveCurrentLocation(View view)
    {
        setCurrentLocation();

        Toast.makeText(this, "Se guardo ubicación correctamente", Toast.LENGTH_SHORT).show();
    }

    public void openLocationsActivity(View view)
    {
        Intent intent = new Intent(this, MyLocationActivity.class);
        startActivity(intent);
    }

    private void setCurrentLocation() {


        LocationManager manager = (LocationManager)getSystemService(LOCATION_SERVICE);

        //if ( manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {

            LocationListener listener = new MyLocationListener(getApplicationContext());
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, listener);

        //}
    }
}
