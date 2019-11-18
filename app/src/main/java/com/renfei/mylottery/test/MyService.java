package com.renfei.mylottery.test;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    private LocationManager locationManager;
    private boolean isGPSEnabled = false;

    private MyLocationListener myLocationListener;
    private Location mLocation = null;
    private long INTERVAL_TIME = 50L;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "MyService    onCreate");
        initLocation();
    }

    private void initLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        //判断gps是否可用
        if (isGPSEnabled) {
            Log.e(TAG, "MyService   initLocation    gps可用");
            startLocation();
        } else {
            Log.e(TAG, "MyService   initLocation    gps不可用");
            Log.e(TAG, "—————————initData———————————");
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "MyService    onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    private void startLocation() {
        Log.e(TAG, "MyService    startLocation");
        registerListener();

    }

    @SuppressLint("MissingPermission")
    private void registerListener() {
        Log.e(TAG, "MyService    registerListener");
        myLocationListener = new MyLocationListener();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, INTERVAL_TIME, 0.0f, myLocationListener);
    }


    class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            Log.e(TAG, "MyService   onLocationChanged    ");
            mLocation = new Location(location);

            Log.e(TAG, location.getLatitude() + "  ---     " + location.getLongitude());

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
    }
}
