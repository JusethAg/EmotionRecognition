package com.jusethag.emotionrecognition.lib.di;

import com.jusethag.emotionrecognition.lib.GreenRobotEventBus;
import com.jusethag.emotionrecognition.lib.base.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 7/12/16.
 */

@Module
public class LibsModule {

    @Provides
    @Singleton
    EventBus providesEventBus(){
        return new GreenRobotEventBus();
    }

}
