package com.gridmi.weather_test;

import android.app.Application;

import com.gridmi.weather_test.tools.API;

import java.io.File;

import okhttp3.Cache;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final int cacheSize = 8 * 1024 * 1024;
        API.client = API.client.newBuilder().cache(new Cache(new File(getCacheDir(), "http-cache"),cacheSize)).build();

    }

}
