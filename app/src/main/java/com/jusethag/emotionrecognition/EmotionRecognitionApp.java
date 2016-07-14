package com.jusethag.emotionrecognition;

import android.app.Application;

import com.firebase.client.Firebase;
import com.jusethag.emotionrecognition.domain.di.DomainModule;
import com.jusethag.emotionrecognition.lib.di.LibsModule;


import com.jusethag.emotionrecognition.login.di.DaggerLoginComponent;
import com.jusethag.emotionrecognition.login.di.LoginComponent;
import com.jusethag.emotionrecognition.login.di.LoginModule;
import com.jusethag.emotionrecognition.login.ui.LoginView;

/**
 * Created by JusethAg on 7/12/16.
 */

public class EmotionRecognitionApp extends Application {

    private LibsModule libsModule;
    private DomainModule domainModule;
    private EmotionRecognitionAppModule emotionRecognitionAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();
        emotionRecognitionAppModule = new EmotionRecognitionAppModule(this);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }


    public LoginComponent getLoginComponent(LoginView loginView) {

        return DaggerLoginComponent
                .builder()
                .libsModule(libsModule)
                //.emotionRecognitionAppModule(emotionRecognitionAppModule)
                .domainModule(domainModule)
                .loginModule(new LoginModule(loginView))
                .build();
    }
}
