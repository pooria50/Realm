package com.example.pooria.myapplication.Realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealmm.realm")
                .schemaVersion(0)
                .build();

        Realm.setDefaultConfiguration(config);

    }
}
