package com.droidfactory.skp.realmsamples;

import android.app.Application;

import com.facebook.stetho.*;
import com.uphyca.stetho_realm.*;

/**
 * Created by Shashi Pal on 5/18/2017.
 */

public class RealmSampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        if (BuildConfig.DEBUG) {
//        initiliazeStethoWithSQLiteDB();
            initiliazeStethoWithRealmDB();
//        }
    }

    private void initiliazeStethoWithRealmDB() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
    }

    private void initiliazeStethoWithSQLiteDB() {
        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        // Enable command line interface
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(this)
        );

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);
    }
}
