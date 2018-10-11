package com.example.rumpi.gitexample;


import android.app.Application;
import com.example.rumpi.gitexample.di.AppComponent;
import com.example.rumpi.gitexample.di.DaggerAppComponent;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainApp extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);

        component = DaggerAppComponent.builder().build();
    }


    public static AppComponent getComponent() {
        return component;
    }
}

