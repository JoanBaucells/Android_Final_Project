package com.uvic.padlemanager.Aplication_Class;

import android.app.Application;

import com.uvic.padlemanager.Singleton.App_singleton;

public class App_aplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        App_singleton.getInstance().setContext(this);
    }
}