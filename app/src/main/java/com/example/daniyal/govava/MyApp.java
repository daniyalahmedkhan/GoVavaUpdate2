package com.example.daniyal.govava;

import android.app.Application;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;

/**
 * Created by Daniyal on 10/6/2017.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(2000);
    }
}
