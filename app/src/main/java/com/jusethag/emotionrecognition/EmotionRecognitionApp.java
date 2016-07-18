package com.jusethag.emotionrecognition;

import android.app.Application;

import com.firebase.client.Firebase;
import com.jusethag.emotionrecognition.domain.di.DomainModule;
import com.jusethag.emotionrecognition.lib.di.LibsModule;


import com.jusethag.emotionrecognition.login.di.DaggerLoginComponent;
import com.jusethag.emotionrecognition.login.di.LoginComponent;
import com.jusethag.emotionrecognition.login.di.LoginModule;
import com.jusethag.emotionrecognition.login.ui.LoginView;
import com.jusethag.emotionrecognition.main.di.DaggerMainListComponent;
import com.jusethag.emotionrecognition.main.di.MainListComponent;
import com.jusethag.emotionrecognition.main.di.MainListModule;
import com.jusethag.emotionrecognition.main.ui.MainListView;

/**
 * Created by JusethAg on 7/12/16.
 */

public class EmotionRecognitionApp extends Application {

    private LibsModule libsModule;
    private DomainModule domainModule;


    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();

    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }


    public LoginComponent getLoginComponent(LoginView loginView) {

        return DaggerLoginComponent
                .builder()
                .libsModule(libsModule)
                .domainModule(domainModule)
                .loginModule(new LoginModule(loginView))
                .build();
        //return null;
    }

    public MainListComponent getMainListComponent(MainListView mainListView) {
        return DaggerMainListComponent
                .builder()
                .libsModule(libsModule)
                .domainModule(domainModule)
                .mainListModule(new MainListModule(mainListView))
                .build();
        //return null;
    }
}
