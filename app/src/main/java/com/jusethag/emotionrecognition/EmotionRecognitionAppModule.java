package com.jusethag.emotionrecognition;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 7/13/16.
 */
@Module
public class EmotionRecognitionAppModule {
    Application application;

    public EmotionRecognitionAppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context providesContext(Application application){
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return this.application;
    }
}
