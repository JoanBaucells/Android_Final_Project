package com.uvic.jbaucellsssales.Singleton;

import android.app.Application;

import com.uvic.jbaucellsssales.Singleton.App_singleton;

public class App_aplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        App_singleton.getInstance().setContext(this);
    }
}