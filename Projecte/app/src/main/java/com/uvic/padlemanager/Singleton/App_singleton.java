package com.uvic.padlemanager.Singleton;

public class App_singleton {
    private static class SingletonInstance {
        private static App_singleton INSTANCE = new App_singleton();
    }

    public static App_singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private App_singleton() {
//Constructor Singleton
    }
}