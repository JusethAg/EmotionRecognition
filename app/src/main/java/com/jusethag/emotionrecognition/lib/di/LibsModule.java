package com.jusethag.emotionrecognition.lib.di;

import com.jusethag.emotionrecognition.lib.GreenRobotEventBus;
import com.jusethag.emotionrecognition.lib.RecognitionServiceClient;
import com.jusethag.emotionrecognition.lib.base.EmotionService;
import com.jusethag.emotionrecognition.lib.base.EventBus;
import com.microsoft.projectoxford.emotion.EmotionServiceRestClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 7/12/16.
 */

@Module
public class LibsModule {

    private final static String EMOTION_KEY = "EMOTION_KEY";

    @Provides
    @Singleton
    EventBus providesEventBus(){
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    EmotionService providesEmotionService() {
        return new RecognitionServiceClient(new EmotionServiceRestClient(EMOTION_KEY));
    }

}
